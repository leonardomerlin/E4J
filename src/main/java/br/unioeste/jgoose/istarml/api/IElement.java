package br.unioeste.jgoose.istarml.api;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public interface IElement {
    public boolean connect(IElement element, ILink link);
    public boolean connectTo(IElement element, ILink link);
}
