package br.unioeste.jgoose.e4j.swing.listeners;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Update status bar with the mouse location.
 * 
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class MouseLocation implements MouseMotionListener{

    private final BasicGraphEditor editor;

    public MouseLocation(BasicGraphEditor editor) {
        this.editor = editor;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        editor.status(e.getX() + ", " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseDragged(e);
    }
    
}
