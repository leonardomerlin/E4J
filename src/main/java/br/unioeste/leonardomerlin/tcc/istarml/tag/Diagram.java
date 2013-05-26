package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

/**
 * This is a particular i* diagram.
 *
 * <p>XML-BNF reference:
 * <code>
 * <br/>&lt;istarml&nbsp;version="1.0"&gt;
 * <br/>&nbsp;&lt;diagram&nbsp;([id="string"] name="string" | id="string"
 * [name="string"])&nbsp;[author="string"]&nbsp;{attributeName=attributeValue}&nbsp;&gt;&nbsp;
 * <br/>&nbsp;[graphic-diagram]&nbsp;{&nbsp;[actorTag]&nbsp;|&nbsp;[ielementExTag]}&nbsp;
 * <br/>&nbsp;&lt;/diagram&gt;
 * <br/>&lt;/istarml&gt;
 * </code>
 * </p>
 *
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "diagram")
public class Diagram extends CommonsAttributes{
    
    // basicAttrs(id, name), extraAttrs from parent.
    
//    @XmlAttribute(name = "author", required = false) // in 'get' method.
    private String author;
    
    @XmlElement
    private Graphic graphic; //graphic-diagram

    @XmlElement
    private List<Actor> actors;
    
    @XmlElement
    private List<IElement> iElementExTag;
    
    /**
     *
     * @param id Can be <code>null</code>. But, must be not <code>null</code> if
     * <b><code>name</code></b> is <code>null</code>.
     * @param name Can be <code>null</code>. But, must be not <code>null</code>
     * if <b><code>id</code></b> is <code>null</code>.
     * @see Diagram
     */
    public Diagram(String id, String name) {
        if (null == id && null == name) {
            throw new IllegalArgumentException("One of arguments (id or name) must be not null.");
        }
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return
     */
    @XmlAttribute(name = "author", required = false)
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

}
