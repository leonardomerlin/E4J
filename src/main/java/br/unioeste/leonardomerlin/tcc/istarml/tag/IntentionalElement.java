package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

/**
 * An intentional element is an entity which allows to relate 
 * different actors conforming a social network or, also, 
 * to express the internal rationality of an actor.
 * <p>Broadly used types of intentional elements are:
 * <ul>
 *  <li>goal</li>
 *  <li>softgoal</li>
 *  <li>resource</li>
 *  <li>task</li>
 * </ul>
 * </p>
 * @author Leonardo
 */
@XmlRootElement(name = "ielement")
public class IntentionalElement {
    
    private String id;
    
    private String name;
    
    @XmlAnyAttribute
    protected Map<QName, String> extraAttrs = new HashMap<>();
    
    @XmlAttribute
    private String type; // goal, softgoal, task, resources, other*
    
    @XmlAttribute
    private String state; // undecided, satisfied, weakly satisfied, denied, weakly denied, other*
   
    @XmlAttribute
    private String iref;
    
    
    @XmlElement(required = false)
    private Graphic graphicNode;
    
    @XmlElement
    private List<IntentionalElementLink> links;

    public IntentionalElement() {
        this.links = new ArrayList<>();
    }
    
    @XmlAttribute
    @XmlID
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
    
}
