package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.awt.Color;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Leonardo
 */
public class ColorAdapter extends XmlAdapter<String, Color> {

    @Override
    public Color unmarshal(String v) throws Exception {
        return Color.decode(v);
    }

    @Override
    public String marshal(Color v) throws Exception {
        return "#" + Integer.toHexString(v.getRGB());
    }
}
