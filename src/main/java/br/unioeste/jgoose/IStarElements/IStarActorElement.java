package br.unioeste.jgoose.IStarElements;

import java.util.ArrayList;

/**
 *
 * @author Diego Peliser
 */
/**
 * Utilizada para especificar o Actor i* (IStarActorElement)
 *
 * @param cod //código (Element_x)
 * @param name //nome do Elemento ("Ator 1")
 * @param children //filhos associados ao ATOR: SR ou ISA (códigos)
 * @param links //ligações (códigos)
 */
public class IStarActorElement {

    private String cod; //código (Element_x)
    private String name; //nome do Elemento ("Ator 1")
    private ArrayList children; //filhos associados ao ATOR: SR ou ISA (códigos)
    private ArrayList links; //ligações (códigos)

    public IStarActorElement() {
        super();
        this.children = new ArrayList();
        this.links = new ArrayList();
    }

    /**
     * @return Returns the children.
     */
    public ArrayList getChildren() {
        return children;
    }

    public String getChildren(int i) {
        return String.valueOf(children.get(i));
    }

    /**
     * @param children The children to set.
     */
    public void setChildren(String filho) {
        this.children.add(filho);
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
     * @return Retorna se o link passado existe na lista de links do ator.
     */
    public boolean containsLink(String link) {
        boolean result = false;

        for(int i = links.size()-1; i >=0 ; i--) {
            if (links.get(i).equals(link)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * @param links The links to set.
     */
    public void setLinks(String link) {
        this.links.add(link);
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
}
