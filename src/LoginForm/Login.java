package LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JDialog{
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JPanel loginPanel;

    public Login(JFrame login){
        super(login);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(login);
        setContentPane(loginPanel);
    }
}
