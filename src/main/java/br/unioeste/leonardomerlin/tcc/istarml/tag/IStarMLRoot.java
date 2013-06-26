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
 *
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "istarml")
public class IStarMLRoot {

    @XmlAttribute
    public final String version = "1.0";
    private List<DiagramTag> diagrams;

    public IStarMLRoot() {
        this.diagrams = new ArrayList<>();
        this.diagrams.add(new DiagramTag());
    }

    public IStarMLRoot(DiagramTag diagram) {
        if (null == diagram) {
            throw new IllegalArgumentException("'diagram' must be not null.");
        }

        this.diagrams = new ArrayList<>();
        this.diagrams.add(diagram);
    }

    @XmlElement(name = "diagrams")
    public List<DiagramTag> getDiagrams() {
        return diagrams;
    }

    public void setDiagrams(List<DiagramTag> diagrams) {
        this.diagrams = diagrams;
    }
}
