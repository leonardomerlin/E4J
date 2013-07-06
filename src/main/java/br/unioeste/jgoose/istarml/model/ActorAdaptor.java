package br.unioeste.jgoose.istarml.model;

import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import br.unioeste.jgoose.istarml.model.tag.DiagramTag;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class ActorAdaptor implements Comparable<ActorAdaptor> {

    private DiagramTag parent;
    private ActorTag actorTag;

    public ActorAdaptor(DiagramTag parent) {
        this(parent, null);
    }

    public ActorAdaptor(DiagramTag parent, ActorTag actorTag) {
        this.parent = parent;
        this.actorTag = actorTag;

        if (this.actorTag == null) {
            this.actorTag = new ActorTag();
        }
    }

    @Override
    public int compareTo(ActorAdaptor actor) {
        int result = 0;
        String id = this.getId();
        String _id = actor.getId();

        // compare ids
        int resultIds = this.compare(id, _id);
        if (resultIds == 0) {
            return 0; // equals
        }

        int resultNames = this.compare(this.getName(), actor.getName());

        return result;
    }

    /**
     * 0 = Equals and not blank (ignore case) -1 = Both is Blank. -2 = notEquals
     * and A is blank -3 = notEquals and B is blank -4 = undefined?
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(String a, String b) {
        if (StringUtils.isBlank(a) && StringUtils.isBlank(b)) {
            return -1;
        }

        if (a.equalsIgnoreCase(b)) {
            return 0;
        }

        if (StringUtils.isBlank(a)) {
            return -2;
        }

        if (StringUtils.isBlank(b)) {
            return -3;
        }

        return -4;
    }

    private String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
