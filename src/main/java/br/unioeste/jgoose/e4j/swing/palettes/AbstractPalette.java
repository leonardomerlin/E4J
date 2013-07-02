package br.unioeste.jgoose.e4j.swing.palettes;

import br.unioeste.jgoose.e4j.swing.EditorPalette;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public abstract class AbstractPalette extends EditorPalette {

    protected final JScrollPane scrollPane;

    public AbstractPalette(String name, JTabbedPane libraryPane) {
        scrollPane = new JScrollPane(this);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        libraryPane.add(name, scrollPane);

        // Updates the widths of the palettes if the container size changes
        libraryPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int w = scrollPane.getWidth() - scrollPane.getVerticalScrollBar().getWidth();
                setPreferredWidth(w); // from editor palette
            }
        });

    }

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }
}
