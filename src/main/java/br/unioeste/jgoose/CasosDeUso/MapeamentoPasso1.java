package br.unioeste.jgoose.CasosDeUso;

public class MapeamentoPasso1 {
	public String fromLink; //codigo from link Ex.:Link_0
	public String toLink; //codigo to link Ex.: Link_1
	public String dependumCod; //codigo do dependum
	public String dependumName; //nome do dependum
	public String dependumTipo; //tipo do dependum
	public String fromToSistema; //DE ou PARA o Sistema
	public String atorCod; //codigo do ator
	public String atorName; //nome do ator
	public boolean sistema; //relação com o sistema
	/*nome do Elemento 
	(ligação SR Ator >> Dependum >> Elemento Children)
	ou (Elemento >> Dependum >> Ator)*/
	public String nomeElemento; 
	public String codElemento; //codigo do Elemento
		
	public MapeamentoPasso1() {
		this.fromLink = " ";
		this.toLink = " ";
		this.dependumCod = " ";
		this.dependumName = " ";
		this.dependumTipo = " ";
		this.fromToSistema = " ";
		this.atorCod = " ";
		this.atorName = " ";
		this.sistema = false;
		this.nomeElemento = " ";
		this.codElemento = " ";
	}
}
