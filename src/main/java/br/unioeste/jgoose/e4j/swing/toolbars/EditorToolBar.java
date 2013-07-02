package br.unioeste.jgoose.e4j.swing.toolbars;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.TransferHandler;

import br.unioeste.jgoose.e4j.actions.ColorAction;
import br.unioeste.jgoose.e4j.actions.FontStyleAction;
import br.unioeste.jgoose.e4j.actions.HistoryAction;
import br.unioeste.jgoose.e4j.actions.KeyValueAction;
import br.unioeste.jgoose.e4j.actions.NewAction;
import br.unioeste.jgoose.e4j.actions.OpenAction;
import br.unioeste.jgoose.e4j.actions.PrintAction;
import br.unioeste.jgoose.e4j.actions.SaveAction;
import com.mxgraph.swing.util.mxGraphActions;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraphView;

public class EditorToolBar extends JToolBar {

    private static final long serialVersionUID = -8015443128436394471L;

    /**
     *
     * @param frame
     * @param orientation
     */
    public EditorToolBar(final BasicGraphEditor editor, int orientation) {
        super(orientation);
        setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createEmptyBorder(3, 3, 3, 3), getBorder()));
        setFloatable(false);

        add(editor.bind("New", new NewAction(), "/com/mxgraph/examples/swing/images/new.gif"));
        add(editor.bind("Open", new OpenAction(), "/com/mxgraph/examples/swing/images/open.gif"));
        add(editor.bind("Save", new SaveAction(false), "/com/mxgraph/examples/swing/images/save.gif"));

        addSeparator();
        add(editor.bind("Print", new PrintAction(), "/com/mxgraph/examples/swing/images/print.gif"));

        addSeparator();
        add(editor.bind("Cut", TransferHandler.getCutAction(), "/com/mxgraph/examples/swing/images/cut.gif"));
        add(editor.bind("Copy", TransferHandler.getCopyAction(), "/com/mxgraph/examples/swing/images/copy.gif"));
        add(editor.bind("Paste", TransferHandler.getPasteAction(), "/com/mxgraph/examples/swing/images/paste.gif"));

        addSeparator();
        add(editor.bind("Delete", mxGraphActions.getDeleteAction(), "/com/mxgraph/examples/swing/images/delete.gif"));

        addSeparator();
        add(editor.bind("Undo", new HistoryAction(true), "/com/mxgraph/examples/swing/images/undo.gif"));
        add(editor.bind("Redo", new HistoryAction(false), "/com/mxgraph/examples/swing/images/redo.gif"));

        addSeparator();

        // Gets the list of available fonts from the local graphics environment
        // and adds some frequently used fonts at the beginning of the list
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

        List<String> fonts = new ArrayList<>();
        fonts.addAll(Arrays.asList(new String[]{"Helvetica", "Verdana",
            "Times New Roman", "Garamond", "Courier New", "-"}));
        fonts.addAll(Arrays.asList(env.getAvailableFontFamilyNames()));

        final JComboBox fontCombo = new FontComboBox(editor, fonts);
        add(fontCombo);

        final JComboBox sizeCombo = new SizeComboBox(editor);
        add(sizeCombo);

        addSeparator();
        add(editor.bind("Bold", new FontStyleAction(true), "/com/mxgraph/examples/swing/images/bold.gif"));
        add(editor.bind("Italic", new FontStyleAction(false), "/com/mxgraph/examples/swing/images/italic.gif"));

        addSeparator();
        add(editor.bind("Left", new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT), "/com/mxgraph/examples/swing/images/left.gif"));
        add(editor.bind("Center", new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER), "/com/mxgraph/examples/swing/images/center.gif"));
        add(editor.bind("Right", new KeyValueAction(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT), "/com/mxgraph/examples/swing/images/right.gif"));

        addSeparator();
        add(editor.bind("Font", new ColorAction("Font", mxConstants.STYLE_FONTCOLOR), "/com/mxgraph/examples/swing/images/fontcolor.gif"));
        add(editor.bind("Stroke", new ColorAction("Stroke", mxConstants.STYLE_STROKECOLOR), "/com/mxgraph/examples/swing/images/linecolor.gif"));
        add(editor.bind("Fill", new ColorAction("Fill", mxConstants.STYLE_FILLCOLOR), "/com/mxgraph/examples/swing/images/fillcolor.gif"));

        addSeparator();

        final mxGraphView view = editor.getGraphComponent().getGraph().getView();

        final JComboBox zoomCombo = new ZoomComboBox(view, editor);
        add(zoomCombo);

        // Sets the zoom in the zoom combo the current value
        mxIEventListener scaleTracker = ((ZoomComboBox) zoomCombo).getScaleTracker();

        // Installs the scale tracker to update the value in the combo box
        // if the zoom is changed from outside the combo box
        view.getGraph().getView().addListener(mxEvent.SCALE, scaleTracker);
        view.getGraph().getView().addListener(mxEvent.SCALE_AND_TRANSLATE, scaleTracker);

        // Invokes once to sync with the actual zoom value
        scaleTracker.invoke(null, null);

    }
}
