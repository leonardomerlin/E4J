package br.unioeste.jgoose.CasosDeUso;

/**
 *
 * @author Diego Peliser
 */

public class Link {
	private String cod;  //código (Link_x)
	private String name; //nome do Elemento ("Link 1")
	private String type; //tipo de link (associação ou link)
	private String from; //de (códigos)
	private String to;  //para (códigos)
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
	 * @return Returns the from.
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from The from to set.
	 */
	public void setFrom(String from) {
		this.from = from;
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
	 * @return Returns the to.
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to The to to set.
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}
}
