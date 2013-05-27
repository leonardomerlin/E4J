package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A boundary represents a group of intentional elements.
 * <p>The common type of boundary is the actor’s boundary which represents the 
 * vision of an omnipresent objective observer with respect to the actor’s scope.
 * However other boundary types can also be used.</p>
 * @author Leonardo
 */
@XmlRootElement(name = "boundary")
public class Boundary {
    
    @XmlAttribute
    private String type;
    
    @XmlElement
    private Graphic graphPath;
    
    @XmlElement
    private List<IElement> elements;
    
    @XmlElement
    private List<IElement> actors;

    public Boundary() {
    }
}
