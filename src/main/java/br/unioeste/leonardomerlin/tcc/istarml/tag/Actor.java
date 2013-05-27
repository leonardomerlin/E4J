package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

/**
 * An actor represents an entity which may be an organization, 
 * a unit of an organization, a single human or an autonomous piece of software.
 * Also it can represent abstractions over actors such as 
 * <code>agent</code>, <code>roles</code> and <code>positions</code>.
 * 
 * <p>
 * BNF:
 * <br/>actorTag ::=&nbsp;&lt;actor&nbsp;&nbsp;basicAtts&nbsp;[typeAtt]&nbsp;{extraAtt}&nbsp;&gt;
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[graphic-node]&nbsp;{actorLinkTag}&nbsp;[boundaryTag]
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/actor&gt;
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;actor&nbsp;basicAtts&nbsp;[typeAtt]&nbsp;{extraAtt}&nbsp;/&gt;
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;actor&nbsp;aref=“string”&nbsp;/&gt;
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;actor&nbsp;aref=“string”&gt;&nbsp;[graphic-node]&nbsp;&lt;/actor&gt;
 * <br/>
 * <br/>typeAtt&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;::=&nbsp;type=“actorType”
 * <br/>actorType&nbsp;&nbsp;&nbsp;::=&nbsp;basicActorType&nbsp;|&nbsp;string
 * <br/>basicActorType::=&nbsp;agent&nbsp;|&nbsp;role&nbsp;|&nbsp;position 
 * </p>
 * @author Leonardo
 */
@XmlRootElement(name = "actor")
public class Actor{
    
    private BasicAttributes basicAttrs;
    
    @XmlAnyAttribute
    protected Map<QName, String> extraAttrs = new HashMap<>();
    
    /**
     * Can be: agent, role, position, *any*.
     */
    private String type;
    
    /**
     * Actor Reference.
     */
    private String aref;
    
    private Graphic graphicNode;
    
    private List<ActorLink> links;

    public Actor() {
        this.basicAttrs = new BasicAttributes();
        this.links = new ArrayList<>();
    }
    
    @XmlAttribute
    public String getId() {
        return this.basicAttrs.getId();
    }
    
    public void setId(String id) {
        this.basicAttrs.setId(id);
    }
    
    @XmlAttribute
    public String getName() {
        return this.basicAttrs.getName();
    }

    public void setName(String name) {
        this.basicAttrs.setName(name);
    }
    
    @XmlAttribute(required = false)
    public String getRef() {
        return this.basicAttrs.getRef();
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
            throw new IllegalArgumentException("Can not be 'id', 'name', 'author' or other class attribute name.");
        }
        return this.extraAttrs.get(new QName(attributeName));
    }

    public void setAttribute(String name, String value) {
        this.extraAttrs.put(new QName(name), value);
    }

    @XmlAttribute
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

    @XmlElement(required = false)
    public Graphic getGraphicNode() {
        return graphicNode;
    }

    public void setGraphicNode(Graphic graphicNode) {
        this.graphicNode = graphicNode;
    }

    @XmlElement
    public List<ActorLink> getLinks() {
        return links;
    }

    public void setLinks(List<ActorLink> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Actor{" + basicAttrs + ", type=" + type + ", aref=" + aref + ", links=" + links.size()+ ", extraAttrs (" + extraAttrs + ")}";
    }
}
