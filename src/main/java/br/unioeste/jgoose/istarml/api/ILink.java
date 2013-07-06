package br.unioeste.jgoose.istarml.api;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public interface ILink {
    
    /**
     * Links between actors.
     */
    public interface IActorLink extends ILink{}
    public interface IActorIsA extends IActorLink{}
    public interface IActorIsPartOF extends IActorLink{}
    public interface IActorCovers extends IActorLink{}
    public interface IActorPlays extends IActorLink{}
    public interface IActorOccupies extends IActorLink{}
    public interface IActorIns extends IActorLink{}
    
    public interface IDependency extends ILink{}
    public interface IDecomposition extends ILink{}
    public interface IMeansEnd extends ILink{}
    public interface IContribution extends ILink{}
}
