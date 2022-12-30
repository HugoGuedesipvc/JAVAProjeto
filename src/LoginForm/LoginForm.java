package LoginForm;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JDialog{
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton loginButton;
    private JPanel loginPanel;

    public LoginForm(JFrame login){
        super(login);
        setTitle("Login");
        setContentPane(loginPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(login);
    }
        public static void main(String[] args) {
            LoginForm loginForm = new LoginForm(null);
        }
}
