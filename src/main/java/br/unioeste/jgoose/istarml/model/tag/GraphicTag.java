package br.unioeste.jgoose.istarml.model.tag;

import br.unioeste.jgoose.istarml.api.model.adapter.ColorAdapter;
import java.awt.Color;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represent some graphic properties of a particular diagram or diagram element.
 *
 * @author Leonardo Merlin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "graphic")
public class GraphicTag {

    @XmlAttribute
    private String content; // svg | basic
    // g-options-[diagram|node|shape] - required
    @XmlAttribute
    private String xpos;
    @XmlAttribute
    private String ypos;
    @XmlAttribute
    private String width;
    @XmlAttribute
    private String height;
    // g-options-[diagram|node|shape|path] - optional
    @XmlAttribute
    private String unit;
    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlAttribute
    private Color bgcolor;
    // g-options-[node|shape|path] - optional
    @XmlJavaTypeAdapter(ColorAdapter.class)
    @XmlAttribute
    private Color fontcolor;
    @XmlAttribute
    private String fontfamily;
    @XmlAttribute
    private String fontsize;
    // graphic-path
    @XmlAnyElement
    private List<PointTag> points; //size > 2
    // g-options-[shape|path]
    @XmlAttribute
    private String shape; // shape(ellipse,rect), irregular,(polyline | spline)

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getXpos() {
        return xpos;
    }

    public void setXpos(String xpos) {
        this.xpos = xpos;
    }

    public String getYpos() {
        return ypos;
    }

    public void setYpos(String ypos) {
        this.ypos = ypos;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Color getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(Color bgcolor) {
        this.bgcolor = bgcolor;
    }

    public Color getFontcolor() {
        return fontcolor;
    }

    public void setFontcolor(Color fontcolor) {
        this.fontcolor = fontcolor;
    }

    public String getFontfamily() {
        return fontfamily;
    }

    public void setFontfamily(String fontfamily) {
        this.fontfamily = fontfamily;
    }

    public String getFontsize() {
        return fontsize;
    }

    public void setFontsize(String fontsize) {
        this.fontsize = fontsize;
    }

    public List<PointTag> getPoints() {
        return points;
    }

    public void setPoints(List<PointTag> points) {
        this.points = points;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
