package br.unioeste.jgoose.istarml.model.tag;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "diagram")
public class DiagramTag {

    @XmlAttribute
    @XmlID
    private String id;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "author", required = false)
    private String author;
    @XmlElement
    private GraphicTag graphic; //graphic-diagram
    @XmlAnyElement
    private Set<ActorTag> actors;
    @XmlAnyElement
    private Set<IElementTag> intentionalElements;

    public DiagramTag() {
        this(null, null);
    }

    /**
     *
     * @param id Can be <code>null</code>. But, must be not <code>null</code> if
     * <b><code>name</code></b> is <code>null</code>.
     * @param name Can be <code>null</code>. But, must be not <code>null</code>
     * if <b><code>id</code></b> is <code>null</code>.
     * @see DiagramTag
     */
    public DiagramTag(String id, String name) {
        //@TODO: verify in 'above level'
//        if (null == id && null == name) {
//            throw new IllegalArgumentException("One of arguments (id or name) must be not null.");
//        }
        this.id = id;
        this.name = name;

        this.actors = new HashSet<>();
        this.intentionalElements = new HashSet<>();
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

    /**
     *
     * @return
     */
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

    public GraphicTag getGraphic() {
        return graphic;
    }

    public void setGraphic(GraphicTag graphic) {
        this.graphic = graphic;
    }

    public Set<ActorTag> getActors() {
        return actors;
    }

    public void setActors(Set<ActorTag> actors) {
        this.actors = actors;
    }

    public Set<IElementTag> getIntentionalElements() {
        return intentionalElements;
    }

    public void setIntentionalElements(Set<IElementTag> intentionalElements) {
        this.intentionalElements = intentionalElements;
    }
}
