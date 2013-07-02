package br.unioeste.jgoose.e4j.swing.palettes;

import com.mxgraph.util.mxResources;
import javax.swing.JTabbedPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class LinksPalette extends AbstractPalette {

    private static final Logger CONSOLE = Logger.getLogger("console");

    public LinksPalette(JTabbedPane libraryPane) {
        super(mxResources.get("links"), libraryPane);

        //@TODO: internationalize this?
        // Leonardo: no! but the documentation, yes!

//        addEdgeTemplate(name, icon, style, w, h, Object value);
        addEdgeTemplate("dependency", null, null, 80, 80, "D");

        // actors links
        addEdgeTemplate("ISA", null, null, 80, 80, "IS A");
        addEdgeTemplate("IS PART OF", null, null, 80, 80, "IS PART OF");
        addEdgeTemplate("PLAY", null, null, 80, 80, "PLAY");
        addEdgeTemplate("COVERS", null, null, 80, 80, "COVERS");
        addEdgeTemplate("OCCUPIES", null, null, 80, 80, "OCCUPIES");
        addEdgeTemplate("INS", null, null, 80, 80, "INS");
        
        // SR links
        addEdgeTemplate("MEANS-END", null, null, 80, 80, "MEANS-END");
        addEdgeTemplate("DECOMPOSITION", null, null, 80, 80, "DECOMPOSITION");

        // CONTRIBUTION
        // positive
        addEdgeTemplate("MAKE", null, null, 80, 80, "MAKE");
        addEdgeTemplate("SOME +", null, null, 80, 80, "SOME +");
        addEdgeTemplate("HELP", null, null, 80, 80, "HELP");
        // negative
        addEdgeTemplate("BREAK", null, null, 80, 80, "BREAK");
        addEdgeTemplate("SOME -", null, null, 80, 80, "SOME -");
        addEdgeTemplate("HURT", null, null, 80, 80, "HURT");
        // others
        addEdgeTemplate("Unknown", null, null, 80, 80, "Unknown");
        addEdgeTemplate("And", null, null, 80, 80, "And");
        addEdgeTemplate("Or", null, null, 80, 80, "Or");

    }
}
