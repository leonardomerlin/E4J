package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A dependency is a relationship which represents 
 * the explicit dependency of an actor (depender) respect to 
 * the other actor (dependee).
 * 
 * The dependency is expressed with respect to an intentional element
 * 
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "dependency")
public class Dependency {
    
    @XmlElement(required = true)
    private List<Depender> depender; // must be at least one.
    
    @XmlElement(required = false)
    private List<Dependee> dependee;
    
}
