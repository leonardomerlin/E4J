/*
 * ERelement.java
 * it is part of the ccistarml Java Package
 * version 0.6.1
 * Created on July 4 of 2007, By Carlos Cares
 * Updated to v0.6.1  on September 20 of 2007 By Carlos Cares
 */
package seg.jUCMNav.importexport.ccistarml;

import java.util.HashMap;
import java.util.Iterator;

/**
 * An object of this class represents an element of the iStarML file or a
 * relationship between two elements of the same file.
 *
 * @author Carlos Cares
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public final class ERelement {

    public String diagram;
    public String name;
    public String text;
    public String ID;
    public HashMap attribute = new HashMap<>();
    private static String lastID = "AA00";

    public ERelement() {
        this.diagram = "";
        this.name = "";
    }

    /**
     *
     * @param name
     * @param attributes
     * @param erElementList
     */
    public ERelement(String name, HashMap attributes, ERelementList erElementList) {
        this.diagram = erElementList.currentDiagram;
        this.name = name;
        this.set_attributes(attributes);
        this.set_ID(erElementList);
        erElementList.add(this);
    }

    public ERelement(String name, String text, ERelementList erElementList) {
        this.diagram = erElementList.currentDiagram;
        this.name = name;
        this.text = text;
        this.set_ID(erElementList);
        erElementList.add(this);
    }

    /**
     * System Output: Diagram - ID : name --> text | attribute
     *
     * @deprecated Use System.out.println(ERelement.this)
     */
    public void display() {
        String w;
        if (this.name.equals("string") || this.name.equals("graphicSVG")) {
            w = this.text;
        } else {
            w = this.attribute.toString();
        }
        System.out.println(this.diagram + "-" + this.ID + ":" + this.name + "-->" + w);
    }

    public void set_ID(ERelementList erL) {
        String w;
        w = (String) this.attribute.get("id");
        if (w != null) {
            this.ID = w;
            return;
        }
        if (this.name.equals("actor")) {
            w = (String) this.attribute.get("aref");
            if (w != null) {
                this.ID = w;
                return;
            }
        }
        if (this.name.equals("ielement")) {
            w = (String) this.attribute.get("iref");
            if (w != null) {
                this.ID = w;
                return;
            }
        }
        w = nextID();
        while (erL.containsRef(w)) {
            w = nextID();
        }
        this.ID = w;
    }

    public void set_attributes(HashMap attributes) {
        Iterator it = attributes.keySet().iterator();
        String key, val;
        while (it.hasNext()) {
            key = (String) it.next();
            val = (String) attributes.get(key);
            this.attribute.put(key, val);
        }
    }

    public String nextID() {
        char c[] = ERelement.lastID.toCharArray();
        if (c[3] != '9') {
            c[3]++;
        } else if (c[2] != '9') {
            c[3] = '0';
            c[2]++;
        } else if (c[1] != 'Z') {
            c[3] = c[2] = '0';
            c[1]++;
        } else {
            c[3] = c[2] = '0';
            c[1] = 'A';
            c[0]++;
        }
        ERelement.lastID = "" + c[0] + c[1] + c[2] + c[3];
        return ERelement.lastID;
    }

    /**
     *
     * @return Diagram - ID : name --> text | attribute
     */
    @Override
    public String toString() {
        String w;
        if (this.name.equals("string") || this.name.equals("graphicSVG")) {
            w = this.text;
        } else {
            w = this.attribute.toString();
        }
        return this.diagram + "-" + this.ID + ":" + this.name + "-->" + w;
    }
}
