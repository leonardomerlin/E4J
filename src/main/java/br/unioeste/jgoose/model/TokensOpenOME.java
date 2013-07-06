package br.unioeste.jgoose.model;

import br.unioeste.jgoose.IStarElements.IStarActorElement;
import br.unioeste.jgoose.IStarElements.IStarAgentElement;
import br.unioeste.jgoose.IStarElements.IStarElement;
import br.unioeste.jgoose.IStarElements.IStarGoalElement;
import br.unioeste.jgoose.IStarElements.IStarPositionElement;
import br.unioeste.jgoose.IStarElements.IStarResourceElement;
import br.unioeste.jgoose.IStarElements.IStarRoleElement;
import br.unioeste.jgoose.IStarElements.IStarSoftGoalElement;
import br.unioeste.jgoose.IStarElements.IStarTaskElement;
import br.unioeste.jgoose.IStarsLinks.IStarContributionLink;
import br.unioeste.jgoose.IStarsLinks.IStarCoversLink;
import br.unioeste.jgoose.IStarsLinks.IStarDecompositionLink;
import br.unioeste.jgoose.IStarsLinks.IStarDependencyLink;
import br.unioeste.jgoose.IStarsLinks.IStarINSLink;
import br.unioeste.jgoose.IStarsLinks.IStarISALink;
import br.unioeste.jgoose.IStarsLinks.IStarIsPartOfLink;
import br.unioeste.jgoose.IStarsLinks.IStarLink;
import br.unioeste.jgoose.IStarsLinks.IStarMeansEndsLink;
import br.unioeste.jgoose.IStarsLinks.IStarOccupiesLink;
import br.unioeste.jgoose.IStarsLinks.IStarPlaysLink;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe Responsável por leitura do Arquivo Telos e armazenamento dos dados
 * (Elementos e Links) em uma Estrutura de Dados especificado pelas classes
 * IStar.
 *
 * @author Diego Peliser
 * @author Blade
 */
public class TokensOpenOME {

    //Estrutura de Dados que armazena os Elementos e Ligações
    private ArrayList<IStarActorElement> actors;
    private ArrayList<IStarAgentElement> agents;
    private ArrayList<IStarPositionElement> positions;
    private ArrayList<IStarRoleElement> roles;
    private ArrayList<IStarElement> goals, softgoals, tasks, resources; //OMEElements
    private ArrayList<IStarLink> dependencies, meansEnds, decompositions, isas;
    private ArrayList<IStarLink> inss, contributions, ispartofs, coverss, occupiess, playss; //OMELinks
    private String dirEntrada;
    Arquivo arquivoEntrada;

    /**
     * Construtor, instancia as ArrayLists de: - OMEElements:
     * actors,goals,softgoals,tasks,resources - OMELinks:
     * dependencies,meansEnds,decompositions,isas
     */
    public TokensOpenOME() {
        this.actors = new ArrayList();
        this.agents = new ArrayList();
        this.positions = new ArrayList();
        this.roles = new ArrayList();
        this.goals = new ArrayList();
        this.softgoals = new ArrayList();
        this.tasks = new ArrayList();
        this.resources = new ArrayList();
        this.dependencies = new ArrayList();
        this.meansEnds = new ArrayList();
        this.decompositions = new ArrayList();
        this.isas = new ArrayList();
        this.inss = new ArrayList();
        this.contributions = new ArrayList();
        this.ispartofs = new ArrayList();
        this.coverss = new ArrayList();
        this.occupiess = new ArrayList();
        this.playss = new ArrayList();
    }

    /**
     * Método utilizado para abrir um arquivo de Entrada Telos Associa o
     * atributo arquivoEntrada ao construtor de Arquivo.
     */
    public void abrirArquivo() {
        arquivoEntrada = new Arquivo();
        dirEntrada = arquivoEntrada.getdirEntrada();
    }

    /**
     * Added to start and read telos without swing or gui.
     *
     * @author Leonardo Merlin
     * @param inputfile
     * @param output
     */
    public void abrirArquivo(File inputfile, File output) {
        arquivoEntrada = new Arquivo(inputfile, output);
        dirEntrada = arquivoEntrada.getdirEntrada();
    }

