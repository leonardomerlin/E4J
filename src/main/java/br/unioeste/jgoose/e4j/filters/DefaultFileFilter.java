/* 
 * $Id: DefaultFileFilter.java,v 1.1 2012/11/15 13:26:46 gaudenz Exp $
 * Copyright (c) 2001-2005, Gaudenz Alder
 * 
 * All rights reserved.
 * 
 * See LICENSE file for license details. If you are unable to locate
 * this file please contact info (at) jgraph (dot) com.
 */
package br.unioeste.jgoose.e4j.filters;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Filter for use in a {@link JFileChooser}.
 */
public class DefaultFileFilter extends FileFilter {

    /**
     * Extension of accepted files.
     */
    protected String ext;
    /**
     * Description of accepted files.
     */
    protected String desc;

    /**
     * Constructs a new filter for the specified extension and descpription.
     *
     * @param extension The extension to accept files with.
     * @param description The description of the file format.
     */
    public DefaultFileFilter(String extension, String description) {
        ext = extension.toLowerCase();
        desc = description;
    }

    /**
     * Returns true if
     * <code>file</code> is a directory or ends with {@link #ext}.
     *
     * @param file The file to be checked.
     * @return Returns true if the file is accepted.
     */
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().toLowerCase().endsWith(ext);
    }

    /**
     * Returns the description for accepted files.
     *
     * @return Returns the description.
     */
    @Override
    public String getDescription() {
        return desc;
    }

    /**
     * Returns the extension for accepted files.
     *
     * @return Returns the extension.
     */
    public String getExtension() {
        return ext;
    }

    /**
     * Sets the extension for accepted files.
     *
     * @param extension The extension to set.
     */
    public void setExtension(String extension) {
        this.ext = extension;
    }
}
