package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.menu.GraphPopupMenu;
import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class GraphControlMenuMouseAdapter extends MouseAdapter {

    private BasicGraphEditor basicGraphEditor;
    private mxGraphComponent graphComponent;

    public GraphControlMenuMouseAdapter(BasicGraphEditor basicGraphEditor, mxGraphComponent graphComponent) {
        this.basicGraphEditor = basicGraphEditor;
        this.graphComponent = graphComponent;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on mousepressed
        mouseReleased(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            Point pt = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),
                    graphComponent);
            GraphPopupMenu menu = new GraphPopupMenu(basicGraphEditor);
            menu.show(graphComponent, pt.x, pt.y);

            e.consume();
        }
    }
}
