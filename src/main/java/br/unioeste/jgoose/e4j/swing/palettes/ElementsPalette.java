package br.unioeste.jgoose.e4j.swing.palettes;

import br.unioeste.jgoose.e4j.actions.ImportAction;
import br.unioeste.jgoose.e4j.filters.ShapeFilenameFilter;
import com.mxgraph.util.mxUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JTabbedPane;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class ElementsPalette extends AbstractPalette {

    private static final Logger CONSOLE = Logger.getLogger("console");

    public ElementsPalette(JTabbedPane libraryPane) {
        super("Elements", libraryPane);

        // add from resources
        URL shapesResources = ElementsPalette.class.getResource("/br/unioeste/jgoose/swing/shapes/elements/");
        File shapesFolder = new File(shapesResources.getPath());

        File[] files = shapesFolder.listFiles(ShapeFilenameFilter.instance);
        if (files == null || files.length < 1) {
            CONSOLE.info("no shape found.");
            return;
        }

        for (File f : files) {
            String nodeXml;
            try {
                nodeXml = mxUtils.readFile(f.getAbsolutePath());
                ImportAction.addStencilShape(this, nodeXml, f.getParent() + File.separator);
            } catch (IOException ex) {
                CONSOLE.fatal(ex);
            }
        }
    }
}
