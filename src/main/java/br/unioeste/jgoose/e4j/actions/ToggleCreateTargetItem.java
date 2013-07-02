package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.swing.handler.mxConnectionHandler;
import com.mxgraph.swing.mxGraphComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;

@SuppressWarnings(value = "serial")
public class ToggleCreateTargetItem extends JCheckBoxMenuItem {

    public ToggleCreateTargetItem(final BasicGraphEditor editor, String name) {
        super(name);
        setSelected(true);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mxGraphComponent graphComponent = editor.getGraphComponent();
                if (graphComponent != null) {
                    mxConnectionHandler handler = graphComponent.getConnectionHandler();
                    handler.setCreateTarget(!handler.isCreateTarget());
                    setSelected(handler.isCreateTarget());
                }
            }
        });
    }

}
