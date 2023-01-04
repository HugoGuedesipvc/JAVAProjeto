import java.util.Objects;
import java.util.Scanner;

public class MenuTarefas {

    static Scanner sc = new Scanner(System.in);
    static String buffer;
    static String texto;
    static int opc = 0;

    static Tarefa test = null;
    public static int MenuTarefas(Tarefa tarefa){
        System.out.println(tarefa.getID());
        System.out.println("1-eleminar tarefas");
        System.out.println("2-Listar tarefa");
        System.out.println("3-terminar tarefas");
        System.out.println("0-sair\n");
        opc = sc.nextInt();
        return opc;
    }

    public static void tarefasC(Conta conta,Tarefa tarefa){

        do {
            opc=MenuTarefas(tarefa);
            switch (opc) {
                case 1:
                    buffer = sc.nextLine();
                    System.out.println("\n Tarefa selecionado: " +  tarefa.toString());
                    System.out.println("\n sim para confirmar");
                    texto=sc.nextLine();
                    if (Objects.equals(texto, "sim")) {
                        conta.eleminarTarefa(tarefa);
                        return;
                    }
                    break;
                case 2:
                    buffer = sc.nextLine();
                    tarefa.tostring();
                    break;
                case 3:
                    buffer = sc.nextLine();
                    tarefa.terminartarefa();
                    break;
                case 0:
                    buffer=sc.nextLine();
                    break;
                default:
                    System.out.println("Opcao errada...\n");
                    break;
            }
        } while (opc != 0);
    }

    public static void tarefasP(Projeto projeto,Tarefa tarefa){

        do {
            opc=MenuTarefas(tarefa);
            switch (opc) {
                case 1:
                    buffer = sc.nextLine();
                    System.out.println("\n Tarefa selecionado: " +  tarefa.toString());
                    System.out.println("\n sim para confirmar");
                    texto=sc.nextLine();
                    if (Objects.equals(texto, "sim")) {
                        projeto.eleminarTarefa(tarefa);
                        return;
                    }
                    break;
                case 2:
                    buffer = sc.nextLine();
                    tarefa.tostring();
                    break;
                case 3:
                    buffer = sc.nextLine();
                    tarefa.terminartarefa();
                    break;
                case 0:
                    buffer=sc.nextLine();
                    break;
                default:
                    System.out.println("Opcao errada...\n");
                    break;
            }
        } while (opc != 0);
    }

}
