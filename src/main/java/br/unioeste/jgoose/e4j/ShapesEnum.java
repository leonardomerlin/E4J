package br.unioeste.jgoose.e4j;

import com.mxgraph.util.mxConstants;

/**
 * Set enums for the mxConstants.
 * 
 * adapted from: http://www.vainolo.com/2011/05/13/jgraph-styles/
 */
public enum ShapesEnum {

    RECTANGLE(mxConstants.SHAPE_RECTANGLE),
    ELLIPSE(mxConstants.SHAPE_ELLIPSE),
    DOUBLE_ELLIPSE(mxConstants.SHAPE_DOUBLE_ELLIPSE),
    RHOMBUS(mxConstants.SHAPE_RHOMBUS),
    LINE(mxConstants.SHAPE_LINE),
    IMAGE(mxConstants.SHAPE_IMAGE),
    ARROW(mxConstants.SHAPE_ARROW), //doesn't work
    CURVE(mxConstants.SHAPE_CURVE),
    LABEL(mxConstants.SHAPE_LABEL),
    CILINDER(mxConstants.SHAPE_CYLINDER),
    SWIMLANE(mxConstants.SHAPE_SWIMLANE),
    CONNECTOR(mxConstants.SHAPE_CONNECTOR),
    ACTOR(mxConstants.SHAPE_ACTOR),
    CLOUD(mxConstants.SHAPE_CLOUD),
    TRIANGLE(mxConstants.SHAPE_TRIANGLE),
    HEXAGON(mxConstants.SHAPE_HEXAGON);
    //
    public String mxShapeConstantValue;

    ShapesEnum(String mxShapeConstantValue) {
        this.mxShapeConstantValue = mxShapeConstantValue;
    }
}
