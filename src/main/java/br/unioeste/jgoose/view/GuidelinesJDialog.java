package br.unioeste.jgoose.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Leonardo Merlin - leonardo.merlin at unioeste.br
 */
public class GuidelinesJDialog extends JDialog {

    public GuidelinesJDialog(Frame frame) throws BadLocationException {
        super(frame);
        //@TODO: internationalize the title of guidelines dialog.
        setTitle("Diretrizes");
        setLayout(new BorderLayout());

        // Creates the gradient panel
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createMatteBorder(0, 0, 1, 0, Color.GRAY), BorderFactory
                .createEmptyBorder(8, 8, 12, 8)));


        // Add title
        //@TODO: internationalize this.
        JLabel titleLabel = new JLabel("Diretrizes");
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        titleLabel.setOpaque(false);
        panel.add(titleLabel, BorderLayout.NORTH);

        // Adds optional subtitle
        // @TODO: address to be defined or removed.
//        JLabel subtitleLabel = new JLabel(
//                "For more information visit http://www.unioeste.br/jgoose");
//        subtitleLabel.setBorder(BorderFactory.createEmptyBorder(4, 18, 0, 0));
//        subtitleLabel.setOpaque(false);
//        panel.add(subtitleLabel, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.NORTH);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        content.add(new JLabel("JGOOSE - Diretrizes"));
        //@TODO: organize the software version. Version Management?
        content.add(new JLabel("version: 0.4.1-2013"));
        content.add(new JLabel(" "));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setColumns(40);
        textArea.setWrapStyleWord(true);
        JScrollPane jScrollPane = new JScrollPane(textArea);

        Document document = new DefaultStyledDocument();
        int offset;
        offset = document.getEndPosition().getOffset();
        document.insertString(offset, "Passo 1 - Descoberta de Atores\n"
                + " - Diretriz 1: todo ator em i* deve ser analisado para um possível mapeamento para ator em caso de uso.\n"
                + " - Diretriz 2: inicialmente, deve-se analisar se o ator em i* é externo ao sistema computacional pretendido. Caso o ator seja externo ao sistema, o mesmo é considerado candidato a ator em Casos de Uso.\n"
                + " - Diretriz 3: deve-se garantir que o ator em i* é candidato a ator em Casos de Uso, atráves da seguinte análise:\n"
                + " - - Subdiretriz 3.1: verificar se existe pelo menos uma dependência do ator analisado em relação ao ator em i* que representa o sistema computacional pretendido.\n"
                + " - Diretriz 4: atores em i*, relacionados através do mecanismo ISA nos modelos organizacionais e mapeados individualmente para atores em Casos de Uso (aplicando diretrizes 1, 2 e 3), serão relacionados no diagrama de Casos de Uso atráves do relacionamento do tipo <<generalização>>.\n"
                + "Passo 2 - Descoberta de Casos de Uso\n"
                + " - Diretriz 5: para cada ator descoberto no Passo 1, observar todas as suas dependências (dependum) do ponto de vista do ator como dependee, em relação ao ator sistema computacional pretendido (sistema computacional -> dependum -> ator) visando descobrir Casos de Uso para o ator analisado.\n"
                + " - - Subdiretriz 5.1: avaliar dependências do tipo objetivo - cada dependência deste tipo deve ser mapeado diretamente para caso de uso do ator.\n"
                + " - - Subdiretriz 5.2: avaliar dependências do tipo tarefa - cada dependência deste tipo deve ser mapeada diretamente para caso de uso do ator.\n"
                + " - - Subdiretriz 5.3: avaliar dependências do tipo recurso - cada dependência deste tipo deve ser mapeada diretamente para caso de uso do ator.\n"
                + " - - Subdiretriz 5.4: dependências do tipo objetivo-soft não representa um caso de uso do sistema, mas uma exigência não funcional associada com um caso de uso específico do sistema ou com o sistema como um todo.\n"
                + " - Diretriz 6: analisar a situação especial na qual um ator de sistema (descoberto seguinda as diretrizes do Passo 1) possui dependências (como depender) em relação ao ator em i* que representa o sistema computacional pretendido ou parte dele (ator -> dependum -> sistema computacional).\n"
                + "Passo 3 - Descoberta e descrição do fluxo principal e alternativos dos Casos de Uso\n"
                + " - Diretriz 8: analisar cada ator e seus relacionamentos no Modelo SR para extrair informações que possam conduzir à descrição de fluxos principais e alternativos, bem como pré-condições e pós-condições dos Casos de Uso descobertos para o ator.\n"
                + " - - Subdiretriz 8.1: analisar os sub-componentes em uma ligação de decomposição de tarefa em um possível mapeamento para passos na descrição do cenário primário (fluxo principal) de Casos de Uso.\n"
                + " - - Subdiretriz 8.2: analisar ligações do tipo means-end em um possível mapeamento para passos alternativos na descrição de Casos de Uso.\n"
                + " - - Subdiretriz 8.3: analisar os relacionamentos de dependências de sub-atores do sistema. Estas dependências podem originar pré-condições e pós-condições para os Casos de Uso descobertos.\n"
                + " - Diretriz 10: desenvolver o diagrama de Casos de Uso utilizando os Casos de Uso descobertos, bem como observando os relacionamentos do tipo <<include>>, <<extend>> e <<generalization>> usandos para estruturar as especificações dos Casos de Uso.\n", null);

        textArea.setDocument(document);
//        getContentPane().add(textArea, BorderLayout.CENTER);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createMatteBorder(1, 0, 0, 0, Color.GRAY), BorderFactory
                .createEmptyBorder(16, 8, 8, 8)));
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Adds OK button to close window
        // @TODO: internationalize close button name.
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonPanel.add(closeButton);

        // Sets default button for enter key
        getRootPane().setDefaultButton(closeButton);
        
        
        this.setResizable(false);
        this.setSize(800, 600);
    }

    /**
     * Overrides {@link JDialog#createRootPane()} to return a root pane that
     * hides the window when the user presses the ESCAPE key.O
     * @return 
     */
    @Override
    protected JRootPane createRootPane() {
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        JRootPane resultRootPane = new JRootPane();
        resultRootPane.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
            }
        }, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        return resultRootPane;
    }
}
