package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.HistoryAction;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxResources;
import javax.swing.JMenu;
import javax.swing.TransferHandler;

public class EditJMenu extends JMenu {

    public EditJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("edit"));
        add(editor.bind(mxResources.get("undo"), new HistoryAction(true), "/com/mxgraph/examples/swing/images/undo.gif"));
        add(editor.bind(mxResources.get("redo"), new HistoryAction(false), "/com/mxgraph/examples/swing/images/redo.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("cut"), TransferHandler.getCutAction(), "/com/mxgraph/examples/swing/images/cut.gif"));
        add(editor.bind(mxResources.get("copy"), TransferHandler.getCopyAction(), "/com/mxgraph/examples/swing/images/copy.gif"));
        add(editor.bind(mxResources.get("paste"), TransferHandler.getPasteAction(), "/com/mxgraph/examples/swing/images/paste.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("delete"), mxGraphActions.getDeleteAction(), "/com/mxgraph/examples/swing/images/delete.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("selectAll"), mxGraphActions.getSelectAllAction()));
        add(editor.bind(mxResources.get("selectNone"), mxGraphActions.getSelectNoneAction()));

        addSeparator();
//        add(editor.bind(mxResources.get("warning"), new WarningAction()));
        add(editor.bind(mxResources.get("edit"), mxGraphActions.getEditAction()));
    }
}
