/**
 * $Id: EditorKeyboardHandler.java,v 1.1 2012/11/15 13:26:46 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */
package br.unioeste.jgoose.e4j.swing;

import br.unioeste.jgoose.e4j.actions.HistoryAction;
import br.unioeste.jgoose.e4j.actions.NewAction;
import br.unioeste.jgoose.e4j.actions.OpenAction;
import br.unioeste.jgoose.e4j.actions.SaveAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxKeyboardHandler;
import com.mxgraph.swing.util.mxGraphActions;

/**
 * Handle the shortcuts and actions of keyborad.
 *
 */
public class EditorKeyboardHandler extends mxKeyboardHandler {

    /**
     *
     * @param graphComponent
     */
    public EditorKeyboardHandler(mxGraphComponent graphComponent) {
        super(graphComponent);
    }

    /**
     * Return JTree's input map (keyboard shortcut).
     *
     * @param condition of JComponent.
     * @return inputmap of keyboard shortcut.
     */
    @Override
    protected InputMap getInputMap(int condition) {
        InputMap map = super.getInputMap(condition);

        if (condition == JComponent.WHEN_FOCUSED && map != null) {
            map.put(KeyStroke.getKeyStroke("control S"), "save");
            map.put(KeyStroke.getKeyStroke("control shift S"), "saveAs");
            map.put(KeyStroke.getKeyStroke("control N"), "new");
            map.put(KeyStroke.getKeyStroke("control O"), "open");

            map.put(KeyStroke.getKeyStroke("control Z"), "undo");
            map.put(KeyStroke.getKeyStroke("control Y"), "redo");
            map
                    .put(KeyStroke.getKeyStroke("control shift V"),
                    "selectVertices");
            map.put(KeyStroke.getKeyStroke("control shift E"), "selectEdges");
        }

        return map;
    }

    /**
     * Return the mapping between JTree's input map and JGraph's actions.
     *
     * @return actionmap
     */
    @Override
    protected ActionMap createActionMap() {
        ActionMap map = super.createActionMap();

        map.put("save", new SaveAction(false));
        map.put("saveAs", new SaveAction(true));
        map.put("new", new NewAction());
        map.put("open", new OpenAction());
        map.put("undo", new HistoryAction(true));
        map.put("redo", new HistoryAction(false));
        map.put("selectVertices", mxGraphActions.getSelectVerticesAction());
        map.put("selectEdges", mxGraphActions.getSelectEdgesAction());

        return map;
    }
}
