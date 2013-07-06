package br.unioeste.jgoose.e4j;

import br.unioeste.jgoose.e4j.swing.EditorJFrame;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class App {

    public static final Logger CONSOLE = Logger.getLogger("console");

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            CONSOLE.error("LookAndFeel error", ex);
        }

        EditorJFrame editor = new EditorJFrame();
        editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editor.setVisible(true);
    }
}
