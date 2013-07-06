package br.unioeste.jgoose.istarml.model.decorators;

import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import br.unioeste.jgoose.istarml.model.tag.DiagramTag;
import br.unioeste.jgoose.istarml.utils.FilterElementsByTypeImpl;
import java.util.Set;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class DiagramDecorator extends DiagramTag {

    public DiagramDecorator() {
        super();
    }

    public DiagramDecorator(String id, String name) {
        super(id, name);
    }

    public Set<ActorTag> getAllAgents() {
        return FilterElementsByTypeImpl.FILTER_AGENTS.filter(this.getActors());
    }

    public Set<ActorTag> getAllPositions() {
        return FilterElementsByTypeImpl.FILTER_POSITIONS.filter(this.getActors());
    }

    public Set<ActorTag> getAllRoles() {
        return FilterElementsByTypeImpl.FILTER_ROLES.filter(this.getActors());
    }
}
