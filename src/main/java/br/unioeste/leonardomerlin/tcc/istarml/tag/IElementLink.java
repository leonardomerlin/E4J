package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  An intentional element link represents an n-ary relationship among 
 *  intentional elements (either in the actor’s boundary or outside). 
 *  <br/>
 *  Broadly used types of intentional element link are:
 *  <ul>
 *	<li>decomposition</li>
 *	<li>means-end</li>
 *	<li>contribution</li>
 *  </ul>
 * Related concepts such as <i>routines</i> or <i>capabilities</i> can be also
 * represented using this relationship.
 * @author Leonardo
 */
@XmlRootElement(name = "ielementlink")
public class IElementLink {
    
    @XmlAttribute
    private String type; //decomposition, means-end, contribution, other*
    
    @XmlAttribute
    private String value; // (and,or), string, contribution-values*, other*
    
    @XmlElement(required = false)
    private Graphic graphicPath; // optional
    
    @XmlElement(required = true)
    private List<IElement> elements; // must be at least one
}
