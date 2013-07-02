package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.PromptPropertyAction;
import br.unioeste.jgoose.e4j.actions.ToggleConnectModeAction;
import br.unioeste.jgoose.e4j.actions.ToggleCreateTargetItem;
import br.unioeste.jgoose.e4j.actions.ToggleDirtyAction;
import br.unioeste.jgoose.e4j.actions.TogglePropertyItem;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;

public class OptionsJMenu extends JMenu {

    public OptionsJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("options"));
        
        final mxGraphComponent graphComponent = editor.getGraphComponent();
        final mxGraph graph = graphComponent.getGraph();

        JMenu submenu = (JMenu) add(new JMenu(mxResources.get("display")));
        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("buffering"), "TripleBuffered", true));

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("preferPageSize"), "PreferPageSize", true, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphComponent.zoomAndCenter();
            }
        }));

        // TODO: This feature is not yet implemented
        //submenu.add(new TogglePropertyItem(graphComponent, mxResources
        //		.get("pageBreaks"), "PageBreaksVisible", true));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("tolerance"), new PromptPropertyAction(graphComponent, "Tolerance")));

        submenu.add(editor.bind(mxResources.get("dirty"), new ToggleDirtyAction()));

        submenu = (JMenu) add(new JMenu(mxResources.get("zoom")));

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("centerZoom"), "CenterZoom", true));
        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("zoomToSelection"), "KeepSelectionVisibleOnZoom", true));

        submenu.addSeparator();

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("centerPage"), "CenterPage", true, new ActionListener() {
            /**
             *
             */
            public void actionPerformed(ActionEvent e) {
                if (graphComponent.isPageVisible() && graphComponent.isCenterPage()) {
                    graphComponent.zoomAndCenter();
                }
            }
        }));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("dragAndDrop")));

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("dragEnabled"), "DragEnabled"));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("dropEnabled"), "DropEnabled"));

        submenu.addSeparator();

        submenu.add(new TogglePropertyItem(graphComponent.getGraphHandler(), mxResources.get("imagePreview"), "ImagePreview"));

        submenu = (JMenu) add(new JMenu(mxResources.get("labels")));

        submenu.add(new TogglePropertyItem(graph, mxResources.get("htmlLabels"), "HtmlLabels", true));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("showLabels"), "LabelsVisible", true));

        submenu.addSeparator();

        submenu.add(new TogglePropertyItem(graph, mxResources.get("moveEdgeLabels"), "EdgeLabelsMovable"));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("moveVertexLabels"), "VertexLabelsMovable"));

        submenu.addSeparator();

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("handleReturn"), "EnterStopsCellEditing"));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("connections")));

        submenu.add(new TogglePropertyItem(graphComponent, mxResources.get("connectable"), "Connectable"));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("connectableEdges"), "ConnectableEdges"));

        submenu.addSeparator();

        submenu.add(new ToggleCreateTargetItem(editor, mxResources.get("createTarget")));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("disconnectOnMove"), "DisconnectOnMove"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("connectMode"), new ToggleConnectModeAction()));

        submenu = (JMenu) add(new JMenu(mxResources.get("validation")));

        submenu.add(new TogglePropertyItem(graph, mxResources.get("allowDanglingEdges"), "AllowDanglingEdges"));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("cloneInvalidEdges"), "CloneInvalidEdges"));

        submenu.addSeparator();

        submenu.add(new TogglePropertyItem(graph, mxResources.get("allowLoops"), "AllowLoops"));
        submenu.add(new TogglePropertyItem(graph, mxResources.get("multigraph"), "Multigraph"));

    }
}
