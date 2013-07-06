package br.unioeste.jgoose.istarml.model.tag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "actorLink")
public class ActorLinkTag {

    @XmlAttribute(required = true)
    private String type; //is_part_of | is_a | instance_of | plays | covers | occupies | other*
    @XmlAttribute(required = true)
    private String aref;
    @XmlElement(required = false)
    private GraphicTag graphicPath;

    public ActorLinkTag() {
    }
//
//    public ActorLinkTag(Actor actor, ActorLinkType type) {
//        if (null == actor) {
//            throw new IllegalArgumentException("Actor must be not null.");
//        }
//        this.aref = actor.getReference();
//
//        if (null == type) {
//            throw new IllegalArgumentException("Type value must be not null.");
//        }
//        this.type = type.name().toLowerCase();
//    }
//
//    public ActorLinkTag(Actor actor, String extended) {
//        if (null == actor) {
//            throw new IllegalArgumentException("Actor must be not null.");
//        }
//        this.aref = actor.getReference();
//
//        if (null == extended || extended.isEmpty()) {
//            throw new IllegalArgumentException("Type value must be not null and have some content.");
//        }
//        this.type = extended;
//
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAref() {
        return aref;
    }

    public void setAref(String aref) {
        this.aref = aref;
    }

    public GraphicTag getGraphicPath() {
        return graphicPath;
    }

    public void setGraphicPath(GraphicTag graphicPath) {
        this.graphicPath = graphicPath;
    }
}
