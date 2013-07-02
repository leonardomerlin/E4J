package br.unioeste.jgoose.e4j.swing.menu;

import com.mxgraph.swing.mxGraphOutline;
import com.mxgraph.util.mxResources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class OutlinePopupMenu extends JPopupMenu {

    public OutlinePopupMenu(final mxGraphOutline graphOutline) {
        JCheckBoxMenuItem itemMagnifyPage = new MagnifyPageMenuItem(graphOutline);
        JCheckBoxMenuItem itemShowLabel = new ShowLabelsMenuItem(graphOutline);

        this.add(itemMagnifyPage);
        this.add(itemShowLabel);
    }

    private class MagnifyPageMenuItem extends JCheckBoxMenuItem {

        public MagnifyPageMenuItem(final mxGraphOutline graphOutline) {
            super(mxResources.get("magnifyPage"));
            setSelected(graphOutline.isFitPage());

            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    graphOutline.setFitPage(!graphOutline.isFitPage());
                    graphOutline.repaint();
                }
            });
        }
    }

    private class ShowLabelsMenuItem extends JCheckBoxMenuItem {

        public ShowLabelsMenuItem(final mxGraphOutline graphOutline) {
            this.setSelected(graphOutline.isDrawLabels());
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    graphOutline.setDrawLabels(!graphOutline.isDrawLabels());
                    graphOutline.repaint();
                }
            });
        }
    }

    private class BufferingMenuItem extends JCheckBoxMenuItem {

        public BufferingMenuItem(final mxGraphOutline graphOutline) {
            this.setSelected(graphOutline.isTripleBuffered());
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    graphOutline.setTripleBuffered(!graphOutline.isTripleBuffered());
                    graphOutline.repaint();
                }
            });
        }
    }
}
