package br.unioeste.jgoose.e4j.swing;

import br.unioeste.jgoose.e4j.swing.menubar.EditorMenuBar;
import com.mxgraph.swing.util.mxSwingConstants;
import com.mxgraph.util.mxConstants;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class EditorJFrame extends JFrame {

    private BasicIStarEditor editor;
    private EditorMenuBar menubar;

    public EditorJFrame() throws HeadlessException {

        mxSwingConstants.SHADOW_COLOR = Color.LIGHT_GRAY;
        mxConstants.W3C_SHADOWCOLOR = "#D3D3D3";

        // add editor
        this.editor = new BasicIStarEditor(this);
        this.getContentPane().add(this.editor);

        // add menubar
        this.menubar = new EditorMenuBar(editor);
        this.setJMenuBar(menubar);

        this.setSize(870, 640);
    }

    void exit() {
        int defaultCloseOperation = getDefaultCloseOperation();
        switch (defaultCloseOperation) {
            case JFrame.DISPOSE_ON_CLOSE:
//                dispose();
                break;
            case JFrame.DO_NOTHING_ON_CLOSE:
                break;
            case JFrame.EXIT_ON_CLOSE:
//                    System.exit(1);
//                    frame.dispose();
                break;
            case JFrame.HIDE_ON_CLOSE:
                this.setVisible(false);
                WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
                Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
                break;
        }
    }
}
