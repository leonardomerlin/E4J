package br.unioeste.jgoose.controller;

import br.unioeste.jgoose.CasosDeUso.CasoDeUso;
import br.unioeste.jgoose.IStarElements.IStarActorElement;
import br.unioeste.jgoose.CasosDeUso.DiagramaCasosDeUso;
import br.unioeste.jgoose.model.TokensOpenOME;
import br.unioeste.jgoose.view.AtorSistemaView;
import br.unioeste.jgoose.view.PrincipalView;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Peliser
 */
public class Controller {

    private static PrincipalView principal = new PrincipalView();
    private static TokensOpenOME ome;
    private static String atorSistema;
    private static DiagramaCasosDeUso diagrama;

    /*
     * Método que controla o mapeamento dos casos de uso
     */
    public static void mapearCasosDeUso() {
        diagrama = new DiagramaCasosDeUso();
        diagrama.mapeamentoPasso1();
        diagrama.mapeamentoPasso2();
    }

    /*
     * Método que abre o Arquivo Telos, procura e armazena em uma estrutura de
     * dados os Atores, Elementos e Links
     */
    public static void abrirArquivoTelos(PrincipalView interfacePrincipal) {
        principal = interfacePrincipal;
        ome = new TokensOpenOME();
        ome.abrirArquivo();
        // Mapeia o arquivo se está no formato Telos
        if (ome.getDirEntrada().contains(".tel")) {
            ome.procuraArquivo();
            principal.setEnabled(false);
            principal.mapearCasosdeUso.setEnabled(false);
            // Abre a janela para selecionar o Ator Sistema
            AtorSistemaView atorsistema = new AtorSistemaView(principal);
            atorsistema.setVisible(true);
            atorsistema.setAlwaysOnTop(true);
        } else if (!ome.getDirEntrada().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um Arquivo Telos (.tel)", "ERRO!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Método que verifica o Ator Sistema Selecionado na ComboBox e o seta na
     * Interface Principal
     */
    public static void setAtorSistema(int posicao) {
        IStarActorElement Actor = ome.getActor(posicao);
        atorSistema = Actor.getCod();
        principal.atualizaTabela();
        principal.setEnabled(true);
        principal.mapearCasosdeUso.setEnabled(true);
    }
    
    /*
     * Método para retornar os Casos de Uso Mapeado
     */
    public static ArrayList<CasoDeUso> getCasosDeUso(){
        return diagrama.casosDeUso;
    }
    
    /**
     * @return Returns the ome.
     */
    public static TokensOpenOME getOme() {
        return ome;
    }

    /**
     * @return Returns the atorSistema
     */
    public static String getatorSistema() {
        return atorSistema;
    }
}
