package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.ColorAction;
import br.unioeste.jgoose.e4j.actions.KeyValueAction;
import br.unioeste.jgoose.e4j.actions.PromptValueAction;
import br.unioeste.jgoose.e4j.actions.SetLabelPositionAction;
import br.unioeste.jgoose.e4j.actions.SetStyleAction;
import br.unioeste.jgoose.e4j.actions.StyleAction;
import br.unioeste.jgoose.e4j.actions.ToggleAction;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxResources;
import javax.swing.JMenu;

public class FormatJMenu extends JMenu {

    public FormatJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("format"));

        JMenu submenu = (JMenu) add(new JMenu(mxResources.get("background")));

        submenu.add(editor.bind(mxResources.get("fillcolor"), new ColorAction("Fillcolor", mxConstants.STYLE_FILLCOLOR),
                "/com/mxgraph/examples/swing/images/fillcolor.gif"));
        submenu.add(editor.bind(mxResources.get("gradient"), new ColorAction("Gradient", mxConstants.STYLE_GRADIENTCOLOR)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("image"), new PromptValueAction(mxConstants.STYLE_IMAGE, "Image")));
        submenu.add(editor.bind(mxResources.get("shadow"), new ToggleAction(mxConstants.STYLE_SHADOW)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("opacity"), new PromptValueAction(mxConstants.STYLE_OPACITY, "Opacity (0-100)")));

        submenu = (JMenu) add(new JMenu(mxResources.get("label")));

        submenu.add(editor.bind(mxResources.get("fontcolor"), new ColorAction("Fontcolor", mxConstants.STYLE_FONTCOLOR),
                "/com/mxgraph/examples/swing/images/fontcolor.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("labelFill"), new ColorAction("Label Fill", mxConstants.STYLE_LABEL_BACKGROUNDCOLOR)));
        submenu.add(editor.bind(mxResources.get("labelBorder"), new ColorAction("Label Border", mxConstants.STYLE_LABEL_BORDERCOLOR)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("rotateLabel"), new ToggleAction(mxConstants.STYLE_HORIZONTAL, true)));

        submenu.add(editor.bind(mxResources.get("textOpacity"), new PromptValueAction(mxConstants.STYLE_TEXT_OPACITY, "Opacity (0-100)")));

        submenu.addSeparator();

        JMenu subsubmenu = (JMenu) submenu.add(new JMenu(mxResources.get("position")));

        subsubmenu.add(editor.bind(mxResources.get("top"), new SetLabelPositionAction(mxConstants.ALIGN_TOP, mxConstants.ALIGN_BOTTOM)));
        subsubmenu.add(editor.bind(mxResources.get("middle"),
                new SetLabelPositionAction(mxConstants.ALIGN_MIDDLE, mxConstants.ALIGN_MIDDLE)));
        subsubmenu.add(editor.bind(mxResources.get("bottom"), new SetLabelPositionAction(mxConstants.ALIGN_BOTTOM, mxConstants.ALIGN_TOP)));

        subsubmenu.addSeparator();

        subsubmenu.add(editor.bind(mxResources.get("left"), new SetLabelPositionAction(mxConstants.ALIGN_LEFT, mxConstants.ALIGN_RIGHT)));
        subsubmenu.add(editor.bind(mxResources.get("center"),
                new SetLabelPositionAction(mxConstants.ALIGN_CENTER, mxConstants.ALIGN_CENTER)));
        subsubmenu.add(editor.bind(mxResources.get("right"), new SetLabelPositionAction(mxConstants.ALIGN_RIGHT, mxConstants.ALIGN_LEFT)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("wordWrap"), new KeyValueAction(mxConstants.STYLE_WHITE_SPACE, "wrap")));
        submenu.add(editor.bind(mxResources.get("noWordWrap"), new KeyValueAction(mxConstants.STYLE_WHITE_SPACE, null)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("hide"), new ToggleAction(mxConstants.STYLE_NOLABEL)));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("line")));

        submenu.add(editor.bind(mxResources.get("linecolor"), new ColorAction("Linecolor", mxConstants.STYLE_STROKECOLOR),
                "/com/mxgraph/examples/swing/images/linecolor.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("orthogonal"), new ToggleAction(mxConstants.STYLE_ORTHOGONAL)));
        submenu.add(editor.bind(mxResources.get("dashed"), new ToggleAction(mxConstants.STYLE_DASHED)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("linewidth"), new PromptValueAction(mxConstants.STYLE_STROKEWIDTH, "Linewidth")));

        submenu = (JMenu) add(new JMenu(mxResources.get("connector")));

        submenu.add(editor.bind(mxResources.get("straight"), new SetStyleAction("straight"),
                "/com/mxgraph/examples/swing/images/straight.gif"));

        submenu.add(editor.bind(mxResources.get("horizontal"), new SetStyleAction(""), "/com/mxgraph/examples/swing/images/connect.gif"));
        submenu.add(editor.bind(mxResources.get("vertical"), new SetStyleAction("vertical"),
                "/com/mxgraph/examples/swing/images/vertical.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("entityRelation"), new SetStyleAction("edgeStyle=mxEdgeStyle.EntityRelation"),
                "/com/mxgraph/examples/swing/images/entity.gif"));
        submenu.add(editor.bind(mxResources.get("arrow"), new SetStyleAction("arrow"), "/com/mxgraph/examples/swing/images/arrow.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("plain"), new ToggleAction(mxConstants.STYLE_NOEDGESTYLE)));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("linestart")));

        submenu.add(editor.bind(mxResources.get("open"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_OPEN),
                "/com/mxgraph/examples/swing/images/open_start.gif"));
        submenu.add(editor.bind(mxResources.get("classic"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_CLASSIC),
                "/com/mxgraph/examples/swing/images/classic_start.gif"));
        submenu.add(editor.bind(mxResources.get("block"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_BLOCK),
                "/com/mxgraph/examples/swing/images/block_start.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("diamond"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_DIAMOND),
                "/com/mxgraph/examples/swing/images/diamond_start.gif"));
        submenu.add(editor.bind(mxResources.get("oval"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_OVAL),
                "/com/mxgraph/examples/swing/images/oval_start.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("none"), new KeyValueAction(mxConstants.STYLE_STARTARROW, mxConstants.NONE)));
        submenu.add(editor.bind(mxResources.get("size"), new PromptValueAction(mxConstants.STYLE_STARTSIZE, "Linestart Size")));

        submenu = (JMenu) add(new JMenu(mxResources.get("lineend")));

        submenu.add(editor.bind(mxResources.get("open"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OPEN),
                "/com/mxgraph/examples/swing/images/open_end.gif"));
        submenu.add(editor.bind(mxResources.get("classic"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC),
                "/com/mxgraph/examples/swing/images/classic_end.gif"));
        submenu.add(editor.bind(mxResources.get("block"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK),
                "/com/mxgraph/examples/swing/images/block_end.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("diamond"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND),
                "/com/mxgraph/examples/swing/images/diamond_end.gif"));
        submenu.add(editor.bind(mxResources.get("oval"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OVAL),
                "/com/mxgraph/examples/swing/images/oval_end.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("none"), new KeyValueAction(mxConstants.STYLE_ENDARROW, mxConstants.NONE)));
        submenu.add(editor.bind(mxResources.get("size"), new PromptValueAction(mxConstants.STYLE_ENDSIZE, "Lineend Size")));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("alignment")));

        submenu.add(editor.bind(mxResources.get("left"), new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT),
                "/com/mxgraph/examples/swing/images/left.gif"));
        submenu.add(editor.bind(mxResources.get("center"), new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER),
                "/com/mxgraph/examples/swing/images/center.gif"));
        submenu.add(editor.bind(mxResources.get("right"), new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT),
                "/com/mxgraph/examples/swing/images/right.gif"));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("top"), new KeyValueAction(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_TOP),
                "/com/mxgraph/examples/swing/images/top.gif"));
        submenu.add(editor.bind(mxResources.get("middle"), new KeyValueAction(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE),
                "/com/mxgraph/examples/swing/images/middle.gif"));
        submenu.add(editor.bind(mxResources.get("bottom"), new KeyValueAction(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_BOTTOM),
                "/com/mxgraph/examples/swing/images/bottom.gif"));

        submenu = (JMenu) add(new JMenu(mxResources.get("spacing")));

        submenu.add(editor.bind(mxResources.get("top"), new PromptValueAction(mxConstants.STYLE_SPACING_TOP, "Top Spacing")));
        submenu.add(editor.bind(mxResources.get("right"), new PromptValueAction(mxConstants.STYLE_SPACING_RIGHT, "Right Spacing")));
        submenu.add(editor.bind(mxResources.get("bottom"), new PromptValueAction(mxConstants.STYLE_SPACING_BOTTOM, "Bottom Spacing")));
        submenu.add(editor.bind(mxResources.get("left"), new PromptValueAction(mxConstants.STYLE_SPACING_LEFT, "Left Spacing")));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("global"), new PromptValueAction(mxConstants.STYLE_SPACING, "Spacing")));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("sourceSpacing"), new PromptValueAction(mxConstants.STYLE_SOURCE_PERIMETER_SPACING,
                mxResources.get("sourceSpacing"))));
        submenu.add(editor.bind(mxResources.get("targetSpacing"), new PromptValueAction(mxConstants.STYLE_TARGET_PERIMETER_SPACING,
                mxResources.get("targetSpacing"))));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("perimeter"), new PromptValueAction(mxConstants.STYLE_PERIMETER_SPACING,
                "Perimeter Spacing")));

        submenu = (JMenu) add(new JMenu(mxResources.get("direction")));

        submenu.add(editor.bind(mxResources.get("north"), new KeyValueAction(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_NORTH)));
        submenu.add(editor.bind(mxResources.get("east"), new KeyValueAction(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_EAST)));
        submenu.add(editor.bind(mxResources.get("south"), new KeyValueAction(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_SOUTH)));
        submenu.add(editor.bind(mxResources.get("west"), new KeyValueAction(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_WEST)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("rotation"), new PromptValueAction(mxConstants.STYLE_ROTATION, "Rotation (0-360)")));

        addSeparator();

        add(editor.bind(mxResources.get("rounded"), new ToggleAction(mxConstants.STYLE_ROUNDED)));

        add(editor.bind(mxResources.get("style"), new StyleAction()));
    }
}
