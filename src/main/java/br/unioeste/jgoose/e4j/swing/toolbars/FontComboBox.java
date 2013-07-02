package br.unioeste.jgoose.e4j.swing.toolbars;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;

public class FontComboBox extends JComboBox {

    public FontComboBox(final BasicGraphEditor editor, List<String> fonts) {
        super(fonts.toArray());
        setEditable(true);
        setMinimumSize(new Dimension(120, 0));
        setPreferredSize(new Dimension(120, 0));
        setMaximumSize(new Dimension(120, 100));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String font = getSelectedItem().toString();

                if (font != null && !font.equals("-")) {
                    mxGraph graph = editor.getGraphComponent().getGraph();
                    graph.setCellStyles(mxConstants.STYLE_FONTFAMILY, font);
                }
            }
        });
    }
}
