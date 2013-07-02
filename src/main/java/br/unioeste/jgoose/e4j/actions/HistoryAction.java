package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class HistoryAction extends AbstractAction {
    protected boolean undo;

    public HistoryAction(boolean undo) {
        this.undo = undo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BasicGraphEditor editor = EditorActions.getEditor(e);
        if (editor != null) {
            if (undo) {
                editor.getUndoManager().undo();
            } else {
                editor.getUndoManager().redo();
            }
        }
    }

}
