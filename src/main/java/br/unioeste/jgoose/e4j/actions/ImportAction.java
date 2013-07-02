package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.canvas.mxGraphics2DCanvas;
import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.filters.DefaultFileFilter;
import br.unioeste.jgoose.e4j.swing.EditorPalette;
import com.mxgraph.shape.mxStencilShape;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxUtils;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

@SuppressWarnings(value = "serial")
public class ImportAction extends AbstractAction {
    protected String lastDir;

    /**
     * Loads and registers the shape as a new shape in mxGraphics2DCanvas
     * and adds a new entry to use that shape in the specified palette
     *
     * @param palette The palette to add the shape to.
     * @param nodeXml The raw XML of the shape
     * @param path The path to the directory the shape exists in
     * @return the string name of the shape
     */
    public static String addStencilShape(EditorPalette palette, String nodeXml, String path) {
        // Some editors place a 3 byte BOM at the start of files
        // Ensure the first char is a "<"
        int lessthanIndex = nodeXml.indexOf("<");
        nodeXml = nodeXml.substring(lessthanIndex);
        mxStencilShape newShape = new mxStencilShape(nodeXml);
        String name = newShape.getName();
        ImageIcon icon = null;
        if (path != null) {
            String iconPath = path + newShape.getIconPath();
            icon = new ImageIcon(iconPath);
        }
        // Registers the shape in the canvas shape registry
        mxGraphics2DCanvas.putShape(name, newShape);
        if (palette != null && icon != null) {
            //@TODO: magic number! get it from content of xml
            int w = 80;
            int h = 80;
            palette.addTemplate(name, icon, "shape=" + name, w, h, name);
        }
        return name;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BasicGraphEditor editor = EditorActions.getEditor(e);
        if (editor != null) {
            String wd = (lastDir != null) ? lastDir : System.getProperty("user.dir");
            JFileChooser fc = new JFileChooser(wd);
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            // Adds file filter for Dia shape import
            fc.addChoosableFileFilter(new DefaultFileFilter(".shape", "Dia Shape " + mxResources.get("file") + " (.shape)"));
            int rc = fc.showDialog(null, mxResources.get("importStencil"));
            if (rc == JFileChooser.APPROVE_OPTION) {
                lastDir = fc.getSelectedFile().getParent();
                try {
                    if (fc.getSelectedFile().isDirectory()) {
                        EditorPalette palette = editor.insertPalette(fc.getSelectedFile().getName());
                        for (File f : fc.getSelectedFile().listFiles(new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                return name.toLowerCase().endsWith(".shape");
                            }
                        })) {
                            String nodeXml = mxUtils.readFile(f.getAbsolutePath());
                            addStencilShape(palette, nodeXml, f.getParent() + File.separator);
                        }
                        JComponent scrollPane = (JComponent) palette.getParent().getParent();
                        editor.getLibraryPane().setSelectedComponent(scrollPane);
                        // FIXME: Need to update the size of the palette to force a layout
                        // update. Re/in/validate of palette or parent does not work.
                        //editor.getLibraryPane().revalidate();
                    } else {
                        String nodeXml = mxUtils.readFile(fc.getSelectedFile().getAbsolutePath());
                        String name = addStencilShape(null, nodeXml, null);
                        JOptionPane.showMessageDialog(editor, mxResources.get("stencilImported", new String[]{name}));
                    }
                } catch (IOException e1) {
                }
            }
        }
    }

}
