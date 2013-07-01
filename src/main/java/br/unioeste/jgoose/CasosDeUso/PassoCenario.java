package br.unioeste.jgoose.CasosDeUso;

import java.util.ArrayList;

public class PassoCenario {
	public String passo;
	public String codPasso;
	private ArrayList <String> inclusoes; 
	private ArrayList <String> extensoes; 
	
	public PassoCenario(){
		this.passo     = "";
		this.inclusoes = new ArrayList <>();
		this.extensoes = new ArrayList <>();
		this.codPasso = "";
	}
	
	public void addInclusoes(String inclusao){
		this.inclusoes.add(inclusao);
	}
	
	public void addExtensoes(String extensao){
		this.extensoes.add(extensao);
	}
}
