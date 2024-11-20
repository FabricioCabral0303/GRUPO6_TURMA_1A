import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rpg {
	
	//lucas
    private static JFrame mainFrame; // Referência para o JFrame principal
    private static JPanel contentPane; // Referência para o contentPane principal

    public static void main(String[] args) {
        mainFrame = new JFrame("Os diamantes de Villalva");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(960, 960);
        mainFrame.setLocationRelativeTo(null); // Centraliza a janela

        Color backgroundColor = new Color(0x05072B);

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(backgroundColor);

        // Tela inicial
        createInitialScreen();

        mainFrame.setContentPane(contentPane);
        mainFrame.setVisible(true);
    }

    // Cria a tela inicial com os botões e imagem
    private static void createInitialScreen() {
        // Define as dimensões do painel de botões
        int buttonWidth = 200;
        int buttonHeight = 50;

        // Cria o painel para os botões
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10)); // GridLayout para organizar os botões verticalmente
        buttonPanel.setBackground(new Color(0x05072B)); // Define o fundo do painel

        // Cria os botões
        JButton jogarButton = new JButton("JOGAR");
        jogarButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jogarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        jogarButton.setForeground(new Color(0xFF7F2A));
        jogarButton.setBackground(new Color(0x05072B));
        jogarButton.setBorder(BorderFactory.createEmptyBorder());
        jogarButton.setFocusPainted(false); // Desabilita a marcação de foco

        JButton instrucoesButton = new JButton("INSTRUÇÕES");
        instrucoesButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        instrucoesButton.setFont(new Font("Arial", Font.PLAIN, 20));
        instrucoesButton.setForeground(new Color(0xFF7F2A));
        instrucoesButton.setBackground(new Color(0x05072B));
        instrucoesButton.setBorder(BorderFactory.createEmptyBorder());
        instrucoesButton.setFocusPainted(false); // Desabilita a marcação de foco

        JButton creditosButton = new JButton("CRÉDITOS");
        creditosButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        creditosButton.setFont(new Font("Arial", Font.PLAIN, 20));
        creditosButton.setForeground(new Color(0xFF7F2A));
        creditosButton.setBackground(new Color(0x05072B));
        creditosButton.setBorder(BorderFactory.createEmptyBorder());
        creditosButton.setFocusPainted(false); // Desabilita a marcação de foco

        JButton sairButton = new JButton("SAIR");
        sairButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        sairButton.setFont(new Font("Arial", Font.PLAIN, 20));
        sairButton.setForeground(new Color(0xFF7F2A));
        sairButton.setBackground(new Color(0x05072B));
        sairButton.setBorder(BorderFactory.createEmptyBorder());
        sairButton.setFocusPainted(false); // Desabilita a marcação de foco

        // Adiciona os botões ao painel
        buttonPanel.add(jogarButton);
        buttonPanel.add(instrucoesButton);
        buttonPanel.add(creditosButton);
        buttonPanel.add(sairButton);

        // Cria um painel vazio para adicionar espaço acima dos botões
        JPanel spacePanel = new JPanel();
        spacePanel.setBackground(new Color(0x05072B));
        spacePanel.setPreferredSize(new Dimension(1, 800)); // Ajuste a altura para controlar o espaço

        // Cria o painel principal para conter os botões
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Use FlowLayout para centralizar tudo
        mainPanel.setBackground(new Color(0x05072B));

        // Adiciona o espaço, o painel de botões e um espaço extra ao painel principal
        mainPanel.add(spacePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(spacePanel);

        // Centraliza o painel principal na tela
        contentPane.add(mainPanel, BorderLayout.CENTER);

        // Adiciona ActionListener aos botões
        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startQuiz();
            }
        });

        instrucoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInstructions();
            }
        });

        creditosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCredits();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
//lucas
    	//fabricio
    // Método para iniciar o quiz (após clicar em "JOGAR")
    private static void startQuiz() {
        // Remove a tela inicial
        contentPane.removeAll(); 
        contentPane.revalidate(); 
        contentPane.repaint(); 

        // Cria a tela do quiz
        createQuizScreen();
    }

     // Método para criar a tela do quiz
     private static void createQuizScreen() {
        // Cria a tela do quiz como você já tinha implementado anteriormente
        JLabel titleLabel = new JLabel("Os Diamantes de Villalva", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 36));
        titleLabel.setForeground(new Color(0xFF7F2A));
        contentPane.add(titleLabel, BorderLayout.NORTH);

        JPanel questionPanel = new JPanel(new BorderLayout());
        questionPanel.setBackground(new Color(0x05072B));
        questionPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 0, 0));

         // Desabilita o sublinhado, a seleção e o foco no questionArea
         JTextArea questionArea = new JTextArea();
         questionArea.setEditable(false);
         questionArea.setFont(new Font("Plain", Font.PLAIN, 24));
         questionArea.setLineWrap(true);
         questionArea.setWrapStyleWord(true);
         questionArea.setForeground(new Color(0xFF7F2A));
         questionArea.setBackground(new Color(0x05072B));
         questionArea.setHighlighter(null);
         questionArea.setSelectionColor(new Color(0x05072B));
         questionArea.setFocusable(false);

         JScrollPane scrollPane = new JScrollPane(questionArea);
         scrollPane.setBorder(BorderFactory.createEmptyBorder());
         questionPanel.add(scrollPane, BorderLayout.NORTH);
 
         JPanel answerPanel = new JPanel();
         answerPanel.setBackground(new Color(0x05072B));
         answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
 
         answerPanel.add(Box.createRigidArea(new Dimension(0, 10)));

         JButton[] buttons = new JButton[5];
         for (int i = 0; i < 5; i++) {
             buttons[i] = new JButton(" ");
             buttons[i].setFont(new Font("Arial", Font.PLAIN, 20));
             buttons[i].setForeground(new Color(0xFF7F2A));
             buttons[i].setBackground(new Color(0x05072B));
             buttons[i].setBorder(BorderFactory.createEmptyBorder());
             buttons[i].setFocusPainted(false); // Desabilita a marcação de foco

             answerPanel.add(buttons[i]);

            if (i < buttons.length - 1) {
                answerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        questionPanel.add(answerPanel, BorderLayout.CENTER);
        contentPane.add(questionPanel, BorderLayout.CENTER);
        