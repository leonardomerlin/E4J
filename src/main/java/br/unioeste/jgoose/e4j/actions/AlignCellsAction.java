package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class AlignCellsAction extends AbstractAction {

    protected String align;

    /**
     *
     * @param key
     */
    public AlignCellsAction(String align) {
        this.align = align;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mxGraph graph = mxGraphActions.getGraph(e);
        if (graph != null && !graph.isSelectionEmpty()) {
            graph.alignCells(align);
        }
    }
}
