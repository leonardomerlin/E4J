package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.util.mxResources;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class ZoomWheelTracker implements MouseWheelListener {

    private BasicGraphEditor basicGraphEditor;
    private mxGraphComponent graphComponent;

    public ZoomWheelTracker(BasicGraphEditor basicGraphEditor, mxGraphComponent graphComponent) {
        this.basicGraphEditor = basicGraphEditor;
        this.graphComponent = graphComponent;
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getSource() instanceof mxGraphOutline || e.isControlDown()) {
            if (e.getWheelRotation() < 0) {
                graphComponent.zoomIn();
            } else {
                graphComponent.zoomOut();
            }

            basicGraphEditor.status(mxResources.get("scale") + ": "
                    + (int) (100 * graphComponent.getGraph().getView().getScale())
                    + "%");
        }
    }
}
