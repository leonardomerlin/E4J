package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.awt.Color;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represent some graphic properties of a particular diagram or diagram element.
 * 
 * @author Leonardo Merlin
 */
@XmlRootElement(name = "graphic")
public class Graphic {
    
    @XmlAttribute
    private String content; // svg | basic
    
    // g-options-[diagram|node|shape] - required
    @XmlAttribute private String xpos;
    @XmlAttribute private String ypos;
    @XmlAttribute private String width;
    @XmlAttribute private String height;
    // g-options-[diagram|node|shape|path] - optional
    @XmlAttribute private String unit;
    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlAttribute private Color bgcolor;
    // g-options-[node|shape|path] - optional
    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlAttribute private Color fontcolor;
    @XmlAttribute private String fontfamily;
    @XmlAttribute private String fontsize;
    
    // graphic-path
    @XmlElement private List<Point> points; //size > 2
    
    // g-options-[shape|path]
    @XmlAttribute private String shape; // shape(ellipse,rect), irregular,(polyline | spline)
    
}
