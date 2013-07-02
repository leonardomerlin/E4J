package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxUndoableEdit;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class EditorUndoHandler implements mxIEventListener {

    private final BasicGraphEditor editor;

    public EditorUndoHandler(BasicGraphEditor editor) {
        this.editor = editor;
    }

    @Override
    public void invoke(Object source, mxEventObject evt) {
            editor.getUndoManager().undoableEditHappened((mxUndoableEdit) evt
                    .getProperty("edit"));
    }
}
