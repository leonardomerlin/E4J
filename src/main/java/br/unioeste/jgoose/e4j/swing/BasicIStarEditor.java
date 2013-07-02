/**
 * $Id: BasicIStarEditor.java,v 1.2 2012/11/20 09:08:09 gaudenz Exp $ Copyright
 * (c) 2006-2012, JGraph Ltd
 */
package br.unioeste.jgoose.e4j.swing;

import br.unioeste.jgoose.e4j.swing.listeners.EdgeChangeEventListener;
import br.unioeste.jgoose.e4j.CustomGraph;
import br.unioeste.jgoose.e4j.swing.palettes.ElementsPalette;
import br.unioeste.jgoose.e4j.swing.palettes.LinksPalette;
import br.unioeste.jgoose.ui.swing.CustomGraphComponent;
import java.net.URL;
import java.text.NumberFormat;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.view.mxGraph;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Locale;
import javax.swing.JFrame;
import org.apache.log4j.Logger;

public class BasicIStarEditor extends BasicGraphEditor {

    private static final long serialVersionUID = -4601740824088314699L;
    private static final Logger CONSOLE = Logger.getLogger("console");
    /**
     * Holds the shared number formatter.
     *
     * @see NumberFormat#getInstance()
     */
    public static final NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt_BR"));
    /**
     * Holds the URL for the icon to be used as a handle for creating new
     * connections. This is currently unused.
     */
    public static URL url = null;

    //GraphEditor.class.getResource("/com/mxgraph/examples/swing/images/connector.gif");
    public BasicIStarEditor(JFrame frame) {
        this("JGOOSE - Editor i*", new CustomGraphComponent(new CustomGraph()));
        super.setFrame(frame);
    }

    /**
     *
     * @param appTitle title for the application.
     * @param component the graph.
     */
    public BasicIStarEditor(String appTitle, mxGraphComponent component) {
        super(appTitle, component);
        final mxGraph graph = graphComponent.getGraph();

        // Load and creates the shapes palette
        //@TODO: improve this.
        EditorPalette elementsPalette = new ElementsPalette(libraryPane);
        EditorPalette linksPalette = new LinksPalette(libraryPane);

        elementsPalette.addListener(mxEvent.SELECT, new EdgeChangeEventListener(graph));
        linksPalette.addListener(mxEvent.SELECT, new EdgeChangeEventListener(graph));
    }

    @Override
    public void exit() {
        if (frame != null) {
            ((EditorJFrame)frame).exit();
            
        } else {
            CONSOLE.debug("editorJFrame is null");
        }
    }
}
