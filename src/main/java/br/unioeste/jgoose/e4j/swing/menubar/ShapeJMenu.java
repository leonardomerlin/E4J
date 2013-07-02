package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.AlignCellsAction;
import br.unioeste.jgoose.e4j.actions.AutosizeAction;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxResources;
import javax.swing.JMenu;

public class ShapeJMenu extends JMenu {

    public ShapeJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("shape"));

        add(editor.bind(mxResources.get("home"), mxGraphActions.getHomeAction(), "/com/mxgraph/examples/swing/images/house.gif"));

        addSeparator();

        add(editor.bind(mxResources.get("exitGroup"), mxGraphActions.getExitGroupAction(), "/com/mxgraph/examples/swing/images/up.gif"));
        add(editor.bind(mxResources.get("enterGroup"), mxGraphActions.getEnterGroupAction(),
                "/com/mxgraph/examples/swing/images/down.gif"));

        addSeparator();

        add(editor.bind(mxResources.get("group"), mxGraphActions.getGroupAction(), "/com/mxgraph/examples/swing/images/group.gif"));
        add(editor.bind(mxResources.get("ungroup"), mxGraphActions.getUngroupAction(),
                "/com/mxgraph/examples/swing/images/ungroup.gif"));

        addSeparator();

        add(editor.bind(mxResources.get("removeFromGroup"), mxGraphActions.getRemoveFromParentAction()));

        add(editor.bind(mxResources.get("updateGroupBounds"), mxGraphActions.getUpdateGroupBoundsAction()));

        addSeparator();

        add(editor.bind(mxResources.get("collapse"), mxGraphActions.getCollapseAction(),
                "/com/mxgraph/examples/swing/images/collapse.gif"));
        add(editor.bind(mxResources.get("expand"), mxGraphActions.getExpandAction(), "/com/mxgraph/examples/swing/images/expand.gif"));

        addSeparator();

        add(editor.bind(mxResources.get("toBack"), mxGraphActions.getToBackAction(), "/com/mxgraph/examples/swing/images/toback.gif"));
        add(editor.bind(mxResources.get("toFront"), mxGraphActions.getToFrontAction(),
                "/com/mxgraph/examples/swing/images/tofront.gif"));

        addSeparator();

        JMenu submenu = (JMenu) add(new JMenu(mxResources.get("align")));

        submenu.add(editor.bind(mxResources.get("left"), new AlignCellsAction(mxConstants.ALIGN_LEFT),
                "/com/mxgraph/examples/swing/images/alignleft.gif"));
        submenu.add(editor.bind(mxResources.get("center"), new AlignCellsAction(mxConstants.ALIGN_CENTER),
                "/com/mxgraph/examples/swing/images/aligncenter.gif"));
        submenu.add(editor.bind(mxResources.get("right"), new AlignCellsAction(mxConstants.ALIGN_RIGHT),
                "/com/mxgraph/examples/swing/images/alignright.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("top"), new AlignCellsAction(mxConstants.ALIGN_TOP),
                "/com/mxgraph/examples/swing/images/aligntop.gif"));
        submenu.add(editor.bind(mxResources.get("middle"), new AlignCellsAction(mxConstants.ALIGN_MIDDLE),
                "/com/mxgraph/examples/swing/images/alignmiddle.gif"));
        submenu.add(editor.bind(mxResources.get("bottom"), new AlignCellsAction(mxConstants.ALIGN_BOTTOM),
                "/com/mxgraph/examples/swing/images/alignbottom.gif"));

        addSeparator();

        add(editor.bind(mxResources.get("autosize"), new AutosizeAction()));
    }
}
