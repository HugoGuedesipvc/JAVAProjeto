import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class MenuUtilizador {
    static Scanner sc = new Scanner(System.in);
    static String buffer;

    static String texto;

    static boolean existe=false;
    public static int MenuV(Conta conta){
        int opc=0;
        System.out.println("User"+conta.getNome());
        System.out.println("1-alterar dados da conta");
        System.out.println("2-Menu projeto");
        System.out.println("3-Criar projeto");
        System.out.println("4-menu tarefas");
        System.out.println("5-Listar projeto");
        System.out.println("6-criar tarefas");
        System.out.println("7-listar tarefas");
        System.out.println("0-sair\n");
        opc = sc.nextInt();
        return opc;
    }

    public static void Menu(Conta conta,RepositorioContas database){
        int opc = 0;
        do {
            opc=MenuV(conta);
            switch (opc) {
                case 1 :
                    buffer = sc.nextLine();
                    Menualterardados.Dados(conta, database);
                    break;
                case 2 :
                    Projeto projeto =null;
                    buffer = sc.nextLine();
                    if (conta.verificarprojetos()) {
                        projeto = conta.VerificacaoDemenu();
                        if (projeto != null) {
                            MenuDeProjetos.projeto(conta, projeto);
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    buffer = sc.nextLine();
                    conta.criarProjeto();
                    break;
                case 4:
                    buffer = sc.nextLine();
                    Tarefa tarefa = null;
                    if (conta.verificartarefas()){
                        System.out.println("selecionar id tarefa:");
                        conta.listarTarefas();
                        texto = sc.nextLine();
                        for (Tarefa t : conta.getTarefas()) {
                            if (Objects.equals(t.getID(), texto)) {
                                tarefa = t;
                            }
                        }
                        MenuTarefas.tarefasC(conta,tarefa);
                    }
                    break;
                case 5:
                    buffer = sc.nextLine();
                    if (conta.verificarprojetos()) {
                        conta.listarProjetos();
                    }
                    break;
                case 6:
                    buffer = sc.nextLine();
                    conta.criartarefa();
                    break;
                case 7:
                    conta.listarTarefas();
                case 0:
                    break;
                default:
                    System.out.println("Opcao errada...\n");
                    break;
            }
        } while (opc != 0);
    }
}
