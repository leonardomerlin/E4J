package br.unioeste.jgoose.e4j.swing.toolbars;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class SizeComboBox extends JComboBox {

    public SizeComboBox(final BasicGraphEditor editor) {
        super(new Object[]{
            "6pt", "8pt", "9pt", "10pt", "12pt", "14pt",
            "18pt", "24pt", "30pt", "36pt", "48pt", "60pt"
        });
        setEditable(true);
        setMinimumSize(new Dimension(65, 0));
        setPreferredSize(new Dimension(65, 0));
        setMaximumSize(new Dimension(65, 100));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mxGraph graph = editor.getGraphComponent().getGraph();
                graph.setCellStyles(mxConstants.STYLE_FONTSIZE, 
                        getSelectedItem().toString().replace("pt", ""));
            }
        });
    }
}
