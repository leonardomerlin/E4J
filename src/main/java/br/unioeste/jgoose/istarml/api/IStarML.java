package br.unioeste.jgoose.istarml.api;

import java.util.List;

/**
 *
 * @author Leonardo
 */
public interface IStarML {
    
    // Diagrams
    public IDiagram createDiagram();
    public boolean removeDiagram(IDiagram obj);
    public List<IDiagram> getAllDiagrams();
    public IDiagram createDiagram(String name);
    public IDiagram getDiagramById(String id);
    public IDiagram getDiagramByName(String name);
    
    // Actors: 
    public boolean addActor(IActor actor);
    // FACILITIES
    public boolean addActor(String name);
    public boolean addActor(String id, String name);
//    public boolean addRole(...);
//    public boolean addAgent(..);
//    public boolean addPosition(..);
    
    // Agent, Role, Position, Other
    public IActor createActor();
    public boolean removeActor(IActor obj);
    public List<IActor> getAllActors();
    public IActor createAgent();
    public IActor createRole();
    public IActor createPosition();
    
    public boolean changeToAgent(IActor actor);
    public boolean changeToRole(IActor actor);
    public boolean changeToPosition(IActor actor);
    
    // Intentional Elements:
    // Goal, SoftGoal, Task, Resource, Other
    public IIntentionalElement createIntentionalElement();
    public boolean removeIntentionalElement(IIntentionalElement obj);
    public List<IIntentionalElement> getAllIntentionalElements();
    public IIntentionalElement createGoal();
    public IIntentionalElement createSoftGoal();
    public IIntentionalElement createTask();
    public IIntentionalElement createResource();
    
    // Relationships or Links:
    // decomposition, means-end, contribution, other
    public boolean connect(IIntentionalElement src, IIntentionalElement dst);
    public boolean connect(IIntentionalElement src, IIntentionalElement... dst);
    public boolean removeConnection(IIntentionalElement src, IIntentionalElement dst);
    public List<IIntentionalElement> getAllOutConnections(IIntentionalElement src);
    public List<IIntentionalElement> getAllInConnections(IIntentionalElement src);
    
    // Dependency:
    // open, commited, critical, delegation, permission, trust, owner, other
    public void makeDependency();
    
    // MISC
    public void checkGuidelines();
}
