package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 * An actor represents an entity which may be an organization, a unit of an
 * organization, a single human or an autonomous piece of software. Also it can
 * represent abstractions over actors such as
 * <code>agent</code>,
 * <code>roles</code> and
 * <code>positions</code>.
 *
 * <p>
 * BNF:
 * <blockquote>
 * <pre>
 * actorTag ::= 
 *    &lt;actor  basicAtts [typeAtt] {extraAtt} &gt;
 *      [graphic-node] {actorLinkTag} [boundaryTag]
 *      &lt;/actor&gt;
 *      |
 *      &lt;actor basicAtts [typeAtt] {extraAtt} /&gt;
 *      |
 *      &lt;actor aref=“string” /&gt;
 *      |
 *      &lt;actor aref=“string”&gt; [graphic-node] &lt;/actor&gt;
 * typeAtt     ::= type=“actorType”
 * actorType   ::= basicActorType | string
 * basicActorType::= agent | role | position
 * </pre>
 * </blockquote>
 
 * </p>
 *
 * @author Leonardo
 */
public interface Actor {

    public String getId();

    public void setId(String id);

    public String getName();

    public void setName(String name);

    public String getReference();

    /**
     *
     * @param attributeName - Can not be 'id', 'name', 'author' or other class
     * attribute name.
     * @return the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public String getAttributeValue(String attributeName);

    public void setAttribute(String name, String value);

    public String getType();

    public void setType(String type);

    public String getAref();

    public void setAref(Actor aref);

    public Graphic getGraphicNode();

    public void setGraphicNode(Graphic graphicNode);

    public List<ActorLink> getLinks();

    public void setLinks(List<ActorLink> links);
}
