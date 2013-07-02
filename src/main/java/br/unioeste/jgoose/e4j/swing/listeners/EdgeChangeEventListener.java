package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.CustomGraph;
import com.mxgraph.swing.util.mxGraphTransferable;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import org.apache.log4j.Logger;

/**
 * When has a selected cell and is dragged to a new element,
 * the edge created will be equal to edge that is selected at the palette.
 * If no one is selected, a default edge is created.
 * 
 * Likewise:
 * If an edge is clicked in the shape palette
 * sets the edge template to be used for creating new edges.
 * 
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class EdgeChangeEventListener implements mxEventSource.mxIEventListener {

    private static final Logger CONSOLE = Logger.getLogger("console");
    private final mxGraph graph;

    public EdgeChangeEventListener(mxGraph graph) {
        this.graph = graph;
    }

    @Override
    public void invoke(Object sender, mxEventObject evt) {
        CONSOLE.debug("a element of palette is selected");
        Object possiblyTransferable = evt.getProperty("transferable");

        if (possiblyTransferable instanceof mxGraphTransferable) {
            CONSOLE.debug("the element is transferable (edge!?)");
            mxGraphTransferable transferable = (mxGraphTransferable) possiblyTransferable;
            Object cell = transferable.getCells()[0];

            // if the cell is a Edge, then change the template
            if (graph.getModel().isEdge(cell)) {
                CONSOLE.debug("the cell is a edge and it will be set a edge template");
                ((CustomGraph) graph).setEdgeTemplate(cell);
            }
        }
    }
}