    /**
     * Procura dentro do Arquivo Telos e armazena em uma estrutura de dados os
     * Elementos e Links
     */
    public void procuraArquivo() {
        String linha = arquivoEntrada.getLine();
        String codigo = null;
        ElementType elementType = null;
        while (linha != null) {
            // <editor-fold defaultstate="collapsed" desc="Read all the elements (and links)">
            if (verificaToken(linha)) {
                codigo = armazenaCodigo(linha);
                linha = arquivoEntrada.getLine(); // IN OMEElement, OMEElementClass ou IN OMELink, OMELinkClass,
                elementType = verificaElementoLink(linha); //valor entre 0 e 17
                switch (elementType) {
                    case ACTOR:
                        IStarActorElement act = new IStarActorElement(); //cria um Actor i*
                        act = criarAtor(act, codigo, linha);
                        actors.add(act);
                        break;
                    case GOAL:
                        IStarGoalElement goal = new IStarGoalElement(); //cria um Objetivo i*
                        goal = (IStarGoalElement) criarElemento(goal, codigo, linha);
                        goals.add(goal);
                        break;
                    case TASK:
                        IStarTaskElement task = new IStarTaskElement(); //cria uma Tarefa i*
                        task = (IStarTaskElement) criarElemento(task, codigo, linha);
                        tasks.add(task);
                        break;
                    case SOFTGOAL:
                        IStarSoftGoalElement softgoal = new IStarSoftGoalElement(); //cria um Objetivo Soft i*
                        softgoal = (IStarSoftGoalElement) criarElemento(softgoal, codigo, linha);
                        softgoals.add(softgoal);
                        break;
                    case RESOURCE:
                        IStarResourceElement resource = new IStarResourceElement(); //cria um Recurso i*
                        resource = (IStarResourceElement) criarElemento(resource, codigo, linha);
                        resources.add(resource);
                        break;
                    case DEPENDENCY:
                        IStarDependencyLink dependency = new IStarDependencyLink();// cria uma Ligação de Dependência
                        dependency = (IStarDependencyLink) criarLink(dependency, codigo, linha);
                        dependencies.add(dependency);
                        break;
                    case DECOMPOSITION:
                        // cria uma Ligação de Decomposição de Tarefas
                        IStarDecompositionLink decomposition = new IStarDecompositionLink();
                        decomposition = (IStarDecompositionLink) criarLink(decomposition, codigo, linha);
                        decompositions.add(decomposition);
                        break;
                    case MEANSEND:
                        // cria uma Ligação de Meio-Fim
                        IStarMeansEndsLink meanEnd = new IStarMeansEndsLink();
                        meanEnd = (IStarMeansEndsLink) criarLink(meanEnd, codigo, linha);
                        meansEnds.add(meanEnd);
                        break;
                    case ISA:
                        // cria uma Ligação ISA
                        IStarISALink isa = new IStarISALink(); //cria uma Ligação de Dependência
                        isa = (IStarISALink) criarLink(isa, codigo, linha);
                        isas.add(isa);
                        break;
                    case INS:
                        // cria uma Ligação INS
                        IStarINSLink ins = new IStarINSLink(); //cria uma Ligação de Dependência
                        ins = (IStarINSLink) criarLink(ins, codigo, linha);
                        inss.add(ins);
                        break;
                    case ISPARTOF:
                        // cria uma Ligação Is-Part-Of
                        IStarIsPartOfLink ispartof = new IStarIsPartOfLink(); //cria uma Ligação de Dependência
                        ispartof = (IStarIsPartOfLink) criarLink(ispartof, codigo, linha);
                        ispartofs.add(ispartof);
                        break;
                    case OCCUPIES:
                        // cria uma Ligação Occupies
                        IStarOccupiesLink occupies = new IStarOccupiesLink(); //cria uma Ligação de Dependência
                        occupies = (IStarOccupiesLink) criarLink(occupies, codigo, linha);
                        occupiess.add(occupies);
                        break;
                    case PLAYS:
                        // cria uma Ligação Plays
                        IStarPlaysLink plays = new IStarPlaysLink(); //cria uma Ligação de Dependência
                        plays = (IStarPlaysLink) criarLink(plays, codigo, linha);
                        playss.add(plays);
                        break;
                    case COVERS:
                        // cria uma Ligação Covers
                        IStarCoversLink covers = new IStarCoversLink(); //cria uma Ligação de Dependência
                        covers = (IStarCoversLink) criarLink(covers, codigo, linha);
                        coverss.add(covers);
                        break;
                    case AGENT:
                        IStarAgentElement agent = new IStarAgentElement(); //cria um Agent i*
                        agent = (IStarAgentElement) criarAtor(agent, codigo, linha);
                        agents.add(agent);
                        break;
                    case ROLE:
                        IStarRoleElement role = new IStarRoleElement(); //cria um Role i*
                        role = (IStarRoleElement) criarAtor(role, codigo, linha);
                        roles.add(role);
                        break;
                    case POSITION:
                        IStarPositionElement position = new IStarPositionElement(); //cria um Position i*
                        position = (IStarPositionElement) criarAtor(position, codigo, linha);
                        positions.add(position);
                        break;
                    case CONTRIBUTION:
                        // cria uma Ligação Contribution
                        IStarContributionLink contribution = new IStarContributionLink();
                        contribution = (IStarContributionLink) criarLink(contribution, codigo, linha);
                        contributions.add(contribution);
                        break;
                    default:
                        while (!(linha.equals("END"))) {//lê atributos até encontrar o token END
                            linha = arquivoEntrada.getLine();
                        }
                        break;
                }
            }
            //</editor-fold>
            linha = arquivoEntrada.getLine();
        }

        //update references of links
        //and 'connect' elements.
        criarLinkElementos();
    }

