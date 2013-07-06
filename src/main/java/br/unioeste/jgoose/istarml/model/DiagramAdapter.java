package br.unioeste.jgoose.istarml.model;

import br.unioeste.jgoose.istarml.model.tag.DiagramTag;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class DiagramAdapter {

    private IStarMLModel root;
    private DiagramTag tag;

    public DiagramAdapter(IStarMLModel root) {
        this(root, null);
    }

    public DiagramAdapter(IStarMLModel root, DiagramTag tag) {
        this.root = root;
        this.tag = tag;
        if (this.tag == null) {
            this.tag = new DiagramTag();
        }
    }

    public DiagramTag getTag() {
        return tag;
    }

    public void setTag(DiagramTag tag) {
        this.tag = tag;
    }

    public void getActors() {
        this.tag.getActors();
    }
}
