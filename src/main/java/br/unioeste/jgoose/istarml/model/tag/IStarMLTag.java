package br.unioeste.jgoose.istarml.model.tag;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the main tag of the iStarML.
 *
 * <p>XML-BNF reference:
 * <code>
 * <br/>&lt;istarml&nbsp;VERSION=“1.0”&gt;
 * <br/>&nbsp;diagramTag {diagramTag}
 * <br/>&lt;/istarml&gt;
 * </code>
 * </p>
 *
 * @author Leonardo Merlin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "istarml")
public class IStarMLTag {

    @XmlAttribute
    public final static String VERSION = "1.0";
    @XmlAnyElement
    private Set<DiagramTag> diagrams;

    public IStarMLTag() {
        this.diagrams = new HashSet<>();
        this.diagrams.add(new DiagramTag());
    }

    public Set<DiagramTag> getDiagrams() {
        return diagrams;
    }

    public void setDiagrams(Set<DiagramTag> diagrams) {
        this.diagrams = diagrams;
    }
}
