import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    public static Conta login(RepositorioContas database) {
        int opc;
        Conta admin = new Admin();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nIntroduzir dados:");
            System.out.print("Utilizador=");
            String username = sc.nextLine();
            System.out.print("Password=");
            String password = sc.nextLine();
                if (username.equals("HT") && password.equals("HT")) {
                    return admin;
                }
                for (Conta c : database.getContas()) {
                if (username.equals(c.getUser()) && password.equals(c.getPassword())) {
                    return c;
                }

                }
                System.out.println("tentar outra vez=1\n" +"Sair=0\n");
                opc = sc.nextInt();
                String s= sc.nextLine();
        } while (opc != 0);
            return null;
    }

}