    /**
     * Verifica se é um Token Elemento ou Token Ligação
     *
     * @param linha
     * @return Retorna T/F se é Elemento ou Ligação
     */
    private boolean verificaToken(String linha) {
        return (linha.indexOf("Token Element_") != -1) || (linha.indexOf("Token Link") != -1);
    }

    private String armazenaCodigo(String linha) {
        StringTokenizer tokens = new StringTokenizer(linha);
        tokens.nextToken();
        return tokens.nextToken();
    }

    /**
     * Verifica qual tipo de elemento ou link é o token atual.
     *
     * @param linha
     * @return tipo do elemento
     */
    private ElementType verificaElementoLink(String linha) {
        StringTokenizer tokens = new StringTokenizer(linha, ", ");
        String ele_link = null; //ActorElement....
        String token;
        int posIStar;
        while (tokens.hasMoreTokens()) {
            token = tokens.nextToken();
            posIStar = token.indexOf("IStar");
            if (posIStar != -1) {
                ele_link = token.substring(posIStar + 5, token.length());
            }
        }

        // SUGGEST: maybe change this to Propertie mapping structure?!.
        // <editor-fold desc="switch element types">
        switch (ele_link) {
            case "ActorElement":
                return ElementType.ACTOR;
            case "AgentElement":
                return ElementType.AGENT;
            case "RoleElement":
                return ElementType.ROLE;
            case "PositionElement":
                return ElementType.POSITION;
            //
            case "GoalElement":
                return ElementType.GOAL;
            case "TaskElement":
                return ElementType.TASK;
            case "SoftGoalElement":
                return ElementType.SOFTGOAL;
            case "ResourceElement":
                return ElementType.RESOURCE;
            //
            case "DependencyLink":
                return ElementType.DEPENDENCY;
            case "DecompositionLink":
                return ElementType.DECOMPOSITION;
            case "Contribution":
                return ElementType.CONTRIBUTION;
            case "MeansEndsLink":
                return ElementType.MEANSEND;
            //
            case "ISALink":
                return ElementType.ISA;
            case "INSLink":
                return ElementType.INS;
            case "PartsLink":
                return ElementType.ISPARTOF;
            case "OccupiesLink":
                return ElementType.OCCUPIES;
            case "PlaysLink":
                return ElementType.PLAYS;
            case "CoversLink":
                return ElementType.COVERS;
            default:
                //error: don't reconized?
                break;
        }
        //</editor-fold>
        return null;
    }

    private enum ElementType {

        ACTOR, AGENT, ROLE, POSITION,
        GOAL, TASK, SOFTGOAL, RESOURCE,
        //
        DEPENDENCY, CONTRIBUTION, DECOMPOSITION, MEANSEND,
        //
        ISA, INS, OCCUPIES, PLAYS, COVERS, ISPARTOF
    }

    /**
     * Armazena atributos de Elementos ou Links (name, from, to, children,
     * parent)
     *
     * @param linha linha do arquivo texto
     * @return retorna o tipo do atributo e o nome (label) do atributo
     */
    private String armazenaAtributos(String linha) {
        String Atributo = null;

        StringTokenizer tokens = new StringTokenizer(linha, ", ");
        tokens.nextToken(); // "attribute, "
        String tipoAtributo = tokens.nextToken(); // name, from, to, children, parent
        linha = arquivoEntrada.getLine(); //lê a próxima linha
        tokens = new StringTokenizer(linha, ":");
        tokens.nextToken(); // ": "
        String atributo = tokens.nextToken(); //armazena o atributo
        if (atributo.charAt(0) == ' ') {
            int i = 0;
            while (atributo.charAt(i) == ' ') {
                i += 1;
            }
            atributo = atributo.substring(i, atributo.length());
        }

        Atributo = tipoAtributo + " " + atributo;

        return Atributo;
    }

