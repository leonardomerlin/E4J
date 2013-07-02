package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.analysis.mxDistanceCostFunction;
import com.mxgraph.analysis.mxGraphAnalysis;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings(value = "serial")
public class SelectShortestPathAction extends AbstractAction {
    protected boolean directed;

    public SelectShortestPathAction(boolean directed) {
        this.directed = directed;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxGraph graph = graphComponent.getGraph();
            mxIGraphModel model = graph.getModel();
            Object source = null;
            Object target = null;
            Object[] cells = graph.getSelectionCells();
            for (int i = 0; i < cells.length; i++) {
                if (model.isVertex(cells[i])) {
                    if (source == null) {
                        source = cells[i];
                    } else if (target == null) {
                        target = cells[i];
                    }
                }
                if (source != null && target != null) {
                    break;
                }
            }
            if (source != null && target != null) {
                int steps = graph.getChildEdges(graph.getDefaultParent()).length;
                Object[] path = mxGraphAnalysis.getInstance().getShortestPath(graph, source, target, new mxDistanceCostFunction(), steps, directed);
                graph.setSelectionCells(path);
            } else {
                JOptionPane.showMessageDialog(graphComponent, mxResources.get("noSourceAndTargetSelected"));
            }
        }
    }

}
