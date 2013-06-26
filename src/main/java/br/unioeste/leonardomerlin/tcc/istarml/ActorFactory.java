package br.unioeste.leonardomerlin.tcc.istarml;

import br.unioeste.leonardomerlin.tcc.istarml.tag.Actor;
import br.unioeste.leonardomerlin.tcc.istarml.tag.ActorImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class ActorFactory {

    /**
     * Map Id -> Actor. Where id is a unique String reference of Actor.
     */
    private static Map<String, Actor> references = new HashMap<>();
    
    public static Actor createActor(){
        Actor actor = new ActorImpl();
        return actor;
    }
    
    public static Actor createAgent(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static Actor createRole(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static Actor createPosition(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Get the reference. Create if not exist.
     * @param actor
     * @return a Unique Reference.
     */
    public static String getReference(Actor actor) {
        // get referece
        
        // or
        // create reference
        // set reference
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
