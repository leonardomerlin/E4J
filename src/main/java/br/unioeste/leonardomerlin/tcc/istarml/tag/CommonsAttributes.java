package br.unioeste.leonardomerlin.tcc.istarml.tag;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;

/**
 * This class represents the 'basicAtts' and 'extraAtt'.
 * 
 * Accessible only in this package.
 *
 * @author Leonardo Merlin
 */
class CommonsAttributes {

    protected String id;
    protected String name;
    @XmlAnyAttribute
    protected Map<QName, String> extraAtt = new HashMap<>();

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

    /**
     *
     * @param attributeName - Can not be 'id', 'name', 'author' or other class
     * attribute name.
     * @return the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public String getAttributeValue(String attributeName) {
        if ((attributeName.equals("id") || (attributeName.equals("name"))
                || attributeName.equals("author"))) {
            throw new IllegalArgumentException("Can not be 'id', 'name', 'author' or other class attribute name.");
        }
        return this.extraAtt.get(new QName(attributeName));
    }

    public void setAttribute(String name, String value) {
        this.extraAtt.put(new QName(name), value);
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
