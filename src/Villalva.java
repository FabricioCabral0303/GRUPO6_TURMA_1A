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