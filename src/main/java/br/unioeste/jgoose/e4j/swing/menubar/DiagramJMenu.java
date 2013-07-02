package br.unioeste.jgoose.e4j.swing.menubar;

import br.unioeste.jgoose.e4j.swing.BasicGraphEditor;
import br.unioeste.jgoose.e4j.actions.BackgroundAction;
import br.unioeste.jgoose.e4j.actions.BackgroundImageAction;
import br.unioeste.jgoose.e4j.actions.GenerateUseCaseAction;
import br.unioeste.jgoose.e4j.actions.GridColorAction;
import br.unioeste.jgoose.e4j.actions.GridStyleAction;
import br.unioeste.jgoose.e4j.actions.PageBackgroundAction;
import br.unioeste.jgoose.e4j.actions.PromptPropertyAction;
import br.unioeste.jgoose.e4j.actions.SelectShortestPathAction;
import br.unioeste.jgoose.e4j.actions.SelectSpanningTreeAction;
import br.unioeste.jgoose.e4j.actions.StylesheetAction;
import br.unioeste.jgoose.e4j.actions.ToggleOutlineItem;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxResources;
import com.mxgraph.view.mxGraph;
import javax.swing.JMenu;

public class DiagramJMenu extends JMenu{

    public DiagramJMenu(final BasicGraphEditor editor) {
        super(mxResources.get("diagram"));
        final mxGraphComponent graphComponent = editor.getGraphComponent();
        final mxGraph graph = graphComponent.getGraph();
        
        add(editor.bind("Gerar Casos de Uso", new GenerateUseCaseAction()));
        add(new ToggleOutlineItem(editor, mxResources.get("outline")));

        addSeparator();

        JMenu submenu = (JMenu) add(new JMenu(mxResources.get("background")));

        submenu.add(editor.bind(mxResources.get("backgroundColor"), new BackgroundAction()));
        submenu.add(editor.bind(mxResources.get("backgroundImage"), new BackgroundImageAction()));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("pageBackground"), new PageBackgroundAction()));

        submenu = (JMenu) add(new JMenu(mxResources.get("grid")));

        submenu.add(editor.bind(mxResources.get("gridSize"), new PromptPropertyAction(graph, "Grid Size", "GridSize")));
        submenu.add(editor.bind(mxResources.get("gridColor"), new GridColorAction()));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("dashed"), new GridStyleAction(mxGraphComponent.GRID_STYLE_DASHED)));
        submenu.add(editor.bind(mxResources.get("dot"), new GridStyleAction(mxGraphComponent.GRID_STYLE_DOT)));
        submenu.add(editor.bind(mxResources.get("line"), new GridStyleAction(mxGraphComponent.GRID_STYLE_LINE)));
        submenu.add(editor.bind(mxResources.get("cross"), new GridStyleAction(mxGraphComponent.GRID_STYLE_CROSS)));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("layout")));

        submenu.add(editor.graphLayout("verticalHierarchical", true));
        submenu.add(editor.graphLayout("horizontalHierarchical", true));

        submenu.addSeparator();

        submenu.add(editor.graphLayout("verticalPartition", false));
        submenu.add(editor.graphLayout("horizontalPartition", false));

        submenu.addSeparator();

        submenu.add(editor.graphLayout("verticalStack", false));
        submenu.add(editor.graphLayout("horizontalStack", false));

        submenu.addSeparator();

        submenu.add(editor.graphLayout("verticalTree", true));
        submenu.add(editor.graphLayout("horizontalTree", true));

        submenu.addSeparator();

        submenu.add(editor.graphLayout("placeEdgeLabels", false));
        submenu.add(editor.graphLayout("parallelEdges", false));

        submenu.addSeparator();

        submenu.add(editor.graphLayout("organicLayout", true));
        submenu.add(editor.graphLayout("circleLayout", true));

        submenu = (JMenu) add(new JMenu(mxResources.get("selection")));

        submenu.add(editor.bind(mxResources.get("selectPath"), new SelectShortestPathAction(false)));
        submenu.add(editor.bind(mxResources.get("selectDirectedPath"), new SelectShortestPathAction(true)));

        submenu.addSeparator();

        submenu.add(editor.bind(mxResources.get("selectTree"), new SelectSpanningTreeAction(false)));
        submenu.add(editor.bind(mxResources.get("selectDirectedTree"), new SelectSpanningTreeAction(true)));

        addSeparator();

        submenu = (JMenu) add(new JMenu(mxResources.get("stylesheet")));

        submenu.add(editor.bind(mxResources.get("basicStyle"),
                new StylesheetAction("/com/mxgraph/examples/swing/resources/basic-style.xml")));
        submenu.add(editor.bind(mxResources.get("defaultStyle"), new StylesheetAction(
                "/com/mxgraph/examples/swing/resources/default-style.xml")));
    }

}
