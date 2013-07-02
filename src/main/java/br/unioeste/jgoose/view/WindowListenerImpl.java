package br.unioeste.jgoose.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class WindowListenerImpl implements WindowListener {

    private final JFrame jgooseView;
    private final JFrame e4jView;

    public WindowListenerImpl(final JFrame jgooseView, final JFrame e4jView) {
        this.jgooseView = jgooseView;
        this.e4jView = e4jView;
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        JFrame closedFrame = (JFrame) we.getSource();

        if (closedFrame == this.e4jView) {
            this.jgooseView.setVisible(true);
            this.e4jView.setVisible(false);
        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
        JFrame closedFrame = (JFrame) we.getSource();

        if (closedFrame == this.e4jView) {
            this.jgooseView.setVisible(true);
            this.e4jView.setVisible(false);
        }
    }

    @Override
    public void windowIconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
