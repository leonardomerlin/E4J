package br.unioeste.jgoose.istarml.utils;

import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import java.util.Set;

/**
 * Interface to filter i* Elements at Collections classes.
 *
 * @param <T>
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public interface FilterElements<T> {

    /**
     * Check if the candidate is qualified to be filtered.
     *
     * @param candidate
     * @return true if candidade is qualified to be filtered.
     */
    public boolean match(T candidate);

    public Set<T> filter(Set<T> actors);
}