    /**
     * Cria um Elemento IStarActorElement
     *
     * @param element elemento Ator
     * @param codigo codigo do elemento Ator
     * @param linha linha do arquivo texto
     * @return IStarActorElement um Ator i*
     */
    private IStarActorElement criarAtor(IStarActorElement elementActor, String codigo, String linha) {
        elementActor.setCod(codigo); //armazena o Código Element_x
        linha = arquivoEntrada.getLine(); // WITH
        linha = arquivoEntrada.getLine();
        String atributo, tipoAtributo, nomeAtributo = null;
        while (!(linha.equals("END"))) {//lê atributos até encontrar o token END
            while (linha.compareTo("") == 0) {
                linha = arquivoEntrada.getLine();
            }
            atributo = armazenaAtributos(linha);
            StringTokenizer tokens = new StringTokenizer(atributo);
            tipoAtributo = tokens.nextToken();
            if (tipoAtributo.equals("children")) {
                nomeAtributo = atributo.substring(atributo.indexOf("children") + 9, atributo.length());
                elementActor.setChildren(nomeAtributo);
            } else if (tipoAtributo.equals("name")) {
                //nomeAtributo = tokens.nextToken();
                nomeAtributo = atributo.substring(atributo.indexOf("name") + 6, atributo.length() - 1);
                elementActor.setName(nomeAtributo);
            } else if (tipoAtributo.equals("links")) {
                //nomeAtributo = tokens.nextToken();
                nomeAtributo = atributo.substring(atributo.indexOf("links") + 5, atributo.length());
                elementActor.setLinks(nomeAtributo);
            }
            linha = arquivoEntrada.getLine();
        }
        return elementActor;
    }

    /**
     * Cria um Elemento IStar (Objetivo, Tarefa, SoftGoal ou Recurso)
     *
     * @param element elemento
     * @param codigo codigo do elemento
     * @param linha linha do arquivo texto
     * @return IStarElement um elemento (Objetivo, Tarefa, SoftGoal ou Recurso)
     */
    private IStarElement criarElemento(IStarElement element, String codigo, String linha) {
        element.setCod(codigo); //armazena o Código Element_x
        linha = arquivoEntrada.getLine(); // WITH
        linha = arquivoEntrada.getLine();
        String atributo, tipoAtributo, nomeAtributo = null;
        while (!(linha.equals("END"))) { //lê atributos até encontrar o token END
            while (linha.compareTo("") == 0) {
                linha = arquivoEntrada.getLine();
            }
            atributo = armazenaAtributos(linha);
            StringTokenizer tokens = new StringTokenizer(atributo);
            tipoAtributo = tokens.nextToken();
            if (tipoAtributo.equals("parent")) {
                nomeAtributo = atributo.substring(atributo.indexOf("parent") + 8, atributo.length());
                element.setParent(nomeAtributo);
            } else if (tipoAtributo.equals("name")) {
                nomeAtributo = tokens.nextToken();
                nomeAtributo = atributo.substring(atributo.indexOf("name") + 4, atributo.length());
                element.setName(nomeAtributo);
            } else if (tipoAtributo.equals("links")) {
                nomeAtributo = tokens.nextToken();
                nomeAtributo = atributo.substring(atributo.indexOf("links") + 5, atributo.length());
                element.setLinks(nomeAtributo);
            }
            linha = arquivoEntrada.getLine();
        }
        return element;
    }

    /**
     * Cria um Link IStar
     *
     * @param element elemento
     * @param codigo codigo do link (Element_x)
     * @param linha linha do arquivo texto
     * @return IStarElement um elemento
     */
    private IStarLink criarLink(IStarLink element, String codigo, String linha) {
        element.setCod(codigo); //armazena o Código Element_x
        linha = arquivoEntrada.getLine(); // WITH
        linha = arquivoEntrada.getLine();
        String atributo, tipoAtributo, nomeAtributo = null;
        while (!(linha.equals("END"))) { //lê atributos até encontrar o token END
            while (linha.compareTo("") == 0) {
                linha = arquivoEntrada.getLine();
            }
            atributo = armazenaAtributos(linha);
            StringTokenizer tokens = new StringTokenizer(atributo);
            tipoAtributo = tokens.nextToken();
            if (tipoAtributo.equals("from")) {
                nomeAtributo = atributo.substring(atributo.indexOf("from") + 5, atributo.length());
                element.setFrom(nomeAtributo);
            } else if (tipoAtributo.equals("to")) {
                nomeAtributo = atributo.substring(atributo.indexOf("to") + 3, atributo.length());
                element.setTo(nomeAtributo);
            } else {
                nomeAtributo = tokens.nextToken();
                nomeAtributo = atributo.substring(atributo.indexOf("name") + 4, atributo.length());
                element.setName(nomeAtributo);
            }
            linha = arquivoEntrada.getLine();
        }
        return element;
    }

