package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
public class Actor extends CommonsAttributes{
    
    /**
     * Can be: agent, role, position, *any*.
     */
    @XmlAttribute
    private String type;
    
    /**
     * Actor Reference.
     */
    @XmlAttribute(required = false)
    private String aref;
    
    @XmlElement(required = false)
    private Graphic graphicNode;
    
    @XmlElement
    private List<ActorLink> links;

    
}
