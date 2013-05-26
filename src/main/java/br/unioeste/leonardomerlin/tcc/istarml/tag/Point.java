package br.unioeste.leonardomerlin.tcc.istarml.tag;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@XmlRootElement(name = "point")
class Point {
    
    @XmlAttribute
    private String xpos;
    
    @XmlAttribute
    private String ypos;
}
