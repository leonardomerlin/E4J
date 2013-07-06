package br.unioeste.jgoose.istarml.model;

import br.unioeste.jgoose.istarml.model.decorators.DiagramDecorator;
import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import br.unioeste.jgoose.istarml.model.tag.DiagramTag;
import br.unioeste.jgoose.istarml.model.tag.IStarMLTag;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class IStarMLModel {

    private static final Logger LOG = Logger.getLogger(IStarMLModel.class.getName());
    private IStarMLTag root;

    public IStarMLModel(IStarMLTag root) {
        this.root = root;
    }

    public IStarMLTag getRoot() {
        return root;
    }

    public void setRoot(IStarMLTag root) {
        this.root = root;
    }

    public Set<DiagramAdapter> getAllDiagrams() {
        Set<DiagramAdapter> result = new HashSet<>();
        Set<DiagramTag> tags = root.getDiagrams();
        for (DiagramTag diagramTag : tags) {
            result.add(new DiagramAdapter(this, diagramTag));
        }
        return result;
    }

    public Set<ActorTag> getAllActors() {
        Set<ActorTag> result = new HashSet<>();
        Set<DiagramTag> diagrams = this.root.getDiagrams();
        for (DiagramTag diagramTag : diagrams) {
            result.addAll(diagramTag.getActors());
        }

        return result;
    }

    public Set<ActorTag> getAllIElements() {
        Set<ActorTag> result = new HashSet<>();
        Set<DiagramTag> diagrams = this.root.getDiagrams();
        for (DiagramTag diagramTag : diagrams) {
            result.addAll(diagramTag.getActors());
        }

        return result;
    }

    public Set<ActorTag> getAllAgents() {
        Set<ActorTag> result = new HashSet<>();
        Set<DiagramTag> diagrams = this.root.getDiagrams();
        for (DiagramTag diagramTag : diagrams) {
            result.addAll(((DiagramDecorator) diagramTag).getAllAgents());
        }

        return result;
    }
}
