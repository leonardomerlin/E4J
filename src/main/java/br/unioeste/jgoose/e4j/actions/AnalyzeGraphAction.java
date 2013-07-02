package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.menubar.AnalyzeType;
import com.mxgraph.analysis.StructuralException;
import com.mxgraph.analysis.mxAnalysisGraph;
import com.mxgraph.analysis.mxGraphProperties;
import com.mxgraph.analysis.mxGraphStructure;
import com.mxgraph.analysis.mxTraversal;
import com.mxgraph.costfunction.mxCostFunction;
import com.mxgraph.model.mxIGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxGraphView;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;

/**
 *
 */
public class AnalyzeGraphAction extends AbstractAction {
    /**
     *
     */
    private static final long serialVersionUID = 6926170745240507985L;
    mxAnalysisGraph aGraph;
    /**
     *
     */
    protected AnalyzeType analyzeType;

    /**
     * Examples for calling analysis methods from mxGraphStructure
     */
    public AnalyzeGraphAction(AnalyzeType analyzeType, mxAnalysisGraph aGraph) {
        this.analyzeType = analyzeType;
        this.aGraph = aGraph;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxGraph graph = graphComponent.getGraph();
            if (analyzeType == AnalyzeType.IS_CONNECTED) {
                boolean isConnected = mxGraphStructure.isConnected(aGraph);
                if (isConnected) {
                    System.out.println("The graph is connected");
                } else {
                    System.out.println("The graph is not connected");
                }
            } else if (analyzeType == AnalyzeType.IS_SIMPLE) {
                boolean isSimple = mxGraphStructure.isSimple(aGraph);
                if (isSimple) {
                    System.out.println("The graph is simple");
                } else {
                    System.out.println("The graph is not simple");
                }
            } else if (analyzeType == AnalyzeType.IS_CYCLIC_DIRECTED) {
                boolean isCyclicDirected = mxGraphStructure.isCyclicDirected(aGraph);
                if (isCyclicDirected) {
                    System.out.println("The graph is cyclic directed");
                } else {
                    System.out.println("The graph is acyclic directed");
                }
            } else if (analyzeType == AnalyzeType.IS_CYCLIC_UNDIRECTED) {
                boolean isCyclicUndirected = mxGraphStructure.isCyclicUndirected(aGraph);
                if (isCyclicUndirected) {
                    System.out.println("The graph is cyclic undirected");
                } else {
                    System.out.println("The graph is acyclic undirected");
                }
            } else if (analyzeType == AnalyzeType.COMPLEMENTARY) {
                graph.getModel().beginUpdate();
                mxGraphStructure.complementaryGraph(aGraph);
                mxGraphStructure.setDefaultGraphStyle(aGraph, true);
                graph.getModel().endUpdate();
            } else if (analyzeType == AnalyzeType.REGULARITY) {
                try {
                    int regularity = mxGraphStructure.regularity(aGraph);
                    System.out.println("Graph regularity is: " + regularity);
                } catch (StructuralException e1) {
                    System.out.println("The graph is irregular");
                }
            } else if (analyzeType == AnalyzeType.COMPONENTS) {
                Object[][] components = mxGraphStructure.getGraphComponents(aGraph);
                mxIGraphModel model = aGraph.getGraph().getModel();
                for (int i = 0; i < components.length; i++) {
                    System.out.print("Component " + i + " :");
                    for (int j = 0; j < components[i].length; j++) {
                        System.out.print(" " + model.getValue(components[i][j]));
                    }
                    System.out.println(".");
                }
                System.out.println("Number of components: " + components.length);
            } else if (analyzeType == AnalyzeType.MAKE_CONNECTED) {
                graph.getModel().beginUpdate();
                if (!mxGraphStructure.isConnected(aGraph)) {
                    mxGraphStructure.makeConnected(aGraph);
                    mxGraphStructure.setDefaultGraphStyle(aGraph, false);
                }
                graph.getModel().endUpdate();
            } else if (analyzeType == AnalyzeType.MAKE_SIMPLE) {
                mxGraphStructure.makeSimple(aGraph);
            } else if (analyzeType == AnalyzeType.IS_TREE) {
                boolean isTree = mxGraphStructure.isTree(aGraph);
                if (isTree) {
                    System.out.println("The graph is a tree");
                } else {
                    System.out.println("The graph is not a tree");
                }
            } else if (analyzeType == AnalyzeType.ONE_SPANNING_TREE) {
                try {
                    graph.getModel().beginUpdate();
                    aGraph.getGenerator().oneSpanningTree(aGraph, true, true);
                    mxGraphStructure.setDefaultGraphStyle(aGraph, false);
                    graph.getModel().endUpdate();
                } catch (StructuralException e1) {
                    System.out.println("The graph must be simple and connected");
                }
            } else if (analyzeType == AnalyzeType.IS_DIRECTED) {
                boolean isDirected = mxGraphProperties.isDirected(aGraph.getProperties(), mxGraphProperties.DEFAULT_DIRECTED);
                if (isDirected) {
                    System.out.println("The graph is directed.");
                } else {
                    System.out.println("The graph is undirected.");
                }
            } else if (analyzeType == AnalyzeType.GET_CUT_VERTEXES) {
                Object[] cutVertices = mxGraphStructure.getCutVertices(aGraph);
                System.out.print("Cut vertices of the graph are: [");
                mxIGraphModel model = aGraph.getGraph().getModel();
                for (int i = 0; i < cutVertices.length; i++) {
                    System.out.print(" " + model.getValue(cutVertices[i]));
                }
                System.out.println(" ]");
            } else if (analyzeType == AnalyzeType.GET_CUT_EDGES) {
                Object[] cutEdges = mxGraphStructure.getCutEdges(aGraph);
                System.out.print("Cut edges of the graph are: [");
                mxIGraphModel model = aGraph.getGraph().getModel();
                for (int i = 0; i < cutEdges.length; i++) {
                    System.out.print(" " + Integer.parseInt((String) model.getValue(aGraph.getTerminal(cutEdges[i], true))) + "-" + Integer.parseInt((String) model.getValue(aGraph.getTerminal(cutEdges[i], false))));
                }
                System.out.println(" ]");
            } else if (analyzeType == AnalyzeType.GET_SOURCES) {
                try {
                    Object[] sourceVertices = mxGraphStructure.getSourceVertices(aGraph);
                    System.out.print("Source vertices of the graph are: [");
                    mxIGraphModel model = aGraph.getGraph().getModel();
                    for (int i = 0; i < sourceVertices.length; i++) {
                        System.out.print(" " + model.getValue(sourceVertices[i]));
                    }
                    System.out.println(" ]");
                } catch (StructuralException e1) {
                    System.out.println(e1);
                }
            } else if (analyzeType == AnalyzeType.GET_SINKS) {
                try {
                    Object[] sinkVertices = mxGraphStructure.getSinkVertices(aGraph);
                    System.out.print("Sink vertices of the graph are: [");
                    mxIGraphModel model = aGraph.getGraph().getModel();
                    for (int i = 0; i < sinkVertices.length; i++) {
                        System.out.print(" " + model.getValue(sinkVertices[i]));
                    }
                    System.out.println(" ]");
                } catch (StructuralException e1) {
                    System.out.println(e1);
                }
            } else if (analyzeType == AnalyzeType.PLANARITY) {
                //TODO implement
            } else if (analyzeType == AnalyzeType.IS_BICONNECTED) {
                boolean isBiconnected = mxGraphStructure.isBiconnected(aGraph);
                if (isBiconnected) {
                    System.out.println("The graph is biconnected.");
                } else {
                    System.out.println("The graph is not biconnected.");
                }
            } else if (analyzeType == AnalyzeType.GET_BICONNECTED) {
                //TODO implement
            } else if (analyzeType == AnalyzeType.SPANNING_TREE) {
                //TODO implement
            } else if (analyzeType == AnalyzeType.FLOYD_ROY_WARSHALL) {
                ArrayList<Object[][]> FWIresult = new ArrayList<Object[][]>();
                try {
                    //only this line is needed to get the result from Floyd-Roy-Warshall, the rest is code for displaying the result
                    FWIresult = mxTraversal.floydRoyWarshall(aGraph);
                    Object[][] dist = FWIresult.get(0);
                    Object[][] paths = FWIresult.get(1);
                    Object[] vertices = aGraph.getChildVertices(aGraph.getGraph().getDefaultParent());
                    int vertexNum = vertices.length;
                    System.out.println("Distances are:");
                    for (int i = 0; i < vertexNum; i++) {
                        System.out.print("[");
                        for (int j = 0; j < vertexNum; j++) {
                            System.out.print(" " + Math.round((Double) dist[i][j] * 100.0) / 100.0);
                        }
                        System.out.println("] ");
                    }
                    System.out.println("Path info:");
                    mxCostFunction costFunction = aGraph.getGenerator().getCostFunction();
                    mxGraphView view = aGraph.getGraph().getView();
                    for (int i = 0; i < vertexNum; i++) {
                        System.out.print("[");
                        for (int j = 0; j < vertexNum; j++) {
                            if (paths[i][j] != null) {
                                System.out.print(" " + costFunction.getCost(view.getState(paths[i][j])));
                            } else {
                                System.out.print(" -");
                            }
                        }
                        System.out.println(" ]");
                    }
                    try {
                        Object[] path = mxTraversal.getWFIPath(aGraph, FWIresult, vertices[0], vertices[vertexNum - 1]);
                        System.out.print("The path from " + costFunction.getCost(view.getState(vertices[0])) + " to " + costFunction.getCost(view.getState(vertices[vertexNum - 1])) + " is:");
                        for (int i = 0; i < path.length; i++) {
                            System.out.print(" " + costFunction.getCost(view.getState(path[i])));
                        }
                        System.out.println();
                    } catch (StructuralException e1) {
                        System.out.println(e1);
                    }
                } catch (StructuralException e2) {
                    System.out.println(e2);
                }
            }
        }
    }

}
