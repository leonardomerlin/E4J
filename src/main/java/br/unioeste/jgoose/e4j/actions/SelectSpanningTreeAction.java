package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.analysis.mxDistanceCostFunction;
import com.mxgraph.analysis.mxGraphAnalysis;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class SelectSpanningTreeAction extends AbstractAction {

    protected boolean directed;

    public SelectSpanningTreeAction(boolean directed) {
        this.directed = directed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxGraph graph = graphComponent.getGraph();
            mxIGraphModel model = graph.getModel();
            Object parent = graph.getDefaultParent();
            Object[] cells = graph.getSelectionCells();
            for (int i = 0; i < cells.length; i++) {
                if (model.getChildCount(cells[i]) > 0) {
                    parent = cells[i];
                    break;
                }
            }
            Object[] v = graph.getChildVertices(parent);
            Object[] mst = mxGraphAnalysis.getInstance().getMinimumSpanningTree(graph, v, new mxDistanceCostFunction(), directed);
            graph.setSelectionCells(mst);
        }
    }
}
