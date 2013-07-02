package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

@SuppressWarnings(value = "serial")
public class ColorAction extends AbstractAction {

    protected String name;
    protected String key;

    /**
     *
     * @param key
     */
    public ColorAction(String name, String key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxGraph graph = graphComponent.getGraph();
            if (!graph.isSelectionEmpty()) {
                Color newColor = JColorChooser.showDialog(graphComponent, name, null);
                if (newColor != null) {
                    graph.setCellStyles(key, mxUtils.hexString(newColor));
                }
            }
        }
    }
}
