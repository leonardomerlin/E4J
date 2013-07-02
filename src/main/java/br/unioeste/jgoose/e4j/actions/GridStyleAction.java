package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.mxGraphComponent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class GridStyleAction extends AbstractAction {
    protected int style;

    public GridStyleAction(int style) {
        this.style = style;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            graphComponent.setGridStyle(style);
            graphComponent.repaint();
        }
    }

}
