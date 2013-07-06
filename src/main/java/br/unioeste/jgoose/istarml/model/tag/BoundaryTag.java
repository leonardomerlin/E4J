package br.unioeste.jgoose.istarml.model.tag;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A boundary represents a group of intentional elements.
 * <p>The common type of boundary is the actor’s boundary which represents the
 * vision of an omnipresent objective observer with respect to the actor’s
 * scope. However other boundary types can also be used.</p>
 *
 * @author Leonardo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "boundary")
public class BoundaryTag {

    @XmlAttribute
    private String type;
    @XmlElement
    private GraphicTag graphPath;
    @XmlAnyElement
    private Set<IElementTag> elements;
    @XmlAnyElement
    private Set<IElementTag> actors;

    public BoundaryTag() {
        this.elements = new HashSet<>();
        this.actors = new HashSet<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GraphicTag getGraphPath() {
        return graphPath;
    }

    public void setGraphPath(GraphicTag graphPath) {
        this.graphPath = graphPath;
    }

    public Set<IElementTag> getElements() {
        return elements;
    }

    public void setElements(Set<IElementTag> elements) {
        this.elements = elements;
    }

    public Set<IElementTag> getActors() {
        return actors;
    }

    public void setActors(Set<IElementTag> actors) {
        this.actors = actors;
    }
}
