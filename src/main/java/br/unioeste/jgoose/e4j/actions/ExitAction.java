package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class ExitAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        BasicGraphEditor editor = EditorActions.getEditor(e);
        
        if (editor != null) {
            editor.exit();
        }
    }
    
}
