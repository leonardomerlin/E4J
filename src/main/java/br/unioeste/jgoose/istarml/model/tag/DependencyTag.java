package br.unioeste.jgoose.istarml.model.tag;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A dependency is a relationship which represents the explicit dependency of an
 * actor (depender) respect to the other actor (dependee).
 *
 * The dependency is expressed with respect to an intentional element
 *
 * @author Leonardo Merlin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dependency")
public class DependencyTag {

    @XmlElement(required = true)
    private Set<DependerTag> depender; // must be at least one.
    @XmlElement(required = false)
    private Set<DependeeTag> dependee;

    public DependencyTag() {
        this.depender = new HashSet<>();
        this.dependee = new HashSet<>();
    }

    public Set<DependerTag> getDepender() {
        return depender;
    }

    public void setDepender(Set<DependerTag> depender) {
        this.depender = depender;
    }

    public Set<DependeeTag> getDependee() {
        return dependee;
    }

    public void setDependee(Set<DependeeTag> dependee) {
        this.dependee = dependee;
    }
}
