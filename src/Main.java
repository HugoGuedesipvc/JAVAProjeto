/**
 * The type Main.
 */
import javax.swing.*;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        System.out.println("Hello world!");
        RepositorioContas database = new RepositorioContas();
        Conta x= Login.login(database);
        System.out.println(x.getID()+" "+ x.getNome());
        database.listar();
        //MenuUtilizador.Menu(x);

    }
    }