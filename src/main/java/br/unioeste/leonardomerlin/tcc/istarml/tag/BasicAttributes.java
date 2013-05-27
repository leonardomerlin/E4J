package br.unioeste.leonardomerlin.tcc.istarml.tag;

/**
 * BasicAtts. (id, name).<br/>
 * 
 * @author Leonardo
 */
class BasicAttributes {
    
    protected String id;
    
    protected String name;

    public BasicAttributes() {
    }

    public BasicAttributes(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        if ((null == this.id && null == name) || id.isEmpty()) {
            throw new IllegalArgumentException("Both attributes (id and name) can not be null. See class details or the language spec.");
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ((null == this.name && null == name) || name.isEmpty()) {
            throw new IllegalArgumentException("Both attributes (id and name) can not be null. See class details or the language spec.");
        }
        
        this.name = name;
    }

    
    public String getRef() {
        boolean noId, noName;

        noId = (this.getId() == null || this.getId().isEmpty());
        noName = (this.getName() == null || this.getName().isEmpty());
        
        if (noId && noName) {
            //TODO: error - write some info in text file.
            throw new InternalError("Actor has no 'id' and no 'name'.");
        }
        
        if (noId) {
            return this.getName();
        }
        
        if (noName) {
            return this.getId();
        }
        
        // impossible to finish in here!?
        throw new InternalError("Critical error in basic implementation 'set/get'.");
    }
}
