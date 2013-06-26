package br.unioeste.leonardomerlin.tcc.istarml.api;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public interface IStarML {
    
    // Diagrams
    public DiagramImpl createDiagram();
    public boolean removeDiagram(DiagramImpl obj);
    public List<DiagramImpl> getAllDiagrams();
    public DiagramImpl createDiagram(String name);
    public DiagramImpl getDiagramById(String id);
    public DiagramImpl getDiagramByName(String name);
    
    // Actors: 
    // Agent, Role, Position, Other
    public ActorImpl createActor();
    public boolean removeActor(ActorImpl obj);
    public List<ActorImpl> getAllActors();
    public ActorImpl createAgent();
    public ActorImpl createRole();
    public ActorImpl createPosition();
    public boolean changeToAgent(ActorImpl actor);
    public boolean changeToRole(ActorImpl actor);
    public boolean changeToPosition(ActorImpl actor);
    
    // Intentional Elements:
    // Goal, SoftGoal, Task, Resource, Other
    public IntentionalElement createIntentionalElement();
    public boolean removeIntentionalElement(IntentionalElement obj);
    public List<IntentionalElement> getAllIntentionalElements();
    public IntentionalElement createGoal();
    public IntentionalElement createSoftGoal();
    public IntentionalElement createTask();
    public IntentionalElement createResource();
    
    // Relationships or Links:
    // decomposition, means-end, contribution, other
    public Relationship connect(IntentionalElement src, IntentionalElement dst);
    public Relationship connect(IntentionalElement src, IntentionalElement... dst);
    public boolean removeConnection(IntentionalElement src, IntentionalElement dst);
    public List<Relationship> getAllOutConnections(IntentionalElement src);
    public List<Relationship> getAllInConnections(IntentionalElement src);
    
    // Dependency:
    // open, commited, critical, delegation, permission, trust, owner, other
    public void makeDependency();
    
    // MISC
    public void checkGuidelines();
}
