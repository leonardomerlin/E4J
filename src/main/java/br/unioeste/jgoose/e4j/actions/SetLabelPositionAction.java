package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class SetLabelPositionAction extends AbstractAction {
    protected String labelPosition;
    protected String alignment;

    /**
     *
     * @param key
     */
    public SetLabelPositionAction(String labelPosition, String alignment) {
        this.labelPosition = labelPosition;
        this.alignment = alignment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mxGraph graph = mxGraphActions.getGraph(e);
        if (graph != null && !graph.isSelectionEmpty()) {
            graph.getModel().beginUpdate();
            try {
                // Checks the orientation of the alignment to use the correct constants
                if (labelPosition.equals(mxConstants.ALIGN_LEFT) || labelPosition.equals(mxConstants.ALIGN_CENTER) || labelPosition.equals(mxConstants.ALIGN_RIGHT)) {
                    graph.setCellStyles(mxConstants.STYLE_LABEL_POSITION, labelPosition);
                    graph.setCellStyles(mxConstants.STYLE_ALIGN, alignment);
                } else {
                    graph.setCellStyles(mxConstants.STYLE_VERTICAL_LABEL_POSITION, labelPosition);
                    graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, alignment);
                }
            } finally {
                graph.getModel().endUpdate();
            }
        }
    }

}
