package br.unioeste.jgoose.CasosDeUso;

import br.unioeste.jgoose.IStarElements.IStarActorElement;
import br.unioeste.jgoose.IStarElements.IStarElement;
import br.unioeste.jgoose.IStarsLinks.IStarLink;
import br.unioeste.jgoose.controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author Diego Peliser
 */
public class DiagramaCasosDeUso {

    private ArrayList<String> candidatosCasosdeUso = new ArrayList<>();
    private ArrayList<String> atoresExternos = new ArrayList<>();
    private int posActorSistema = -1;
    public ArrayList<CasoDeUso> casosDeUso;

    public DiagramaCasosDeUso() {
        this.casosDeUso = new ArrayList<>();
    }

    /*
     * Método Passo 1 - Descoberta de Atores
     * Diretrizes 1, 2, 3 e 4
     */
    public void mapeamentoPasso1() {

        ArrayList<IStarActorElement> actorsOME = (ArrayList) Controller.getOme().getActors().clone();

        /*
         * Diretrizes 1 e 2
         */
        for (int i = 0; i < actorsOME.size(); i++) {
            if ((actorsOME.get(i).getCod().equals(Controller.getatorSistema()))) {
                posActorSistema = i;
            } else {
                atoresExternos.add(actorsOME.get(i).getCod());
            }
        }
        /*
         * Diretriz 3
         */
        for (int i = 0; i < atoresExternos.size(); i++) {
            int posAtor = Controller.getOme().procuraActorCod(atoresExternos.get(i)); // pega a posição do ator externo ao sistema
            IStarActorElement ator = Controller.getOme().getActor(posAtor); // cria um ator com o código do ator externo ao sistema
            IStarActorElement atorSistema = Controller.getOme().getActor(posActorSistema); // cria um ator que representa o sistema
            boolean flag = false; // flag para testar se o ator tem dependência com o sistema
            IStarLink dependenciaFrom;
            IStarLink dependenciaTo;
            IStarLink dependencia2From;
            IStarLink dependencia2To;
            /*
             * Procura se os atores externos ao sistema possuem depêndencias com o sistema
             */
            for (int j = 0; j < Controller.getOme().getDependencies().size(); j++) {
                dependenciaFrom = (IStarLink) Controller.getOme().getDependencies().get(j);
                dependencia2To = (IStarLink) Controller.getOme().getDependencies().get(j);
                // Depêndencias com o Sistema
                if (dependenciaFrom.getFrom().equals(ator.getCod()) || dependencia2To.getTo().equals(ator.getCod())) { // verifica se a depência atual é do ator selecionado
                    for (int k = 0; k < Controller.getOme().getDependencies().size(); k++) {
                        dependenciaTo = (IStarLink) Controller.getOme().getDependencies().get(k);
                        dependencia2From = (IStarLink) Controller.getOme().getDependencies().get(k);
                        if ((dependenciaFrom.getTo().equals(dependenciaTo.getFrom()) && dependenciaTo.getTo().equals(atorSistema.getCod())) || (dependencia2To.getFrom().equals(dependencia2From.getTo()) && dependencia2From.getFrom().equals(atorSistema.getCod()))) { // Diretriz 3.1
                            flag = true;
                        }
                        if (flag) { // testa a flag ou seja, se o Ator possui uma dependência com o sistema
                            break;
                        }
                    }
                }
                if (flag) {  // testa a flag ou seja, se o Ator possui uma dependência com o sistema
                    break;
                }
            }
            //Se o ator possui depedência com o sistema, adiciona na lista de candidatos
            if (flag) {
                candidatosCasosdeUso.add(atoresExternos.get(i));
            }
        }
        // TESTE
        for (int i = 0; i < candidatosCasosdeUso.size(); i++) {
            System.out.println("candidato: " + candidatosCasosdeUso.get(i));
        }
        System.out.println(candidatosCasosdeUso.size());
        /*
         * Diretriz 4
         */
        // IMPLEMENTAR
    }

