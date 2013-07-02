package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

@SuppressWarnings(value = "serial")
public class ToggleGridItem extends JCheckBoxMenuItem {

    /**
     *
     */
    public ToggleGridItem(final BasicGraphEditor editor, String name) {
        super(name);
        setSelected(true);
        addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                mxGraphComponent graphComponent = editor.getGraphComponent();
                mxGraph graph = graphComponent.getGraph();
                boolean enabled = !graph.isGridEnabled();
                graph.setGridEnabled(enabled);
                graphComponent.setGridVisible(enabled);
                graphComponent.repaint();
                setSelected(enabled);
            }
        });
    }
    
}
