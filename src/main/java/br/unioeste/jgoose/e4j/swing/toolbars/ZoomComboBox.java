package br.unioeste.jgoose.e4j.swing.toolbars;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraphView;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ZoomComboBox extends JComboBox {

    private boolean ignoreZoomChange = false;
    private final mxGraphView view;

    public ZoomComboBox(mxGraphView view, final BasicGraphEditor editor) {
        super(new Object[]{
            "400%", "200%", "150%", "100%", "75%", "50%",
            mxResources.get("page"),
            mxResources.get("width"),
            mxResources.get("actualSize")
        });
        
        this.view = view;

        setEditable(true);
        setMinimumSize(new Dimension(75, 0));
        setPreferredSize(new Dimension(75, 0));
        setMaximumSize(new Dimension(75, 100));
        setMaximumRowCount(9);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mxGraphComponent graphComponent = editor.getGraphComponent();

                // Zoomcombo is changed when the scale is changed in the diagram
                // but the change is ignored here
                if (!ignoreZoomChange) {
                    String zoom = getSelectedItem().toString();

                    if (zoom.equals(mxResources.get("page"))) {
                        graphComponent.setPageVisible(true);
                        graphComponent
                                .setZoomPolicy(mxGraphComponent.ZOOM_POLICY_PAGE);
                    } else if (zoom.equals(mxResources.get("width"))) {
                        graphComponent.setPageVisible(true);
                        graphComponent
                                .setZoomPolicy(mxGraphComponent.ZOOM_POLICY_WIDTH);
                    } else if (zoom.equals(mxResources.get("actualSize"))) {
                        graphComponent.zoomActual();
                    } else {
                        try {
                            zoom = zoom.replace("%", "");
                            double scale = Math.min(16, Math.max(0.01,
                                    Double.parseDouble(zoom) / 100));
                            graphComponent.zoomTo(scale, graphComponent
                                    .isCenterZoom());
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog((Component) editor, ex
                                    .getMessage());
                        }
                    }
                }
            }
        });
    }

    public mxIEventListener getScaleTracker() {
        return new mxEventSource.mxIEventListener() {
            @Override
            public void invoke(Object sender, mxEventObject evt) {
                ignoreZoomChange = true;

                try {
                    Object sel = (int) Math.round(100 * view.getScale()) + "%";
                    setSelectedItem(sel);
                } finally {
                    ignoreZoomChange = false;
                }
            }
        };
    }
}
