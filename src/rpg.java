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

        JLabel attemptsLabel = new JLabel("Tentativas restantes: 5", SwingConstants.RIGHT);
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        attemptsLabel.setForeground(Color.WHITE);

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        labelPanel.setBackground(new Color(0x05072B));
        labelPanel.add(attemptsLabel);

        contentPane.add(labelPanel, BorderLayout.SOUTH);

        // Inicializa o jogo
        DoubleDiamondQuestions game = new DoubleDiamondQuestions(questionArea, buttons, answerPanel, labelPanel, attemptsLabel, contentPane);
        game.startQuiz();
    }
//fabricio

    // Métodos para as telas de instruções e créditos (implemente conforme necessário)
    private static void showInstructions() {
        // Implemente o conteúdo da tela de instruções aqui
        // Por exemplo:
        JOptionPane.showMessageDialog(mainFrame, "Instruções do jogo:\n" +
                "1. Leia cada pergunta com atenção.\n" +
                "2. Selecione a resposta correta entre as opções.\n" +
                "3. Você tem 5 tentativas para cada pergunta.\n" +
                "4. Boa sorte!");
    }
    private static void showCredits() {
        // Implemente o conteúdo da tela de créditos aqui
        // Por exemplo:
        JOptionPane.showMessageDialog(mainFrame, "Créditos:\n" +
                "Desenvolvido por: [Fabricio Cabral, Lucas Rezende, Kaik Nascimento e Hebert Reis]\n" +
                "Grupo 6: [Turma 1A]\n " +
                "\nEm forma de agradecimentos, este jogo foi desenvolvido em cima da Matéria de UX-UI do Professor: [Carlos William]");
    }
}   class DoubleDiamondQuestions {

    private JTextArea questionArea;
    private JButton[] answerButtons;
    private JPanel answerPanel; 
    private int currentQuestionIndex = 0;
    private int correctAnswers = 0;
    private int attempts = 5; 
    private List<Question> questions = new ArrayList<>();
    private JLabel attemptsLabel; 
    private JPanel labelPanel; 
    private JPanel contentPane; // Adiciona o contentPane como atributo

    public DoubleDiamondQuestions(JTextArea questionArea, JButton[] answerButtons, JPanel answerPanel, JPanel labelPanel, JLabel attemptsLabel, JPanel contentPane) { 
        this.questionArea = questionArea;
        this.answerButtons = answerButtons;
        this.answerPanel = answerPanel; 
        this.labelPanel = labelPanel; 
        this.attemptsLabel = attemptsLabel; 
        this.contentPane = contentPane; // Atribui o contentPane

        // Cria as perguntas
        questions.add(new Question("Qual é o primeiro passo do Double Diamond?",
                "Definir o problema",
                "Criar um protótipo",
                "Testar a solução",
                "Definir a solução",
                "Analisar os resultados",
                "A"));
        questions.add(new Question("Em qual etapa do Double Diamond você faz a pesquisa e define o problema?",
                "Descobrir",
                "Definir",
                "Desenvolver",
                "Entregar",
                "Avaliar",
                "A"));
        questions.add(new Question("Qual o objetivo da etapa 'Definir' no Double Diamond?",
                "Criar soluções possíveis",
                "Testar a viabilidade da solução",
                "Coletar dados sobre o problema",
                "Compreender o problema em profundidade",
                "Definir o problema a ser resolvido",
                "E"));
        questions.add(new Question("O que acontece na etapa 'Desenvolver' do Double Diamond?",
                "Criar protótipos da solução",
                "Testar as soluções com usuários",
                "Analisar os resultados dos testes",
                "Compreender as necessidades dos usuários",
                "Definir a melhor solução para o problema",
                "A"));
        questions.add(new Question("Em qual etapa do Double Diamond você realiza testes com usuários?",
                "Descobrir",
                "Definir",
                "Desenvolver",
                "Entregar",
                "Avaliar",
                "D"));
        questions.add(new Question("Qual o objetivo da etapa 'Entregar' no Double Diamond?",
                "Criar um protótipo da solução",
                "Testar a solução com usuários",
                "Implementar a solução final",
                "Coletar dados sobre o problema",
                "Definir o problema a ser resolvido",
                "C"));
        questions.add(new Question("O que acontece na etapa 'Avaliar' do Double Diamond?",
                "Analisar os resultados da implementação",
                "Testar a solução com usuários",
                "Criar um protótipo da solução",
                "Definir o problema a ser resolvido",
                "Coletar dados sobre o problema",
                "A"));
        questions.add(new Question("Qual das etapas abaixo NÃO faz parte do Double Diamond?",
                "Descobrir",
                "Definir",
                "Criar",
                "Entregar",
                "Avaliar",
                "C"));
        questions.add(new Question("Em qual etapa do Double Diamond você identifica as necessidades dos usuários?",
                "Descobrir",
                "Definir",
                "Desenvolver",
                "Entregar",
                "Avaliar",
                "A"));
        questions.add(new Question("O que acontece na etapa 'Definir' do Double Diamond?",
                "Definir o problema a ser resolvido",
                "Testar a solução com usuários",
                "Criar um protótipo da solução",
                "Implementar a solução final",
                "Analisar os resultados da implementação",
                "A"));

        Collections.shuffle(questions);
        //kaik
         // Adiciona ActionListener aos botões 
         for (int i = 0; i < answerButtons.length; i++) {
            final int buttonIndex = i;
            answerButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkAnswer(buttonIndex);
                }
            });
        }
    }

    public void startQuiz() {
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size() && attempts > 0) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            // Exibe apenas a pergunta no questionArea
            questionArea.setText((currentQuestionIndex + 1) + ") " + currentQuestion.questionText);

            // Define o texto dos botões com as opções
            answerButtons[0].setText("A) " + currentQuestion.optionA);
            answerButtons[1].setText("B) " + currentQuestion.optionB);
            answerButtons[2].setText("C) " + currentQuestion.optionC);
            answerButtons[3].setText("D) " + currentQuestion.optionD);
            answerButtons[4].setText("E) " + currentQuestion.optionE);

            currentQuestionIndex++;
        } else {
            showResults();
        }
    }
    private void checkAnswer(int buttonIndex) {
        if (attempts > 0) { // Verifica se ainda há tentativas
            Question currentQuestion = questions.get(currentQuestionIndex - 1); // A pergunta atual é a anterior ao índice atual
            String selectedAnswer = "";
            switch (buttonIndex) {
                case 0: selectedAnswer = "A"; break;
                case 1: selectedAnswer = "B"; break;
                case 2: selectedAnswer = "C"; break;
                case 3: selectedAnswer = "D"; break;
                case 4: selectedAnswer = "E"; break;
            }
            if (selectedAnswer.equals(currentQuestion.correctAnswer)) {
                correctAnswers++;
            } else {
                attempts--; // Diminui o número de tentativas caso erre
            }
            showNextQuestion(); // Avança para a próxima pergunta
            attemptsLabel.setText("Tentativas restantes: " + attempts); // Atualiza a label de tentativas
        } else {
            showResults(); // Se não há tentativas, mostra os resultados
        }
    }
    private void showResults() {
        questionArea.setText("Fim do Quiz! Você acertou " + correctAnswers + " de " + questions.size() + " perguntas.");
        // Remove os botões do painel
        for (JButton button : answerButtons) {
            answerPanel.remove(button); 
        }
        // Remove a label do painel
        labelPanel.remove(attemptsLabel); 
        // Remove o labelPanel do contentPane
        contentPane.remove(labelPanel);

        answerPanel.revalidate(); 
        answerPanel.repaint(); 
        contentPane.revalidate(); // Atualiza o layout do contentPane
        contentPane.repaint(); // Redesenha o contentPane
    }

    private class Question {
        private String questionText;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String optionE;
        private String correctAnswer;

        public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String optionE, String correctAnswer) {
            this.questionText = questionText;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.optionE = optionE;
            this.correctAnswer = correctAnswer;
        }
    }
}


