package br.unioeste.leonardomerlin.tcc.istarml.tag;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An actor relationship is a relationship between two actors.
 * <p>
 * Broadly used types of actor relationships are:
 * <ul>
 * <li>is_a</li>
 * <li>is_part_of</li>
 * <li>instance_of (INS)</li>
 * <li>plays</li>
 * <li>occupies</li>
 * <li>covers</li>
 * </ul>
 * </p>
 *
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "actorLink")
public class ActorLink {

    @XmlAttribute(required = true)
    private String type; //is_part_of | is_a | instance_of | plays | covers | occupies | other*
    @XmlAttribute(required = true)
    private String aref;
    @XmlElement(required = false)
    private Graphic graphicPath;

    public ActorLink() {
    }

    public ActorLink(Actor actor, ActorLinkType type) {
        if (null == actor) {
            throw new IllegalArgumentException("Actor must be not null.");
        }
        this.aref = actor.getReference();

        if (null == type) {
            throw new IllegalArgumentException("Type value must be not null.");
        }
        this.type = type.name().toLowerCase();
    }

    public ActorLink(Actor actor, String extended) {
        if (null == actor) {
            throw new IllegalArgumentException("Actor must be not null.");
        }
        this.aref = actor.getReference();

        if (null == extended || extended.isEmpty()) {
            throw new IllegalArgumentException("Type value must be not null and have some content.");
        }
        this.type = extended;

    }

    public enum ActorLinkType {

        IS_PART_OF,
        IS_A,
        INSTANCE_OF,
        PLAYS,
        COVERS,
        OCCUPIES
    }
}
