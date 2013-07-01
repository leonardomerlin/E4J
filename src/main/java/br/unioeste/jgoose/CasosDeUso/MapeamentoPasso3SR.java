package br.unioeste.jgoose.CasosDeUso;

import br.unioeste.jgoose.IStarElements.IStarElement;
import br.unioeste.jgoose.IStarsLinks.IStarLink;
import br.unioeste.jgoose.model.TokensOpenOME;
import java.util.ArrayList;

public class MapeamentoPasso3SR {
	public String nomeCasodeUso;
	public String codCasodeUso;
	//elemento children do Sistema ligado a algum Use Case já mapeado
	public String nomeElementoChildren;
	public String codElementoChildren;
	public ArrayList <String> Passos = new ArrayList<>();
	public ArrayList <String> PassosTipo = new ArrayList<>();
	public String codAtor;
	public String nomeAtor;
	private TokensOpenOME ome = new TokensOpenOME();
	private ArrayList <MapeamentoPasso3SR> mapeamentos3 = new ArrayList<>();
	private ArrayList <SubTarefas> subTarefas = new ArrayList<>();
	
	public MapeamentoPasso3SR(){
		this.nomeCasodeUso = "";
		this.codCasodeUso = "";
		this.nomeElementoChildren = "";
		this.codElementoChildren = "";
		this.Passos = new ArrayList<>();
	}
	
	
	public void mapearSubTarefas(ArrayList <MapeamentoPasso3SR> mapeamentos3,TokensOpenOME tkOME){
		this.ome = tkOME;
		this.mapeamentos3 = mapeamentos3;
		ArrayList<IStarLink> decompositions = tkOME.getDecompositions();
		int tipoElemento_pos[] = new int[2];
		
		for (int i=0;i<decompositions.size();i++){
			IStarLink decomposition = decompositions.get(i);
			SubTarefas subtarefa = new SubTarefas();
			//Seta os atributos da Tarefa Mae (codigo e nome)
			subtarefa.codTarefaMae = decomposition.getTo();
			tipoElemento_pos = procuraElementoCod(decomposition.getTo());
			switch (tipoElemento_pos[0])
			{
					case 1:{ //IStarGoalElement goal
						IStarElement goal = ome.getElement(1,tipoElemento_pos[1]);
						subtarefa.nomeTarefaMae = goal.getName();
					}break;
					case 2: { //IStarTaskElement task 
						IStarElement task = ome.getElement(2,tipoElemento_pos[1]);
						subtarefa.nomeTarefaMae = task.getName(); 
						
					}break;
					case 3: { //IStarSoftGoalElement softgoal 
						IStarElement softgoal = ome.getElement(3,tipoElemento_pos[1]);
						subtarefa.nomeTarefaMae = softgoal.getName(); 
					}break;
					case 4: { //IStarResourceElement resource
						IStarElement resource = ome.getElement(4,tipoElemento_pos[1]);
						subtarefa.nomeTarefaMae = resource.getName(); 
					}break;
					default:{
					}break;
			}
			//fim Setar os atributos da Tarefa Mae (codigo e nome)
			
			//seta a subtarefa da Tarefa Mae (codigo,nome e tipo)
			int posDecomposition[] = new int[2];
			if (subTarefas.size()!=0){ //se já foram armazenadas nenhumas Tarefas Maes no vetor de Subtarefas
				posDecomposition = procuraDecompositionsMae(subtarefa.codTarefaMae,subTarefas);
				if (posDecomposition[0]==1){ //Tarefa M�e j� existente
					subtarefa.codTarefaFilha = (ArrayList<String>) subTarefas.get(posDecomposition[1]).codTarefaFilha.clone();
					subtarefa.nomeTarefaFilha = (ArrayList<String>) subTarefas.get(posDecomposition[1]).nomeTarefaFilha.clone();
					subtarefa.tipoTarefaFilha = (ArrayList<String>) subTarefas.get(posDecomposition[1]).tipoTarefaFilha.clone();
					
					subtarefa.codTarefaFilha.add(decomposition.getFrom());
					tipoElemento_pos = procuraElementoCod(decomposition.getFrom());
					switch (tipoElemento_pos[0])
					{
							case 1:{ //IStarGoalElement goal
								IStarElement goal = ome.getElement(1,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(goal.getName());
								subtarefa.tipoTarefaFilha.add("Objetivo");
							}break;
							case 2: { //IStarTaskElement task 
								IStarElement task = ome.getElement(2,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(task.getName()); 
								subtarefa.tipoTarefaFilha.add("Tarefa");
								
							}break;
							case 3: { //IStarSoftGoalElement softgoal 
								IStarElement softgoal = ome.getElement(3,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(softgoal.getName());
								subtarefa.tipoTarefaFilha.add("ObjetivoSoft");
							}break;
							case 4: { //IStarResourceElement resource
								IStarElement resource = ome.getElement(4,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(resource.getName());
								subtarefa.tipoTarefaFilha.add("Recurso");
							}break;
							default:{
							}break;
					}
					subTarefas.set(posDecomposition[1],subtarefa);
				}
				else{//Nova Tarefa Mãe
					subtarefa.codTarefaFilha.add(decomposition.getTo());
					tipoElemento_pos = procuraElementoCod(decomposition.getFrom());
					switch (tipoElemento_pos[0])
					{
							case 1:{ //IStarGoalElement goal
								IStarElement goal = ome.getElement(1,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(goal.getName());
								subtarefa.tipoTarefaFilha.add("Objetivo");
							}break;
							case 2: { //IStarTaskElement task 
								IStarElement task = ome.getElement(2,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(task.getName()); 
								subtarefa.tipoTarefaFilha.add("Tarefa");
								
							}break;
							case 3: { //IStarSoftGoalElement softgoal 
								IStarElement softgoal = ome.getElement(3,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(softgoal.getName());
								subtarefa.tipoTarefaFilha.add("ObjetivoSoft");
							}break;
							case 4: { //IStarResourceElement resource
								IStarElement resource = ome.getElement(4,tipoElemento_pos[1]);
								subtarefa.nomeTarefaFilha.add(resource.getName());
								subtarefa.tipoTarefaFilha.add("Recurso");
							}break;
							default:{
							}break;
					}
					subTarefas.add(subtarefa);
				}
			}
				
			else{ //se não foram armazenada nenhuma Tarefa Mae no vetor de Subtarefas
				subtarefa.codTarefaFilha.add(decomposition.getTo());
				tipoElemento_pos = procuraElementoCod(decomposition.getFrom());
				switch (tipoElemento_pos[0])
				{
						case 1:{ //IStarGoalElement goal
							IStarElement goal = ome.getElement(1,tipoElemento_pos[1]);
							subtarefa.nomeTarefaFilha.add(goal.getName());
							subtarefa.tipoTarefaFilha.add("Objetivo");
						}break;
						case 2: { //IStarTaskElement task 
							IStarElement task = ome.getElement(2,tipoElemento_pos[1]);
							subtarefa.nomeTarefaFilha.add(task.getName()); 
							subtarefa.tipoTarefaFilha.add("Tarefa");
							
						}break;
						case 3: { //IStarSoftGoalElement softgoal 
							IStarElement softgoal = ome.getElement(3,tipoElemento_pos[1]);
							subtarefa.nomeTarefaFilha.add(softgoal.getName());
							subtarefa.tipoTarefaFilha.add("ObjetivoSoft");
						}break;
						case 4: { //IStarResourceElement resource
							IStarElement resource = ome.getElement(4,tipoElemento_pos[1]);
							subtarefa.nomeTarefaFilha.add(resource.getName());
							subtarefa.tipoTarefaFilha.add("Recurso");
						}break;
						default:{
						}break;
				}
				subTarefas.add(subtarefa);
			}
			
		}
		System.out.println("Mapeado Subtasks");
		
	}
	
	public ArrayList<MapeamentoPasso3SR> gerarFluxoPrincipal(){
		int posElementoMapeamento3[] = new int[2];
		int posElementoMeioFim[] = new int[2];
		int posElementoDecomposicaoTarefas[] = new int[2];
		ArrayList<MapeamentoPasso3SR> mapeamentos3FINAL = (ArrayList<MapeamentoPasso3SR>) this.mapeamentos3.clone();
		for (int i=0;i<subTarefas.size();i++){
			SubTarefas subtarefa = subTarefas.get(i);
			posElementoMapeamento3 = procuraCodElementoChildren(subtarefa.codTarefaMae);
			if (posElementoMapeamento3[0]!=0){ //encontrou Pai já Mapeado pelo Mapeamento3
				MapeamentoPasso3SR mapeamento = mapeamentos3FINAL.get(posElementoMapeamento3[1]);
				for (int j=0;j<subtarefa.nomeTarefaFilha.size();j++){
					mapeamento.Passos.add(subtarefa.nomeTarefaFilha.get(j));
					mapeamento.PassosTipo.add(subtarefa.tipoTarefaFilha.get(j));
				}					
				mapeamentos3FINAL.set(posElementoMapeamento3[1],mapeamento);
			}
			else if (posElementoMapeamento3[0]==0){
					posElementoMeioFim = encontrarRelacaoMeioFim(subtarefa.codTarefaMae);
						
					if (posElementoMeioFim[0]!=0){ //encontrou Pai em Ligação Meio Fim já Mapeado pelo Mapeamento 3
						IStarLink meanEnd = ome.getMeansEnds().get(posElementoMeioFim[1]);
						int posElem[] = procuraCodElementoChildren(meanEnd.getTo());
						if (posElem[0]!=0){
							MapeamentoPasso3SR mapeamento = mapeamentos3FINAL.get(posElem[1]);
							for (int j=0;j<subtarefa.nomeTarefaFilha.size();j++){
								mapeamento.Passos.add(subtarefa.nomeTarefaFilha.get(j));
								mapeamento.PassosTipo.add(subtarefa.tipoTarefaFilha.get(j));
							}					
							mapeamentos3FINAL.set(posElem[1],mapeamento);
						}
					}
					else {
						posElementoDecomposicaoTarefas = encontraDecomposicaoTarefas(subtarefa.codTarefaMae);
						if (posElementoDecomposicaoTarefas[0]!=0){//encontrou Pai em Decomposi��o de Tarefas j� Mapeado pelo Mapeamento 3
							IStarLink decomposition = ome.getDecompositions().get(posElementoDecomposicaoTarefas[1]);
							int posElem[] = procuraCodElementoChildren(decomposition.getTo());
							if (posElem[0]!=0){
								MapeamentoPasso3SR mapeamento = mapeamentos3FINAL.get(posElem[1]);
								for (int j=0;j<subtarefa.nomeTarefaFilha.size();j++){
									mapeamento.Passos.add(subtarefa.nomeTarefaFilha.get(j));
									mapeamento.PassosTipo.add(subtarefa.tipoTarefaFilha.get(j));
								}					
								mapeamentos3FINAL.set(posElem[1],mapeamento);
							}
						}
					}
				}
			
		}
		return mapeamentos3FINAL;
	}
	
	public int[] procuraCodElementoChildren(String codTarefaMae){
		int tipoElemento_pos[] = {0,0};
		boolean encontrouTarefaMae = false;
		int i=1;
		//retorna posi��o da Tarefa Mae na ArrayList
		while ((!encontrouTarefaMae)&&(i<mapeamentos3.size())){
				String mapeamento3CodElemento = mapeamentos3.get(i).codElementoChildren;
				if (mapeamento3CodElemento.equals(codTarefaMae)){
					encontrouTarefaMae = true;
					tipoElemento_pos[0]= 1;
					tipoElemento_pos[1]= i;
				}
				i++;
		}
		return tipoElemento_pos;
	}
	
	public int[]encontrarRelacaoMeioFim(String codTarefaMae){
		int MeioFim_pos[] = {0,0};
		boolean encontrouRelacaoMeioFim = false;
		ArrayList <IStarLink>MeansEnds = ome.getMeansEnds();
		int i=0;
		while ((!encontrouRelacaoMeioFim)&&(i<MeansEnds.size())){
			IStarLink meanEnd = MeansEnds.get(i);
			if (meanEnd.getFrom().equals(codTarefaMae)){
				encontrouRelacaoMeioFim = true;
				MeioFim_pos[0]= 1;
				MeioFim_pos[1]= i;
			}
			i++;
		}
		return MeioFim_pos;
	}
	
	public int[]encontraDecomposicaoTarefas(String codTarefaMae){
		int DecompTarefas_pos[] = {0,0};
		boolean encontrouRelacaoDecomposicaoTarefas = false;
		ArrayList <IStarLink>tasks = ome.getDecompositions();
		int i=0;
		while ((!encontrouRelacaoDecomposicaoTarefas)&&(i<tasks.size())){
			IStarLink task = tasks.get(i);
			if (task.getFrom().equals(codTarefaMae)){
				encontrouRelacaoDecomposicaoTarefas = true;
				DecompTarefas_pos[0]= 1;
				DecompTarefas_pos[1]= i;
			}
			i++;
		}
		return DecompTarefas_pos;
	}
	
	
	/**
	 * Procura o C�digo do Elemento (Dependum)
	 * @param codDependum codigo do Dependum
	 * @return tipoElemento_pos [0] - tipo do elemento [1] - posi��o do elemento
	 */
	public int[] procuraElementoCod(String codDependum){
		int tipoElemento_pos[] = new int[2];
		boolean encontrou = false;
		int i=1,posElementoCod;
		while (!(encontrou)){
			//retorna posi��o do Elemento na ArrayList correspondente
			posElementoCod = ome.procuraElementoCod(i,codDependum); 
			if (posElementoCod!=-1){
				tipoElemento_pos[0]= i; //1 - Objetivo, 2 - Tarefa, 3 - ObjetivoSoft, 4 - Recurso
				tipoElemento_pos[1]= posElementoCod;
				encontrou = true;
			}	
			i++;
		}
		return tipoElemento_pos;
	}
	
	
	public int[] procuraDecompositionsMae(String codsubTarefaMAE,ArrayList <SubTarefas> subTarefas ){
		int procura[] = {0,0};
		SubTarefas subTarefa = new SubTarefas();
		int i=0; boolean encontrou = false;
		//se o vetor de atores mapeados nao for igual a zero procure se ele j� est� armazenado
		while ((encontrou == false)&&(i<subTarefas.size())){
			subTarefa = subTarefas.get(i);
			if (subTarefa.codTarefaMae.equals(codsubTarefaMAE)){
					procura[0]=1; //achou
					procura[1]=i; //posi��o
					encontrou = true;
			}
			i++;
		}
		return procura;
	}
	
	
}
