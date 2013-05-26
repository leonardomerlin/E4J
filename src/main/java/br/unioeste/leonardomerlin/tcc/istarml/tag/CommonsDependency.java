package br.unioeste.leonardomerlin.tcc.istarml.tag;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Common Attributes between 'depender' and 'dependee'.
 * 
 * Accessible only in this package.
 * 
 * @author Leonardo
 */
class CommonsDependency {

    @XmlAttribute(required = true)
    private String aref;
    
    @XmlAttribute(required = false)
    private String iref;
    
    @XmlAttribute(required = false)
    private String value; // open | committed | critical | delegation | permission | trust | owner | string
    
    @XmlElement
    private Graphic graphic;
}
