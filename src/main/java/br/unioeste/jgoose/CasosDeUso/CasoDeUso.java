package br.unioeste.jgoose.CasosDeUso;

/**
 *
 * @author Diego Peliser
 */

public class CasoDeUso {
	private String ator; // nome do ator
	private String name; // nome do caso de uso
	private String type; // objetivo, objetivo-soft, tarefa ou recurso
	
	public CasoDeUso(){
		this.ator = " ";
		this.name = " ";
		this.type = " ";
	}
        
        public CasoDeUso(String ator, String name, String type){
		this.ator = ator;
		this.name = name;
		this.type = type;
	}
        
	/**
	 * @return Returns the tipo.
	 */
	public String getTipo() {
		return type;
	}
	/**
	 * @param tipo The tipo to set.
	 */
	public void setTipo(String tipo) {
		this.type = tipo;
	}
	/**
	 * @return Returns the ator.
	 */
	public String getAtor() {
		return ator;
	}
	/**
	 * @param ator The ator to set.
	 */
	public void setAtor(String ator) {
		this.ator = ator;
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
