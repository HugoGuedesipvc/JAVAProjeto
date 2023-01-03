import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JDialog{
    private JPasswordField tfPassword;
    private JTextField tfUsername;
    private JButton loginButton;
    private JPanel loginPanel;

    RepositorioContas database = new RepositorioContas();
    public LoginForm(JFrame login){
        super(login);
        setTitle("Login");
        setContentPane(loginPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(login);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                String password = String.valueOf(tfPassword.getPassword());

                conta = getAuthenticatedUser(username, password);

                if (conta != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public Conta conta;
    private Conta getAuthenticatedUser(String username, String password) {
        Conta Admin = new Admin();
        database.registarConta(Admin);

        for(Conta c: database.getContas()) {
            if (username.equals(c.getUser()) && password.equals(c.getPassword())) {
                return c;
            }
        }
        return null;
    }

        public static void main(String[] args) {
            LoginForm loginForm = new LoginForm(null);
        }
}
