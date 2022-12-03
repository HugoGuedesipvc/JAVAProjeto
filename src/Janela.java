import java.awt.*;
import javax.swing.*;
public class Janela {
    public static void main(String args[] )
    {
        JFrame f= new JFrame();
        f.setTitle("Janela");
        f.setVisible(true);
        f.setSize(275,400);//definir o tamanho da janela
        f.setLocation(500,170);//definir a posição da janela nos eixos x,y do ecrã
        //f.setBounds(10,10,370,600);
        Container c= f.getContentPane();
        f.setResizable(false);//restricting the user to resize the window
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/**
     * metodo elegido para fechar a janela:
     * * JFrame.DISPOSE_ON_CLOSE - descarta a moldura quando alguém clica no Botão Fechar, mas a aplicação permanece em funcionamento.
     * JFrame.DO_NOTHING_ON_CLOSE - nada acontece quando alguém clica no Botão Fechar.
     * JFrame.HIDE_ON_CLOSE - esconde a moldura quando alguém clica no Botão Fechar, mas a aplicação permanece em funcionamento.
     * JFrame.EXIT_ON_CLOSE - sai da aplicação quando alguém clica no Botão Fechar e remove o programa da memória permanentemente.
     */
    }
}