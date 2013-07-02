package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.handler.mxConnectionHandler;
import com.mxgraph.swing.mxGraphComponent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class ToggleConnectModeAction extends AbstractAction {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxConnectionHandler handler = graphComponent.getConnectionHandler();
            handler.setHandleEnabled(!handler.isHandleEnabled());
        }
    }

}
