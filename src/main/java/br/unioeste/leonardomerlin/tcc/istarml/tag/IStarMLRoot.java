package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the main tag of the iStarML.
 * 
 * <p>XML-BNF reference:
 * <code>
 * <br/>&lt;istarml&nbsp;version=“1.0”&gt;
 * <br/>&nbsp;diagramTag {diagramTag}
 * <br/>&lt;/istarml&gt;
 * </code>
 * </p>
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "istarml")
public class IStarMLRoot {
    
    @XmlAttribute
    public final String version = "1.0";
    
    private List<Diagram> diagrams;

    public IStarMLRoot() {
        this.diagrams = new ArrayList<>();
    }

    @XmlElement(name = "diagrams")
    public List<Diagram> getDiagrams() {
        return diagrams;
    }

    public void setDiagrams(List<Diagram> diagrams) {
        this.diagrams = diagrams;
    }
    
}
