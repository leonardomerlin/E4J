package br.unioeste.jgoose.CasosDeUso;


import java.util.ArrayList;

/**
 *
 * @author Diego Peliser
 */

public class Actor {
	private String cod;
	private String name;
	private ArrayList <String>codChildren; //filhos associados ao ATOR: ISA (códigos)
	private ArrayList <String>nomeChildren; //filhos associados ao ATOR: ISA (nome)
	private ArrayList <Link>links;
	private ArrayList <CasoDeUso>useCases;
	
	public Actor(){
		this.cod = null;
		this.name = null;
		this.codChildren = new ArrayList<String>(); //filhos associados ao ATOR: ISA (códigos)
		this.nomeChildren = new ArrayList<String>();
		this.links = new ArrayList<Link>();
		this.useCases = new ArrayList<CasoDeUso>();
	}
	
	/**
	 * @return Returns the children.
	 */
	public ArrayList getcodChildren() {
		return codChildren;
	}
	
	public String getcodChildren(int i) {
		String cod = (String)this.codChildren.get(i);
		return cod;
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setcodChildren(ArrayList<String> codChildren) {
		this.codChildren = codChildren;
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setcodChildren(String codChildren) {
		this.codChildren.add(codChildren);
	}
	
	/**
	 * @return Returns the nomeChildren.
	 */
	public ArrayList<String> getNomeChildren() {
		return nomeChildren;
	}
	
	public String getNomeChildren(int i) {
		String nome = (String)this.nomeChildren.get(i);
		return nome;
	}

	/**
	 * @param nomeChildren The nomeChildren to set.
	 */
	public void setNomeChildren(ArrayList<String> nomeChildren) {
		this.nomeChildren = nomeChildren;
	}
	
	/**
	 * @param nomeChildren The nomeChildren to set.
	 */
	public void setNomeChildren(String nomeChildren) {
		this.nomeChildren.add(nomeChildren);
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
	 * @return Returns the links.
	 */
	public ArrayList<Link> getLinks() {
		return links;
	}
	/**
	 * @param links The links to set.
	 */
	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}
	/**
	 * @return Returns the useCases.
	 */
	public ArrayList<CasoDeUso> getUseCases() {
		return useCases;
	}
	
	public CasoDeUso getUseCases(int i) {
		CasoDeUso caso = useCases.get(i);
		return caso;
	}
	/**
	 * @param useCases The useCases to set.
	 */
	public void setUseCases(ArrayList<CasoDeUso> useCases) {
		this.useCases = useCases;
	}
	
	public void setUseCases(CasoDeUso caso) {
		this.useCases.add(caso);
	}

}
