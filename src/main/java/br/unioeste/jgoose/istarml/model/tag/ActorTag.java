package br.unioeste.jgoose.istarml.model.tag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import org.apache.commons.lang3.StringUtils;

/**
 * ActorTag tag xml-object mapping.
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "actor")
public class ActorTag {

    @XmlAttribute
    @XmlID
    private String id;
    @XmlAttribute
    private String name;
    @XmlAnyAttribute
    private Map<QName, String> extraAttrs;
    /**
     * Can be: actor, agent, role, position, *any*.
     */
    @XmlAttribute
    private String type;
    /**
     * ActorTag Reference.
     */
    @XmlAttribute
    private String aref;
    @XmlElement(required = false)
    private GraphicTag graphic;
    @XmlAnyElement
    private Set<ActorLinkTag> links;
    @XmlElement
    private BoundaryTag boundary;

    public ActorTag() {
        this.extraAttrs = new HashMap<>();
        this.links = new HashSet<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * No check or validation is done here.
     *
     * @param aref
     */
    public void setAref(String aref) {
        this.aref = aref;
    }

    public BoundaryTag getBoundary() {
        return boundary;
    }

    public void setBoundary(BoundaryTag boundary) {
        this.boundary = boundary;
    }

    public GraphicTag getGraphic() {
        return graphic;
    }

    public void setGraphic(GraphicTag graphicNode) {
        this.graphic = graphicNode;
    }

    public Set<ActorLinkTag> getLinks() {
        return links;
    }

    /**
     *
     * @param attributeName - Can not be 'id', 'name', 'author' or other class
     * attribute name.
     * @return the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public String getAttributeValue(String attributeName) {
        if ((attributeName.equals("id") || (attributeName.equals("name"))
                || attributeName.equals("author"))) {
            throw new IllegalArgumentException("Can not be 'id', 'name', "
                    + "'author' or other class attribute name.");
        }
        return this.extraAttrs.get(new QName(attributeName));
    }

    public void setAttribute(String name, String value) {
        this.extraAttrs.put(new QName(name), value);
    }

    public Map<QName, String> getExtraAttrs() {
        return this.extraAttrs;
    }

    public String getAref() {
        return aref;
    }

    public void setLinks(Set<ActorLinkTag> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Actor{");

        if (StringUtils.isNotBlank(this.id)) {
            sb.append("[id=").append(this.id).append(']');
        }

        if (StringUtils.isNotBlank(this.name)) {
            sb.append("[name=").append(this.name).append(']');
        }

        if (StringUtils.isNotBlank(this.type)) {
            sb.append("[type=").append(this.type).append(']');
        }

        if (StringUtils.isNotBlank(this.aref)) {
            sb.append("[aref=").append(this.aref).append(']');
        }
        sb.append("[links=").append(this.links.size()).append(']');

        return sb.append("}").toString();
    }
}
