package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.menu.OutlinePopupMenu;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.mxGraphOutline;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class OutlineMenuMouseAdapter extends MouseAdapter {

    private mxGraphComponent graphComponent;
    private mxGraphOutline graphOutline;

    public OutlineMenuMouseAdapter(mxGraphComponent graphComponent, mxGraphOutline graphOutline) {
        this.graphComponent = graphComponent;
        this.graphOutline = graphOutline;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handles context menu on the Mac where the trigger is on mousepressed
        mouseReleased(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            Point pt = SwingUtilities.convertPoint(
                    e.getComponent(),
                    e.getPoint(),
                    graphComponent);

            JPopupMenu menu = new OutlinePopupMenu(graphOutline);
            menu.show(graphComponent, pt.x, pt.y);

            e.consume();
        }
    }
}
