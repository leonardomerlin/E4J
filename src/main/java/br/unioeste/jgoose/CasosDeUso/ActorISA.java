package br.unioeste.jgoose.CasosDeUso;

import java.util.ArrayList;

/**
 *
 * @author Diego Peliser
 */

public class ActorISA extends Actor {
	private ArrayList <String> codFather;
	private ArrayList <String> nomeFather;

	public ActorISA() {
		this.codFather = new ArrayList<>();
		this.nomeFather = new ArrayList<>();
	}
	
	/**
	 * @return Returns the children.
	 */
	public ArrayList getcodFather() {
		return codFather;
	}
	
	public String getcodFather(int i) {
		String codFather = (String)this.codFather.get(i);
		return codFather;
	}
	
	/**
	 * @return Returns the children.
	 */
	public ArrayList getnomeFather() {
		return nomeFather;
	}
	
	public String getnomeFather(int i) {
		String nomeFather = (String)this.nomeFather.get(i);
		return nomeFather;
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setcodFather(ArrayList<String> codFather) {
		this.codFather = codFather;
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setcodFather(String codFather) {
		this.codFather.add(codFather);
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setnomeFather(ArrayList<String> nomeFather) {
		this.nomeFather = nomeFather;
	}
	
	/**
	 * @param children The children to set.
	 */
	public void setnomeFather(String nomeFather) {
		this.nomeFather.add(nomeFather);
	}
	

}
