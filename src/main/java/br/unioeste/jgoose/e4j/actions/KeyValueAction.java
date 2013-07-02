package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class KeyValueAction extends AbstractAction {
    protected String key;
    protected String value;

    /**
     *
     * @param key
     */
    public KeyValueAction(String key) {
        this(key, null);
    }

    /**
     *
     * @param key
     */
    public KeyValueAction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mxGraph graph = mxGraphActions.getGraph(e);
        if (graph != null && !graph.isSelectionEmpty()) {
            graph.setCellStyles(key, value);
        }
    }

}
