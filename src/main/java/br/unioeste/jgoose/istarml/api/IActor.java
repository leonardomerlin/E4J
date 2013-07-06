package br.unioeste.jgoose.istarml.api;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public interface IActor extends IElement {
    
    public boolean connect(IActor element, ILink link);
    //
    public boolean getIncomingLinks();
    public boolean getOutcomingLinks();
    //
    public boolean getBoundaryElements();
    public boolean getBoundaryLinks();
}
