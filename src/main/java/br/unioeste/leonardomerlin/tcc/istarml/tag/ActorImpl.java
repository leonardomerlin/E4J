package br.unioeste.leonardomerlin.tcc.istarml.tag;

import br.unioeste.leonardomerlin.tcc.istarml.ActorFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Leonardo
 */
@XmlRootElement(name = "actor")
public class ActorImpl implements Actor {

    private String id;
    private String name;
    private Map<QName, String> extraAttrs = new HashMap<>();
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

    @XmlAttribute
    @XmlID
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getReference() {
        boolean hasId;

        String _id = this.getId();
        hasId = (_id != null && !_id.isEmpty());

        if (hasId) {
            return _id;
        }

        String newId = ActorFactory.getReference(this);
        this.setId(newId);

        return this.getId();
    }

    /**
     *
     * @param attributeName - Can not be 'id', 'name', 'author' or other class
     * attribute name.
     * @return the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public String getAttributeValue(String attributeName) {
        if ((attributeName.equals("id") || (attributeName.equals("name"))
                || attributeName.equals("author"))) {
            throw new IllegalArgumentException("Can not be 'id', 'name', "
                    + "'author' or other class attribute name.");
        }
        return this.extraAttrs.get(new QName(attributeName));
    }

    @Override
    public void setAttribute(String name, String value) {
        this.extraAttrs.put(new QName(name), value);
    }

    @XmlAnyAttribute
    public Map<QName, String> getExtraAttrs() {
        return this.extraAttrs;
    }

    @XmlAttribute
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    @Override
    public String getAref() {
        return aref;
    }

    @Override
    public void setAref(Actor aref) {
        this.aref = aref.getReference();
    }

    @XmlElement(required = false)
    @Override
    public Graphic getGraphicNode() {
        return graphicNode;
    }

    @Override
    public void setGraphicNode(Graphic graphicNode) {
        this.graphicNode = graphicNode;
    }

    @XmlElement
    @Override
    public List<ActorLink> getLinks() {
        return links;
    }

    @Override
    public void setLinks(List<ActorLink> links) {
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
