package br.unioeste.leonardomerlin.tcc.istarml.api;

import br.unioeste.leonardomerlin.tcc.istarml.tag.Actor;
import br.unioeste.leonardomerlin.tcc.istarml.tag.DiagramTag;

/**
 *
 * @author Leonardo
 */
public class DiagramImpl {
    private DiagramTag diagram;

    public DiagramImpl(DiagramTag diagram) {
        this.diagram = diagram;
    }
    
    public boolean addActor(Actor actor){
        return this.diagram.getActors().add(actor);
    }
}
