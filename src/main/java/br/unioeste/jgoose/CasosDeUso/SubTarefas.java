package br.unioeste.jgoose.CasosDeUso;

import java.util.ArrayList;

public class SubTarefas {
	public String codTarefaMae;
	public String nomeTarefaMae;
	public ArrayList<String> codTarefaFilha;
	public ArrayList<String> nomeTarefaFilha;
	public ArrayList<String> tipoTarefaFilha;
	
	public SubTarefas(){
		this.codTarefaMae = "";
		this.nomeTarefaMae = "";
		this.codTarefaFilha  = new ArrayList<>();
		this.nomeTarefaFilha = new ArrayList<>();
		this.tipoTarefaFilha = new ArrayList<>();
	}
	
	
}
