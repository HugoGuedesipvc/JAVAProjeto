import java.util.Objects;
import java.util.Scanner;

public class menuAdmin {
    static Scanner sc = new Scanner(System.in);
    static String buffer;

    static String texto;

    static boolean existe=false;
    public static int MenuA(Conta conta){
        int opc=0;
        System.out.println("User"+conta.getNome());
        System.out.println("1-criar conta");
        System.out.println("2-listar contas");
        System.out.println("3-Login com conta de user");
        System.out.println("0-sair\n");
        opc = sc.nextInt();
        return opc;
    }

    public static void Menu(Conta conta,RepositorioContas database){
        int opc = 0;
        do {
            opc=MenuA(conta);
            switch (opc) {
                case 1 :
                    buffer = sc.nextLine();
                    Criarconta.criarconta(database);
                    break;
                case 2 :
                    buffer = sc.nextLine();
                    database.listarContas();
                    break;
                case 3:
                    buffer = sc.nextLine();
                    System.out.println("selecionar id do user:");
                    database.listarContas();
                    texto = sc.nextLine();
                    for (Conta c : database.getContas()) {
                        if (Objects.equals(c.getID(), texto)) {
                            MenuUtilizador.Menu(c,database);
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao errada...\n");
                    break;
            }
        } while (opc != 0);
    }
}
