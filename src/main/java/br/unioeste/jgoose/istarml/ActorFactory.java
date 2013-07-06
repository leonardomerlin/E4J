package br.unioeste.jgoose.istarml;

import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import br.unioeste.jgoose.istarml.model.tag.ActorTag;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Leonardo
 */
public class ActorFactory {

    /**
     * Map Id -> ActorTag. Where id is a unique String reference of ActorTag.
     */
    private static Map<String, ActorTag> references = new HashMap<>();
    
    public static ActorTag createActor(){
        ActorTag actor = new ActorTag();
        return actor;
    }
    
    public static ActorTag createAgent(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static ActorTag createRole(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public static ActorTag createPosition(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Get the reference. Create if not exist.
     * @param actor
     * @return a Unique Reference.
     */
    public static String getReference(ActorTag actor) {
        // get referece
        
        // or
        // create reference
        // set reference
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
