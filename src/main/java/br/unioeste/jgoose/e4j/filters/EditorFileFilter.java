package br.unioeste.jgoose.e4j.filters;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Utility file filter to accept editor files, namely .xml and .xml.gz
 * extensions.
 *
 * @see ImageIO#getReaderFormatNames()
 */
public class EditorFileFilter extends FileFilter {
    /**
     * Description of the File format
     */
    protected String desc;

    /**
     * Constructs a new editor file filter using the specified description.
     *
     * @param description The description to use for the filter.
     */
    public EditorFileFilter(String description) {
        desc = description;
    }

    /**
     * Returns true if the file is a directory or has a .xml or .xml.gz
     * extension.
     *
     * @return Returns true if the file is accepted.
     */
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String filename = file.getName().toLowerCase();
        return filename.endsWith(".xml") || filename.endsWith(".xml.gz");
    }

    /**
     * Returns the description.
     *
     * @return Returns the description.
     */
    public String getDescription() {
        return desc;
    }

}
