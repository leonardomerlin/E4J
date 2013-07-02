package br.unioeste.jgoose.e4j.actions;

import com.mxgraph.swing.mxGraphComponent;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.AbstractAction;

@SuppressWarnings(value = "serial")
public class PrintAction extends AbstractAction {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof mxGraphComponent) {
            mxGraphComponent graphComponent = (mxGraphComponent) e.getSource();
            PrinterJob pj = PrinterJob.getPrinterJob();
            if (pj.printDialog()) {
                PageFormat pf = graphComponent.getPageFormat();
                Paper paper = new Paper();
                double margin = 36;
                paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
                pf.setPaper(paper);
                pj.setPrintable(graphComponent, pf);
                try {
                    pj.print();
                } catch (PrinterException e2) {
                    System.out.println(e2);
                }
            }
        }
    }

}
