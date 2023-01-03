import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SigninForm extends JDialog {
    private JPanel SigninPanel;
    private JButton criarContaButton;
    private JPasswordField tfPassword;
    private JTextField tfUsername;
    private JTextField textField1;

    RepositorioContas database = new RepositorioContas();
    public SigninForm(JFrame signin) {
        super(signin);
        setTitle("Signin");
        setContentPane(SigninPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(300, 250));
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(signin);
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginForm loginForm = new LoginForm(null);
                loginForm.setVisible(true);
                setVisible(false);
            }
        });
    }
    public static void main(String[] args) {
        SigninForm SigninForm = new SigninForm(null);
    }
}
