package br.unioeste.jgoose.istarml.model.tag;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dependee")
public class DependeeTag {

    @XmlAttribute(required = true)
    private String aref;
    @XmlAttribute(required = false)
    private String iref;
    /**
     * open | committed | critical | delegation | permission | trust | owner |
     * *string*
     */
    @XmlAttribute(required = false)
    private String value;
    @XmlElement
    private GraphicTag graphic;

    public String getAref() {
        return aref;
    }

    public void setAref(String aref) {
        this.aref = aref;
    }

    public String getIref() {
        return iref;
    }

    public void setIref(String iref) {
        this.iref = iref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public GraphicTag getGraphic() {
        return graphic;
    }

    public void setGraphic(GraphicTag graphic) {
        this.graphic = graphic;
    }
}
