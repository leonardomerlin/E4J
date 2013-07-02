package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.util.mxResources;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class HelpJMenu extends JMenu {

    public HelpJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("help"));

        JMenuItem item = add(new JMenuItem(mxResources.get("aboutGraphEditor")));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editor.about();
            }
        });
    }
}
