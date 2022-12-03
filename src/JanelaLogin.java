import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaLogin extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    JanelaLogin() {
        //chamar metodos dentro do construtor
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
    }

    public void setLayoutManager()
    {
        container.setLayout(null);//definir o layout manager do Container como null
    }
    public void addComponentsToContainer()
    {
        //Adding each components to the Container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void setLocationAndSize() {
        //Setting location and Size of each components using setBounds() method.
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public class Login {
        public static void main(String[] args) {
            //Creating object of LoginFrame class and setting some of its properties
            JanelaLogin f = new JanelaLogin();// cria a janela mas invisivel
            f.setTitle("Login");//Titulo da janela
            f.setVisible(true);// fazer a janela visivel
            //f.setSize(275,400);//definir o tamanho da janela
            //f.setLocation(500,170);//definir a posição da janela nos eixos x,y do ecrã
            f.setBounds(10,10,370,600);
            f.setResizable(false);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**
             * metodo elegido para fechar a janela:
             * * JFrame.DISPOSE_ON_CLOSE - descarta a moldura quando alguém clica no Botão Fechar, mas a aplicação permanece em funcionamento.
             * JFrame.DO_NOTHING_ON_CLOSE - nada acontece quando alguém clica no Botão Fechar.
             * JFrame.HIDE_ON_CLOSE - esconde a moldura quando alguém clica no Botão Fechar, mas a aplicação permanece em funcionamento.
             * JFrame.EXIT_ON_CLOSE - sai da aplicação quando alguém clica no Botão Fechar e remove o programa da memória permanentemente.
             */
        }
    }
}