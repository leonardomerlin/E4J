package br.unioeste.jgoose.istarml.model.tag;

import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An intentional element link represents an n-ary relationship among
 * intentional elements (either in the actor’s boundary or outside).
 * <br/>
 * Broadly used types of intentional element link are:
 * <ul>
 * <li>decomposition</li>
 * <li>means-end</li>
 * <li>contribution</li>
 * </ul>
 * Related concepts such as <i>routines</i> or <i>capabilities</i> can be also
 * represented using this relationship.
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ielementlink")
public class IElementLinkTag {

    @XmlAttribute
    private String type; //decomposition, means-end, contribution, other*
    @XmlAttribute
    private String value; // (and,or), string, contribution-values*, other*
    @XmlElement(required = false)
    private GraphicTag graphicPath; // optional
    @XmlAnyElement
    private Set<IElementTag> elements; // must be at least one

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public GraphicTag getGraphicPath() {
        return graphicPath;
    }

    public void setGraphicPath(GraphicTag graphicPath) {
        this.graphicPath = graphicPath;
    }

    public Set<IElementTag> getElements() {
        return elements;
    }

    public void setElements(Set<IElementTag> elements) {
        this.elements = elements;
    }
}