    /**
     * Método responsável por preencher o atributo links dos actors, goals,
     * softgoals, tasks e resources.
     * <br/>
     * private ArrayList
     * <code> &lt;IStarActorElement&gt; </code>actors;
     * <br/>
     * private ArrayList goals,softgoals,tasks,resources;
     * <br/>
     * //OMEElements
     * <br/>
     * private ArrayList dependencies,meansEnds,decompositions,isas, inss,
     * contributions, ispartofs; //OMELinks
     */
    private void criarLinkElementos() {
        int cont = 0;
        String from, to, nameLink; //da onde vem, para onde vai e o nome do link
        int tipoLink;
        //mapear dependências para elementos
        for (cont = 0; cont < dependencies.size(); cont++) {
            tipoLink = 0;
            IStarLink dependencia = dependencies.get(cont);
            from = dependencia.getFrom();
            to = dependencia.getTo();
            nameLink = dependencia.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links de Dependência Criados");
        // mapear ISA
        for (cont = 0; cont < isas.size(); cont++) {
            tipoLink = 1;
            IStarLink ligacaoISA = isas.get(cont);
            from = ligacaoISA.getFrom();
            to = ligacaoISA.getTo();
            nameLink = ligacaoISA.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links ISA Criados");
        //mapear decomposição de tarefas para elementos
        for (cont = 0; cont < decompositions.size(); cont++) {
            tipoLink = 2;
            IStarLink decomposicaoDeTarefas = decompositions.get(cont);
            from = decomposicaoDeTarefas.getFrom();
            to = decomposicaoDeTarefas.getTo();
            nameLink = decomposicaoDeTarefas.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links de Decomposição de Tarefas Criados");
        //mapear meio-fim para elementos
        for (cont = 0; cont < meansEnds.size(); cont++) {
            tipoLink = 3;
            IStarLink meioFim = meansEnds.get(cont);
            from = meioFim.getFrom();
            to = meioFim.getTo();
            nameLink = meioFim.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links Meio-Fim Criados");
        // mapear INS
        for (cont = 0; cont < inss.size(); cont++) {
            tipoLink = 4;
            IStarLink ligacaoINS = inss.get(cont);
            from = ligacaoINS.getFrom();
            to = ligacaoINS.getTo();
            nameLink = ligacaoINS.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links INS Criados");
        // mapear Is-Part-Of
        for (cont = 0; cont < ispartofs.size(); cont++) {
            tipoLink = 5;
            IStarLink ligacaoIsPartOf = ispartofs.get(cont);
            from = ligacaoIsPartOf.getFrom();
            to = ligacaoIsPartOf.getTo();
            nameLink = ligacaoIsPartOf.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links Is-Part-Of Criados");
        for (cont = 0; cont < occupiess.size(); cont++) {
            tipoLink = 6;
            IStarLink ligacaoOccupies = occupiess.get(cont);
            from = ligacaoOccupies.getFrom();
            to = ligacaoOccupies.getTo();
            nameLink = ligacaoOccupies.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links Occupies Criados");
        for (cont = 0; cont < playss.size(); cont++) {
            tipoLink = 7;
            IStarLink ligacaoPlays = playss.get(cont);
            from = ligacaoPlays.getFrom();
            to = ligacaoPlays.getTo();
            nameLink = ligacaoPlays.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links Plays Criados");
        for (cont = 0; cont < coverss.size(); cont++) {
            tipoLink = 8;
            IStarLink ligacaoCovers = coverss.get(cont);
            from = ligacaoCovers.getFrom();
            to = ligacaoCovers.getTo();
            nameLink = ligacaoCovers.getCod();
            criarLinkElementosFromTo(from, to, nameLink, tipoLink);
        }
        //System.out.println("Links Covers Criados");
        /*
         * // mapear Contribution for (cont = 0; cont < contributions.size();
         * cont++) { tipoLink = 6; IStarLink ligacaoContribution =
         * contributions.get(cont); from = ligacaoContribution.getFrom(); to =
         * ligacaoContribution.getTo(); nameLink = ligacaoContribution.getCod();
         * criarLinkElementosFromTo(from, to, nameLink, tipoLink); }
         * System.out.println("Links Contribution Criados");
         */

    }

    private void criarLinkElementosFromTo(String from, String to, String nameLink, int tipoLink) {
        setLinkAtorElementoCod(from, nameLink, tipoLink);
        setLinkAtorElementoCod(to, nameLink, tipoLink);
    }

    private void setLinkAtorElementoCod(String cod, String nameLink, int tipoLink) {
        int contElementoLink = 0;
        boolean encontrou = false;

        while ((encontrou == false) && (contElementoLink <= 4)) {
            switch (contElementoLink) {
                case 0: { //	IStarActorElement
                    int posAtor = procuraActorCod(cod);
                    if (posAtor != -1) {
                        encontrou = true;
                        IStarActorElement actor = actors.get(posAtor);
                        actor.setLinks(tipoLink, nameLink);
                    }
                    contElementoLink++;
                }
                break;
                case 1: { //IStarGoalElement goal
                    int posGoal = procuraElementoCod(contElementoLink, cod);
                    if (posGoal != -1) {
                        encontrou = true;
                        IStarElement goal = goals.get(posGoal);
                        goal.setLinks(tipoLink, nameLink);
                    }
                    contElementoLink++;
                }
                break;
                case 2: { //IStarTaskElement task 
                    int posTask = procuraElementoCod(contElementoLink, cod);
                    if (posTask != -1) {
                        encontrou = true;
                        IStarElement task = tasks.get(posTask);
                        task.setLinks(tipoLink, nameLink);
                    }
                    contElementoLink++;
                }
                break;
                case 3: { //IStarSoftGoalElement softgoal 
                    int posSoftGoal = procuraElementoCod(contElementoLink, cod);
                    if (posSoftGoal != -1) {
                        encontrou = true;
                        IStarElement softgoal = softgoals.get(posSoftGoal);
                        softgoal.setLinks(tipoLink, nameLink);
                    }
                    contElementoLink++;
                }
                break;
                case 4: { //IStarResourceElement resource
                    int posResource = procuraElementoCod(contElementoLink, cod);
                    if (posResource != -1) {
                        encontrou = true;
                        IStarElement resource = resources.get(posResource);
                        resource.setLinks(tipoLink, nameLink);
                    }
                    contElementoLink++;
                }
                break;
                default: {
                }
                break;
            }
        }
    }

    /**
     * Procura o Ator pelo código
     *
     * @param cod codigo do ator
     * @return posAtor retorna a posição do Ator, se não achou retorna -1
     */
    public int procuraActorCod(String cod) {
        int contAtor = 0, posAtor = -1;
        IStarActorElement act = new IStarActorElement(); //cria um Ator i*
        boolean encontrou = false; //verifica se encontrou algum ator com o código (cod)

        while ((encontrou == false) && (contAtor < actors.size())) {
            act = actors.get(contAtor);
            if (cod.compareTo(act.getCod()) == 0) {
                encontrou = true;
                posAtor = contAtor;
            }
            contAtor++;
        }
        return posAtor;
    }

    /**
     * Procura o Elemento pelo código
     *
     * @param tipoElemento tipo do Elemento 0(goal),1(task)...
     * @param cod codigo procurado
     * @return pos retorna a posição do Elemento, se não achou retorna -1
     */
    public int procuraElementoCod(int tipoElemento, String cod) {
        boolean encontrou = false; //verifica se encontrou algum objetivo com o código (cod)
        int pos = -1;

        switch (tipoElemento) {
            case 1: { //IStarGoalElement goal
                int cont = 0;
                IStarElement goal = new IStarElement(); //cria um Objetivo i*
                while ((encontrou == false) && (cont < goals.size())) {
                    goal = goals.get(cont);
                    if (cod.compareTo(goal.getCod()) == 0) {
                        encontrou = true;
                        pos = cont;
                    }
                    cont++;
                }

            }
            break;
            case 2: { //IStarTaskElement task 
                int cont = 0;
                IStarElement task = new IStarElement(); //cria uma Tarefa i*
                while ((encontrou == false) && (cont < tasks.size())) {
                    task = tasks.get(cont);
                    if (cod.compareTo(task.getCod()) == 0) {
                        encontrou = true;
                        pos = cont;
                    }
                    cont++;
                }
            }
            break;
            case 3: { //IStarSoftGoalElement softgoal 
                int cont = 0;
                IStarElement softgoal = new IStarElement(); //cria um Objetivo Soft i*
                while ((encontrou == false) && (cont < softgoals.size())) {
                    softgoal = softgoals.get(cont);
                    if (cod.compareTo(softgoal.getCod()) == 0) {
                        encontrou = true;
                        pos = cont;
                    }
                    cont++;
                }
            }
            break;
            case 4: { //IStarResourceElement resource
                int cont = 0;
                IStarElement resource = new IStarElement(); //cria um Recurso i*
                while ((encontrou == false) && (cont < resources.size())) {
                    resource = resources.get(cont);
                    if (cod.compareTo(resource.getCod()) == 0) {
                        encontrou = true;
                        pos = cont;
                    }
                    cont++;
                }
            }
            break;
            default: {
            }
            break;
        }
        return pos;
    }

    /**
     * Verifica a posição do ator que representa o sistema no vetor de Atores
     *
     * @param systemActor codigo do ator do Sistema
     * @return pos retorna a posicao
     */
    private int posicaoAtorSistema(String systemActor) {
        ArrayList<IStarActorElement> actorsOME = (ArrayList<IStarActorElement>) actors.clone();
        int posActorSistema = -1;

        for (int i = 0; i < actorsOME.size(); i++) {
            if ((actorsOME.get(i).getCod().equals(systemActor))) {
                posActorSistema = i;
            }
        }
        return posActorSistema;
    }

    /**
     * Verifica se o Diagrama é SD ou SR
     *
     * @param systemActor código do ator do Sistema
     * @return SR se for SR retorna true, se for SD retorna False
     */
    public boolean verificaSDSR(String systemActor) {
        ArrayList<IStarActorElement> actorsOME = (ArrayList<IStarActorElement>) actors.clone();
        ArrayList childrens;
        childrens = actorsOME.get(posicaoAtorSistema(systemActor)).getChildren();
        boolean SR;
        if (!childrens.isEmpty()) {
            SR = true; //verifica se o Diagrama é SD ou SR
            //System.out.println("Diagrama SR - Razões Estratégicas");
        } else {
            SR = false;
            //System.out.println("Diagrama SD - Dependências Estratégicas");
        }
        return SR;
    }

    /**
     *
     * @param codigoAtor
     * @return
     */
    public int procuraAtorNome(String codigoAtor) {
        int posAtor = -1;
        boolean encontrou = false;
        int i = 0;
        while ((i < actors.size()) || (!encontrou)) {
            if (this.actors.get(i).getCod().equals(codigoAtor)) {
                encontrou = true;
                posAtor = i;
            }
            i++;
        }

        return posAtor;
    }

    /**
     * @return Returns the actors.
     */
    public ArrayList<IStarActorElement> getActors() {
        return actors;
    }

    /**
     * @return Returns the agents.
     */
    public ArrayList<IStarAgentElement> getAgents() {
        return agents;
    }

    /**
     * @return Returns the roles.
     */
    public ArrayList<IStarRoleElement> getRoles() {
        return roles;
    }

    /**
     * @return Returns the positions.
     */
    public ArrayList<IStarPositionElement> getPositions() {
        return positions;
    }

    /**
     * Retorna o Elemento Ator e seus atributos
     *
     * @param i posicao do Ator no vetor de Atores
     * @return actor
     */
    public IStarActorElement getActor(int i) {
        return (IStarActorElement) actors.get(i);
    }

    /**
     * Retorna o Elemento Agent e seus atributos
     *
     * @param i posicao do Agent no vetor de Agents
     * @return agent
     */
    public IStarAgentElement getAgent(int i) {
        return (IStarAgentElement) agents.get(i);
    }

    /**
     * Retorna o Elemento Role e seus atributos
     *
     * @param i posicao do Role no vetor de Roles
     * @return role
     */
    public IStarRoleElement getRole(int i) {
        return (IStarRoleElement) roles.get(i);
    }

    /**
     * Retorna o Elemento Position e seus atributos
     *
     * @param i posicao do Position no vetor de Positions
     * @return position
     */
    public IStarPositionElement getPosition(int i) {
        return (IStarPositionElement) positions.get(i);
    }

    /**
     * @param actors The actors to set.
     */
    public void setActors(ArrayList<IStarActorElement> actors) {
        this.actors = actors;
    }

    /**
     * @param agents The agents to set.
     */
    public void setAgents(ArrayList<IStarAgentElement> agents) {
        this.agents = agents;
    }

    /**
     * @param roles The roles to set.
     */
    public void setRoles(ArrayList<IStarRoleElement> roles) {
        this.roles = roles;
    }

    /**
     * @param positions The positions to set.
     */
    public void setPositions(ArrayList<IStarPositionElement> positions) {
        this.positions = positions;
    }

    /**
     * @return Returns the dependencies.
     */
    public ArrayList<IStarLink> getDependencies() {
        return dependencies;
    }

    /**
     * @param dependencies The dependencies to set.
     */
    public void setDependencies(ArrayList<IStarLink> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Pega um Elemento conforme o indice (1)Goal, (2) Taks, (3) Softgoal, (4)
     * resources
     *
     * @param nElemento
     * @param posElemento
     * @return
     */
    public IStarElement getElement(int nElemento, int posElemento) {
        IStarElement elemento = new IStarElement();
        switch (nElemento) {
            case 1: { //IStarGoalElement goal
                elemento = goals.get(posElemento);
            }
            break;
            case 2: { //IStarTaskElement task 
                elemento = tasks.get(posElemento);

            }
            break;
            case 3: { //IStarSoftGoalElement softgoal 
                elemento = softgoals.get(posElemento);
            }
            break;
            case 4: { //IStarResourceElement resource
                elemento = resources.get(posElemento);
            }
            break;
            default: {
            }
            break;
        }
        return elemento;
    }

    public ArrayList<IStarLink> getISA() {
        return isas;
    }

    public IStarLink getISA(int i) {
        return (IStarLink) isas.get(i);
    }

    public ArrayList<IStarLink> getINS() {
        return inss;
    }

    public IStarLink getINS(int i) {
        return (IStarLink) inss.get(i);
    }

    public ArrayList<IStarLink> getContribution() {
        return contributions;
    }

    public IStarLink getContribution(int i) {
        return (IStarLink) contributions.get(i);
    }

    public ArrayList<IStarLink> getIsPartOf() {
        return ispartofs;
    }

    public IStarLink getIsPartOf(int i) {
        return (IStarLink) ispartofs.get(i);
    }

    public ArrayList<IStarLink> getOccupies() {
        return occupiess;
    }

    public IStarLink getOccupies(int i) {
        return (IStarLink) occupiess.get(i);
    }

    public ArrayList<IStarLink> getPlays() {
        return playss;
    }

    public IStarLink getPlays(int i) {
        return (IStarLink) playss.get(i);
    }

    public ArrayList<IStarLink> getCovers() {
        return coverss;
    }

    public IStarLink getCovers(int i) {
        return (IStarLink) coverss.get(i);
    }

    public String getDirEntrada() {
        return dirEntrada;
    }

    /**
     * @return Returns the decompositions.
     */
    public ArrayList<IStarLink> getDecompositions() {
        return decompositions;
    }

    /**
     * @return Returns the goals.
     */
    public ArrayList<IStarElement> getGoals() {
        return goals;
    }

    /**
     * @return Returns the isas.
     */
    public ArrayList<IStarLink> getIsas() {
        return isas;
    }

    /**
     * @return Returns the inss.
     */
    public ArrayList<IStarLink> getInss() {
        return inss;
    }

    /**
     * @return Returns the occupiess.
     */
    public ArrayList<IStarLink> getOccupiess() {
        return occupiess;
    }

    /**
     * @return Returns the playss.
     */
    public ArrayList<IStarLink> getPlayss() {
        return playss;
    }

    /**
     * @return Returns the coverss.
     */
    public ArrayList<IStarLink> getCoverss() {
        return coverss;
    }

    /**
     * @return Returns the contributions.
     */
    public ArrayList<IStarLink> getContributions() {
        return contributions;
    }

    /**
     * @return Returns the ispartofs.
     */
    public ArrayList<IStarLink> getIspartofs() {
        return ispartofs;
    }

    /**
     * @return Returns the meansEnds.
     */
    public ArrayList<IStarLink> getMeansEnds() {
        return meansEnds;
    }

    /**
     * @return Returns the resources.
     */
    public ArrayList<IStarElement> getResources() {
        return resources;
    }

    /**
     * @return Returns the softgoals.
     */
    public ArrayList<IStarElement> getSoftgoals() {
        return softgoals;
    }

    /**
     * @return Returns the tasks.
     */
    public ArrayList<IStarElement> getTasks() {
        return tasks;
    }
}
