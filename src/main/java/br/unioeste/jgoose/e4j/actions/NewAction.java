package br.unioeste.jgoose.e4j.actions;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings(value = "serial")
public class NewAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        BasicGraphEditor editor = EditorActions.getEditor(e);
        if (editor != null) {
            if (!editor.isModified() || JOptionPane.showConfirmDialog(editor, mxResources.get("loseChanges")) == JOptionPane.YES_OPTION) {
                mxGraph graph = editor.getGraphComponent().getGraph();
                // Check modified flag and display save dialog
                mxCell root = new mxCell();
                root.insert(new mxCell());
                graph.getModel().setRoot(root);
                editor.setModified(false);
                editor.setCurrentFile(null);
                editor.getGraphComponent().zoomAndCenter();
            }
        }
    }

}
