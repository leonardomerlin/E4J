package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.ScaleAction;
import br.unioeste.jgoose.e4j.actions.ToggleGridItem;
import br.unioeste.jgoose.e4j.actions.TogglePropertyItem;
import br.unioeste.jgoose.e4j.actions.ToggleRulersItem;
import br.unioeste.jgoose.e4j.actions.ZoomPolicyAction;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxResources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class ViewJMenu extends JMenu {

    public ViewJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("view"));
        final mxGraphComponent graphComponent = editor.getGraphComponent();
        
        JMenuItem item = add(new TogglePropertyItem(graphComponent, mxResources.get("pageLayout"), "PageVisible", true,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (graphComponent.isPageVisible() && graphComponent.isCenterPage()) {
                    graphComponent.zoomAndCenter();
                } else {
                    graphComponent.getGraphControl().updatePreferredSize();
                }
            }
        }));

        // Centralize the map
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof TogglePropertyItem) {
                    final mxGraphComponent graphComponent = editor.getGraphComponent();
                    TogglePropertyItem toggleItem = (TogglePropertyItem) e.getSource();

                    if (toggleItem.isSelected()) {
                        // Scrolls the view to the center
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                graphComponent.scrollToCenter(true);
                                graphComponent.scrollToCenter(false);
                            }
                        });
                    } else {
                        // Resets the translation of the view
                        mxPoint tr = graphComponent.getGraph().getView().getTranslate();

                        if (tr.getX() != 0 || tr.getY() != 0) {
                            graphComponent.getGraph().getView().setTranslate(new mxPoint());
                        }
                    }
                }
            }
        });

        add(new TogglePropertyItem(graphComponent, mxResources.get("antialias"), "AntiAlias", true));

        addSeparator();
        add(new ToggleGridItem(editor, mxResources.get("grid")));
        add(new ToggleRulersItem(editor, mxResources.get("rulers")));

        addSeparator();

        JMenu submenu = (JMenu) add(new JMenu(mxResources.get("zoom")));

        submenu.add(editor.bind("400%", new ScaleAction(4)));
        submenu.add(editor.bind("200%", new ScaleAction(2)));
        submenu.add(editor.bind("150%", new ScaleAction(1.5)));
        submenu.add(editor.bind("100%", new ScaleAction(1)));
        submenu.add(editor.bind("75%", new ScaleAction(0.75)));
        submenu.add(editor.bind("50%", new ScaleAction(0.5)));

        submenu.addSeparator();
        submenu.add(editor.bind(mxResources.get("custom"), new ScaleAction(0)));

        addSeparator();
        add(editor.bind(mxResources.get("zoomIn"), mxGraphActions.getZoomInAction()));
        add(editor.bind(mxResources.get("zoomOut"), mxGraphActions.getZoomOutAction()));

        addSeparator();
        add(editor.bind(mxResources.get("page"), new ZoomPolicyAction(mxGraphComponent.ZOOM_POLICY_PAGE)));
        add(editor.bind(mxResources.get("width"), new ZoomPolicyAction(mxGraphComponent.ZOOM_POLICY_WIDTH)));

        addSeparator();
        add(editor.bind(mxResources.get("actualSize"), mxGraphActions.getZoomActualAction()));

    }
}
