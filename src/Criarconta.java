import java.util.Scanner;

public class Criarconta {

    public static void criarconta(RepositorioContas database){
        int opc;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Utilizador=");
            String username = sc.nextLine();
            System.out.print("Password=");
            String password = sc.nextLine();
            System.out.print("Nome=");
            String nome = sc.nextLine();
            System.out.print("N=");
            int numero = sc.nextInt();
            Conta a1 = new Utilizador(username, password, nome, numero);
            database.registarConta(a1);
            System.out.println("Voltar ao menu 0\n criar outra conta 1");
            opc = sc.nextInt();
        } while (opc != 0);
    }
}