    /*
     * Método Passo 2 - Descoberta de Casos de Uso
     * Diretrizes 5 e 6
     */
    public void mapeamentoPasso2() {
        for (int i = 0; i < candidatosCasosdeUso.size(); i++) {
            int posAtor = Controller.getOme().procuraActorCod(candidatosCasosdeUso.get(i)); // pega a posição do ator externo ao sistema
            IStarActorElement ator = Controller.getOme().getActor(posAtor); // cria um ator com o código do ator candidato a caso de uso ao sistema
            IStarActorElement atorSistema = Controller.getOme().getActor(posActorSistema); // cria um ator que representa o sistema
            System.out.println("Nome Ator Candidato: " + ator.getName());
            System.out.println("Nome Ator Sistema: " + atorSistema.getName());
            System.out.println(Controller.getOme().getGoals().get(0).getName());
            System.out.println(Controller.getOme().getGoals().get(0).getCod());
            System.out.println(Controller.getOme().getGoals().get(0).getLinks().get(0));
            System.out.println(Controller.getOme().getGoals().get(0).getLinks().get(1));
            /*
             * Diretriz 5 e 6
             */
            // Procura Casos de Uso do tipo Objetivo
            for (int j = 0; j < Controller.getOme().getGoals().size(); j++) {
                IStarElement goal = Controller.getOme().getGoals().get(j);
                // ator -> dependum -> sistema computacional
                if ((ator.containsLink("" + goal.getLinks().get(0))) && (atorSistema.containsLink("" + goal.getLinks().get(1)))) {
                    System.out.println("Objetivo! link = " + goal.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), goal.getName(), "Objetivo"));
                }
                // sistema computaciona -> dependum -> ator
                if ((ator.containsLink("" + goal.getLinks().get(1))) && (atorSistema.containsLink("" + goal.getLinks().get(0)))) {
                    System.out.println("Objetivo! link = " + goal.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), goal.getName(), "Objetivo"));
                }
            }
            // Procura Casos de Uso do tipo Tarefa
            for (int j = 0; j < Controller.getOme().getTasks().size(); j++) {
                IStarElement task = Controller.getOme().getTasks().get(j);
                // ator -> dependum -> sistema computacional
                if ((ator.containsLink("" + task.getLinks().get(0))) && (atorSistema.containsLink("" + task.getLinks().get(1)))) {
                    System.out.println("Tarefa! link = " + task.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), task.getName(), "Tarefa"));
                }
                // sistema computaciona -> dependum -> ator
                if ((ator.containsLink("" + task.getLinks().get(1))) && (atorSistema.containsLink("" + task.getLinks().get(0)))) {
                    System.out.println("Tarefa! link = " + task.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), task.getName(), "Tarefa"));
                }
            }
            // Procura Casos de Uso do tipo Recurso
            for (int j = 0; j < Controller.getOme().getResources().size(); j++) {
                IStarElement resource = Controller.getOme().getResources().get(j);
                // ator -> dependum -> sistema computacional
                if ((ator.containsLink("" + resource.getLinks().get(0))) && (atorSistema.containsLink("" + resource.getLinks().get(1)))) {
                    System.out.println("Recurso! link = " + resource.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), resource.getName(), "Recurso"));
                }
                // sistema computaciona -> dependum -> ator
                if ((ator.containsLink("" + resource.getLinks().get(1))) && (atorSistema.containsLink("" + resource.getLinks().get(0)))) {
                    System.out.println("Recurso! link = " + resource.getLinks().get(0));
                    casosDeUso.add(new CasoDeUso(ator.getName(), resource.getName(), "Recurso"));
                }
            }
            System.out.println(Controller.getOme().getGoals().get(0).getCod());
            System.out.println(Controller.getOme().getGoals().get(0).getName());
            System.out.println(Controller.getOme().getGoals().get(0).getLinks().get(0));
            System.out.println(Controller.getOme().getGoals().get(0).getLinks().get(1));
            if (i == 2) {
                System.out.println("LINKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKS");
                for (int j = 0; j < ator.getLinks().size(); j++) {
                    // System.out.println(ator.getLinks().get(j));
                    //System.out.println(atorSistema.getLinks().get(j));
                }
            }
        }
    }
}