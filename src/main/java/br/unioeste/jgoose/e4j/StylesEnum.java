package br.unioeste.jgoose.e4j;

import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import java.awt.Color;

/**
 *
 * adapted from: http://www.vainolo.com/2011/05/13/jgraph-styles/
 */
public enum StylesEnum {

    OPACITY(mxConstants.STYLE_OPACITY, 50.0),
    TEXT_OPACITY(mxConstants.STYLE_TEXT_OPACITY, 50.0),
    OVERFLOW_1(mxConstants.STYLE_OVERFLOW, "visible"),
    OVERFLOW_2(mxConstants.STYLE_OVERFLOW, "hidden"),
    OVERFLOW_3(mxConstants.STYLE_OVERFLOW, "fill"),
    ROTATION(mxConstants.STYLE_ROTATION, 45),
    FILLCOLOR(mxConstants.STYLE_FILLCOLOR, mxUtils.getHexColorString(Color.RED)),
    GRADIENTCOLOR(mxConstants.STYLE_GRADIENTCOLOR, mxUtils.getHexColorString(Color.BLUE)),
    GRADIENT_DIRECTION(mxConstants.STYLE_GRADIENT_DIRECTION, mxConstants.DIRECTION_EAST, mxConstants.STYLE_GRADIENTCOLOR, mxUtils.getHexColorString(Color.YELLOW)),
    STROKECOLOR(mxConstants.STYLE_STROKECOLOR, mxUtils.getHexColorString(Color.GREEN)),
    STROKEWIDTH(mxConstants.STYLE_STROKEWIDTH, 5),
    ALIGN(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT),
    VERTICAL_ALIGN(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_BOTTOM),
    LABEL_POSITION(mxConstants.STYLE_LABEL_POSITION, mxConstants.ALIGN_LEFT),
    VERTICAL_LABEL_POSITION(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_BOTTOM),
    GLASS(mxConstants.STYLE_GLASS, 1),
    NOLABEL(mxConstants.STYLE_NOLABEL, 1),
    LABEL_BACKGROUNDCOLOR(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, mxUtils.getHexColorString(Color.CYAN)),
    LABEL_BORDERCOLOR(mxConstants.STYLE_LABEL_BORDERCOLOR, mxUtils.getHexColorString(Color.PINK)),
    SHADOW(mxConstants.STYLE_SHADOW, true),
    DASHED(mxConstants.STYLE_DASHED, true),
    ROUNDED(mxConstants.STYLE_ROUNDED, true),
    HORIZONTAL(mxConstants.STYLE_HORIZONTAL, false),
    FONTCOLOR(mxConstants.STYLE_FONTCOLOR, mxUtils.getHexColorString(Color.ORANGE)),
    FONTFAMILY(mxConstants.STYLE_FONTFAMILY, "Times New Roman"),
    FONTSIZE(mxConstants.STYLE_FONTSIZE, 15),
    FONTSTYLE(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
    public String mxStyle;

    StylesEnum(Object... values) {
        mxStyle = "";
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                mxStyle += values[i] + "=";
            } else {
                mxStyle += values[i] + ";";
            }
        }
    }
}
