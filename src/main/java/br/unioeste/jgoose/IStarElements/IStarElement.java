package br.unioeste.jgoose.IStarElements;

import java.util.ArrayList;

/**
 *
 * @author Diego Peliser
 */
/**
 * Utilizada para especificar o Elementos i* (IStarGoalElement,
 * IStarTaskElement, IStarSoftGoalElement, IStarResourceElement)
 *
 * @param cod //código (Element_x)
 * @param name //nome do Elemento ("Elemento 1")
 * @param parents //pais associados ao Elemento (ATORES SR) - códigos
 * @param links //ligações (códigos)
 */
public class IStarElement {

    private String cod; //código (Element_x)
    private String name; //nome do Elemento ("Efetuar Pagamento")
    private ArrayList parents; //pais associados ao Elemento - ATORES SR (códigos)
    private ArrayList links; //ligações (códigos)

    public IStarElement() {
        super();
        this.links = new ArrayList();
        this.parents = new ArrayList();
    }

    /**
     * @return Returns the cod.
     */
    public String getCod() {
        return cod;
    }

    /**
     * @param cod The cod to set.
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * @return Returns the links.
     */
    public ArrayList getLinks() {
        return links;
    }
    
    /**
     * @param links The links to set.
     */
    public void setLinks(String links) {
        this.links.add(links);
    }

    /**
     * @param Seta os links, informando o tipo de ligação, se ela é "FROM" ou
     * "TO" 0 - dependência, 1 - Decomposição de Tarefas, 2 - Meio-FIM, 3 - ISA,
     * -1 - Outras
     */
    public void setLinks(int tipo, String link) {
        this.links.add(tipo + " " + link);
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the parent.
     */
    public ArrayList getParent() {
        return parents;
    }

    /**
     * @param parent The parent to set.
     */
    public void setParent(String parent) {
        this.parents.add(parent);
    }
}
