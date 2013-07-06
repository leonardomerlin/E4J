package br.unioeste.jgoose.io.filters;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class TelosFilenameFilter implements FilenameFilter {

    public TelosFilenameFilter() {
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".tel");
    }
}
