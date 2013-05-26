package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
public class IElement extends CommonsAttributes{
    
    // basicAttrs, extraAttrs from parent.
    
    @XmlAnyAttribute
    private String type; // goal, softgoal, task, resources, other*
    
    @XmlAnyAttribute
    private String state; // undecided, satisfied, weakly satisfied, denied, weakly denied, other*
   
    @XmlAnyAttribute
    private String iref;
    
    
    @XmlElement(required = false)
    private Graphic graphicNode;
    
    @XmlElement
    private List<IElementLink> links;
}
