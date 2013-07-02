package br.unioeste.jgoose.e4j.swing.menu;

import javax.swing.JPopupMenu;
import javax.swing.TransferHandler;

import br.unioeste.jgoose.e4j.actions.HistoryAction;
import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.swing.menubar.FormatJMenu;
import br.unioeste.jgoose.e4j.swing.menubar.ShapeJMenu;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxResources;

public class GraphPopupMenu extends JPopupMenu {

    private static final long serialVersionUID = -3132749140550242191L;

    public GraphPopupMenu(BasicGraphEditor editor) {
        boolean selected = !editor.getGraphComponent().getGraph()
                .isSelectionEmpty();

        add(editor.bind(mxResources.get("undo"), new HistoryAction(true),
                "/com/mxgraph/examples/swing/images/undo.gif"));

        addSeparator();

        add(
                editor.bind(mxResources.get("cut"), TransferHandler
                .getCutAction(),
                "/com/mxgraph/examples/swing/images/cut.gif"))
                .setEnabled(selected);
        add(
                editor.bind(mxResources.get("copy"), TransferHandler
                .getCopyAction(),
                "/com/mxgraph/examples/swing/images/copy.gif"))
                .setEnabled(selected);
        add(editor.bind(mxResources.get("paste"), TransferHandler
                .getPasteAction(),
                "/com/mxgraph/examples/swing/images/paste.gif"));

        addSeparator();

        add(
                editor.bind(mxResources.get("delete"), mxGraphActions
                .getDeleteAction(),
                "/com/mxgraph/examples/swing/images/delete.gif"))
                .setEnabled(selected);

        addSeparator();

        // Creates the format menu
        add(new FormatJMenu(editor));

        // Creates the shape menu
        add(new ShapeJMenu(editor));

        addSeparator();
        add(
                editor.bind(mxResources.get("edit"), mxGraphActions
                .getEditAction())).setEnabled(selected);

        addSeparator();
        add(editor.bind(mxResources.get("selectVertices"), mxGraphActions
                .getSelectVerticesAction()));
        add(editor.bind(mxResources.get("selectEdges"), mxGraphActions
                .getSelectEdgesAction()));

        addSeparator();
        add(editor.bind(mxResources.get("selectAll"), mxGraphActions
                .getSelectAllAction()));
    }
}
