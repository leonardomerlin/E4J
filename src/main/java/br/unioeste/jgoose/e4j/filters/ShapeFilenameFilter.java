package br.unioeste.jgoose.e4j.filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class ShapeFilenameFilter implements FilenameFilter {

    public static ShapeFilenameFilter instance = new ShapeFilenameFilter();
    
    @Override
    public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(".shape");
    }
}
