package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.ExitAction;
import br.unioeste.jgoose.e4j.actions.ImportAction;
import br.unioeste.jgoose.e4j.actions.NewAction;
import br.unioeste.jgoose.e4j.actions.OpenAction;
import br.unioeste.jgoose.e4j.actions.PageSetupAction;
import br.unioeste.jgoose.e4j.actions.PrintAction;
import br.unioeste.jgoose.e4j.actions.SaveAction;
import com.mxgraph.util.mxResources;
import javax.swing.JMenu;

public class FileJMenu extends JMenu {

    public FileJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("file"));
        add(editor.bind(mxResources.get("new"), new NewAction(), "/com/mxgraph/examples/swing/images/new.gif"));
        add(editor.bind(mxResources.get("openFile"), new OpenAction(), "/com/mxgraph/examples/swing/images/open.gif"));
        add(editor.bind(mxResources.get("importStencil"), new ImportAction(), "/com/mxgraph/examples/swing/images/open.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("save"), new SaveAction(false), "/com/mxgraph/examples/swing/images/save.gif"));
        add(editor.bind(mxResources.get("saveAs"), new SaveAction(true), "/com/mxgraph/examples/swing/images/saveas.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("pageSetup"), new PageSetupAction(), "/com/mxgraph/examples/swing/images/pagesetup.gif"));
        add(editor.bind(mxResources.get("print"), new PrintAction(), "/com/mxgraph/examples/swing/images/print.gif"));

        addSeparator();
        add(editor.bind(mxResources.get("exit"), new ExitAction()));
    }
}
