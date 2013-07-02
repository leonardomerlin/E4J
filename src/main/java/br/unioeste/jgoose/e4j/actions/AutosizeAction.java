package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class AutosizeAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        mxGraph graph = mxGraphActions.getGraph(e);
        if (graph != null && !graph.isSelectionEmpty()) {
            Object[] cells = graph.getSelectionCells();
            mxIGraphModel model = graph.getModel();
            model.beginUpdate();
            try {
                for (int i = 0; i < cells.length; i++) {
                    graph.updateCellSize(cells[i]);
                }
            } finally {
                model.endUpdate();
            }
        }
    }
}
