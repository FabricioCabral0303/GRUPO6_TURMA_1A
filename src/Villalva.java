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