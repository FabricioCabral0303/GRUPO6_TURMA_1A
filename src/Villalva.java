import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Villalva {

    private static JFrame mainFrame;
    private static JPanel contentPane;
    private static JTextField inputField;

    public static void main(String[] args) {
        mainFrame = new JFrame("Os diamantes de Villlva");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280, 960);
        mainFrame.setLocationRelativeTo(null);

        Color backgroundColor = new Color(0x126BD1);
        Color inputFieldColor = new Color(0x004080); // Azul mais escuro
        Color textColor = Color.ORANGE; // Cor do texto

        contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(backgroundColor);

        createInitialScreen(inputFieldColor, textColor);

        mainFrame.setContentPane(contentPane);
        mainFrame.setVisible(true);
    }
    // Cria a tela inicial com os botões e imagem
    private static void createInitialScreen(Color inputFieldColor, Color textColor) {
        int buttonWidth = 200;
        int buttonHeight = 50;

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        buttonPanel.setBackground(new Color(0x126BD1));

        JButton jogarButton = createButton("[1] JOGAR", buttonWidth, buttonHeight, textColor);
        JButton instrucoesButton = createButton("[2] INSTRUÇÕES", buttonWidth, buttonHeight, textColor);
        JButton creditosButton = createButton("[3] CRÉDITOS", buttonWidth, buttonHeight, textColor);
        JButton sairButton = createButton("[4] SAIR", buttonWidth, buttonHeight, textColor);

        buttonPanel.add(jogarButton);
        buttonPanel.add(instrucoesButton);
        buttonPanel.add(creditosButton);
        buttonPanel.add(sairButton);

        JPanel spacePanel = new JPanel();
        spacePanel.setBackground(new Color(0x126BD1));
        spacePanel.setPreferredSize(new Dimension(1, 800));

        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(new Color(0x126BD1));

        mainPanel.add(spacePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(spacePanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);
         // Cria o campo de entrada de texto
         inputField = new JTextField();
         inputField.setPreferredSize(new Dimension(100, 30));
         inputField.setBackground(inputFieldColor);
         inputField.setForeground(textColor);
         inputField.setHorizontalAlignment(JTextField.CENTER);
         inputField.setBorder(BorderFactory.createEmptyBorder()); // Remove a borda
         inputField.setFont(new Font("Arial", Font.PLAIN, 20)); // Define a fonte para o inputField
         inputField.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {}
 
             @Override
             public void keyPressed(KeyEvent e) {}
 
             @Override
             public void keyReleased(KeyEvent e) {
                 if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                     processInput();
                 }
             }
         });
         
        // Cria um painel para o campo de entrada
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBackground(new Color(0x126BD1));
        inputPanel.add(inputField);

        contentPane.add(inputPanel, BorderLayout.SOUTH);

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

    // Cria um botão com estilo e dimensões definidas
    private static JButton createButton(String text, int width, int height, Color textColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setForeground(textColor);
        button.setBackground(new Color(0x126BD1));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFocusPainted(false);
        return button;
    }

    // Processa a entrada do usuário no campo de texto
    private static void processInput() {
        String input = inputField.getText();
        inputField.setText(""); // Limpa o campo de texto

        switch (input) {
            case "1":
                startQuiz();
                break;
            case "2":
                showInstructions();
                break;
            case "3":
                showCredits();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                // Exibe uma mensagem de erro
                JOptionPane.showMessageDialog(mainFrame, "Entrada inválida. Digite 1, 2, 3 ou 4.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }