package br.unioeste.jgoose.e4j.swing.menubar;

import javax.swing.JMenuBar;
import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;

public class EditorMenuBar extends JMenuBar {

    private static final long serialVersionUID = 4060203894740766714L;

    public EditorMenuBar(final BasicGraphEditor editor) {

        // Creates the file menu
        add(new FileJMenu(editor));

        // Creates the edit menu
        add(new EditJMenu(editor));

        // Creates the view menu
        add(new ViewJMenu(editor));

        // Creates the format menu
        add(new FormatJMenu(editor));

        // Creates the shape menu
        add(new ShapeJMenu(editor));

        // Creates the diagram menu
        add(new DiagramJMenu(editor));

        // Creates the options menu
        add(new OptionsJMenu(editor));

        // Creates the help menu
        add(new HelpJMenu(editor));
    }
};