package br.unioeste.jgoose.e4j.swing;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class EditorWindowListener implements WindowListener{

    private static Logger console = Logger.getLogger("console");
    private JFrame editorJFrame;
    private JFrame jgooseJFrame;

    public EditorWindowListener(JFrame editorJFrame) {
        this.editorJFrame = editorJFrame;
    }
    
    @Override
    public void windowOpened(WindowEvent we) {
        console.debug("window opened: " + we.getSource().toString());
    }

    @Override
    public void windowClosing(WindowEvent we) {
        console.debug("window closing: " + we.getSource().toString());
        
        // compatibility between others SO
        this.windowClosed(we);
    }

    @Override
    public void windowClosed(WindowEvent we) {
        JFrame closedFrame = (JFrame) we.getSource();

        if (closedFrame == this.editorJFrame) {
            this.editorJFrame.setVisible(false);
            this.jgooseJFrame.setVisible(true);
//            this.jgooseJFrame.setState(JFrame.NORMAL);
        }
    }

    @Override
    public void windowIconified(WindowEvent we) {
        console.debug("window iconified: " + we.getSource().toString());
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        console.debug("window deiconified: " + we.getSource().toString());
    }

    @Override
    public void windowActivated(WindowEvent we) {
        console.debug("window activated: " + we.getSource().toString());
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        console.debug("window deactivated: " + we.getSource().toString());
    }
    
}
