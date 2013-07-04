package br.unioeste.jgoose.model;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 *
 * @author Diego Peliser
 */
/**
 * Classe com métodos para manipulação dos arquivos texto de entrada e saída da
 * ferramenta.
 */
public class Arquivo {

    private FileWriter escrever;
    private PrintWriter out;
    private FileReader ler;
    private BufferedReader in;
    private String direntrada;
    private String dirsaida;

    /**
     * Construtor da classe File
     */
    public Arquivo() {
        direntrada = ""; // caminho do arquivo de entrada
        dirsaida = ""; // caminho do arquivo de saida

        String saida = "saida.txt";

        String curDir = System.getProperty("user.dir");

        //cria a caixa de dialogo
        JFileChooser fileChooser = new JFileChooser(curDir);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Telos", "tel");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        //recebe o resultado
        int resultado = fileChooser.showOpenDialog(null);

        // se o usuario clicou no botao Cancel no dialogo, retorna
        if (resultado == JFileChooser.CANCEL_OPTION) {
            fileChooser.setVisible(false);
        } else {
            // obtem o arquivo selecionado
            File fileName = fileChooser.getSelectedFile();

            try {
                // exibe erro se invalido
                if ((fileName == null) || (fileName.getName().equals(""))) {
                    JOptionPane.showMessageDialog(null,
                            "Nome de Arquivo Inválido",
                            "Nome de Arquivo Inválido",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                direntrada = fileName.getName();

                escrever = new FileWriter(saida);
                ler = new FileReader(fileName);
                in = new BufferedReader(ler);
                out = new PrintWriter(escrever);

            } catch (IOException excep) {
                System.out.println("Erro de excessao construtor");
            }
        }
    }

    public Arquivo(File inputFile, String outputFilename) {
        this(inputFile, new File(outputFilename));
    }

    public Arquivo(File inputFile, File outputFile) {
        this.direntrada = inputFile.getName();

        this.initReader(inputFile);

        // @ TODO: change this 'magic filename'.
//        String saida = "saida.txt";
        this.initWriter(outputFile);
    }

    private void initReader(File inputfile) {
        try {
            this.ler = new FileReader(inputfile);
            in = new BufferedReader(this.ler);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initWriter(File outputFile) {
        try {
            this.escrever = new FileWriter(outputFile);
            out = new PrintWriter(this.escrever);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Escreve no arquivo de saida (sem pular linha)
     *
     * @param s
     */
    public void setLine(String s) {
        out.print(s);
    }

    /**
     * Escreve no arquivo de saida (pulando linha)
     *
     * @param s
     */
    public void setLineln(String s) {
        out.println(s);
    }

    /**
     * Captura uma linha do arquivo texto
     *
     * @return String s
     */
    public String getLine() {
        String s = "";
        try {
            s = in.readLine();
        } catch (IOException excep) {
            System.out.println("Erro de excessao getline");
        }
        return s;
    }

    /**
     * Fecha os arquivos texto abertos
     */
    public void Close() {
        try {
            in.close();
            out.close();
            escrever.close();
            ler.close();
        } catch (IOException excep) {
            System.out.println("Erro de excessao");
        }
    }

    /**
     * Retorna o Diretorio (Caminho) do arquivo de entrada
     *
     * @return direntrada
     */
    public String getdirEntrada() {
        return direntrada;
    }

    /**
     * Retorna o Diretorio (Caminho) do arquivo de saida
     *
     * @return dirsaida
     */
    public String getdirSaida() {
        return dirsaida;
    }
}
