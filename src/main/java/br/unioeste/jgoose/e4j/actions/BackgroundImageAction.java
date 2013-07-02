package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxResources;
import com.mxgraph.util.mxUtils;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

@SuppressWarnings(value = "serial")
public class BackgroundImageAction extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            String value = (String) JOptionPane.showInputDialog(graphComponent, mxResources.get("backgroundImage"), "URL", JOptionPane.PLAIN_MESSAGE, null, null, "http://www.callatecs.com/images/background2.JPG");
            if (value != null) {
                if (value.length() == 0) {
                    graphComponent.setBackgroundImage(null);
                } else {
                    Image background = mxUtils.loadImage(value);
                    // Incorrect URLs will result in no image.
                    // TODO provide feedback that the URL is not correct
                    if (background != null) {
                        graphComponent.setBackgroundImage(new ImageIcon(background));
                    }
                }
                // Forces a repaint of the outline
                graphComponent.getGraph().repaint();
            }
        }
    }
}
