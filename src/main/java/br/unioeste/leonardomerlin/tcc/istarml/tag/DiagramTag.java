package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.ArrayList;
import java.util.List;
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
@XmlRootElement(name = "diagram")
public class DiagramTag {

    private String id;
    private String name;
    private String author;
    private Graphic graphic; //graphic-diagram
    private List<Actor> actors;
    private List<IntentionalElement> intentionalElements;

    public DiagramTag() {
        this.actors = new ArrayList<>();
        this.intentionalElements = new ArrayList<>();
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
        if (null == id && null == name) {
            throw new IllegalArgumentException("One of arguments (id or name) must be not null.");
        }
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

    @XmlElement
    public Graphic getGraphic() {
        return graphic;
    }

    public void setGraphic(Graphic graphic) {
        this.graphic = graphic;
    }

    @XmlAnyElement
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
    @XmlAnyElement
    public List<IntentionalElement> getIntentionalElements() {
        return intentionalElements;
    }

    public void setIntentionalElements(List<IntentionalElement> intentionalElements) {
        this.intentionalElements = intentionalElements;
    }

}
