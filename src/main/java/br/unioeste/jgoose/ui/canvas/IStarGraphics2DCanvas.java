package br.unioeste.jgoose.ui.canvas;

import br.unioeste.jgoose.ui.shapes.ConnectorShape;
import br.unioeste.jgoose.util.IStarConstants;
import com.mxgraph.canvas.mxGraphics2DCanvas;

/**
 *
 * @author Leonardo
 */
public class IStarGraphics2DCanvas extends mxGraphics2DCanvas{
    
    static{
//        putShape("ator", new mxActorShape());
        putShape(IStarConstants.SHAPE_CONNECTOR, new ConnectorShape());
    }
}
