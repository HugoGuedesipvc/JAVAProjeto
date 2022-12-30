/**
 * The type Main.
 */
import java.awt.List;
import java.lang.reflect.Array;
import java.util.*;
import java.text.SimpleDateFormat;
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) throws Errologin {

        System.out.println("Hello world!");

        RepositorioContas database = new RepositorioContas();
        Conta conta = null;
        int opc = 1;
        do {
            conta = Login.login(database);
            if (conta != null) {
                if (conta instanceof Admin ){
                    menuAdmin.Menu(conta, database);
                }else{
                    MenuUtilizador.Menu(conta, database);
                }
            }
        }while (opc!=0);


    }
    }