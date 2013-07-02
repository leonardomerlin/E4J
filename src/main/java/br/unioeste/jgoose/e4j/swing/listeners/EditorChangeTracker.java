package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class EditorChangeTracker implements mxEventSource.mxIEventListener {

    private final BasicGraphEditor editor;

    public EditorChangeTracker(BasicGraphEditor editor) {
        this.editor = editor;
    }

    @Override
    public void invoke(Object source, mxEventObject evt) {
        this.editor.setModified(true);
    }
}
