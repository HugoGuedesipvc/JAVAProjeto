import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    public static Conta login(RepositorioContas database) {
        int opc;
        Conta admin = new SuperAdmin();
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
            System.out.println("Erro ao introduzir dados\n" + "tentar outra vez 2\n" + "Criar conta=1\n"+"Sair =0");
            opc = sc.nextInt();
            String s= sc.nextLine();
            if(opc==1){
                Criarconta.criarconta(database);
                opc=2;
            }
        } while (opc != 0);
        return null;
    }

}

