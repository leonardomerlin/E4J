package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.io.mxCodec;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxUtils;
import com.mxgraph.view.mxGraph;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.w3c.dom.Document;

@SuppressWarnings(value = "serial")
public class StylesheetAction extends AbstractAction {

    protected String stylesheet;

    public StylesheetAction(String stylesheet) {
        this.stylesheet = stylesheet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            mxGraph graph = graphComponent.getGraph();
            mxCodec codec = new mxCodec();
            Document doc = mxUtils.loadDocument(EditorActions.class.getResource(stylesheet).toString());
            if (doc != null) {
                codec.decode(doc.getDocumentElement(), graph.getStylesheet());
                graph.refresh();
            }
        }
    }
}
