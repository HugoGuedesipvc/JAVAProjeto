import java.util.Objects;
import java.util.Scanner;

public class MenuDeProjetos {

    static Scanner sc = new Scanner(System.in);
    static String buffer;
    static String texto;
    static int opc = 0;

    static Tarefa tarefa = null;

    public static int MenuProjeto(Conta conta,Projeto projeto){
        System.out.println(conta.getNome());
        System.out.println(projeto.getNome() + "\n" + projeto.getNomeCliente() + "\n" + projeto.getPrecoHora());
        System.out.println("1-alterar nome do projeto");
        System.out.println("2-alterar nome do Cliente");
        System.out.println("3-alterar Preço por hora");
        System.out.println("4-Eliminar Projeto");
        System.out.println("5-Associar tarefas");
        System.out.println("6-Listar tarefas no projeto");
        System.out.println("7-Selecionar  tarefa ");
        System.out.println("0-sair\n");
        opc = sc.nextInt();
        return opc;
    }

    public static void projeto(Conta conta,Projeto projeto){

            do {
                opc=MenuProjeto(conta,projeto);
                switch (opc) {
                    case 1 :
                        buffer=sc.nextLine();
                        System.out.println("\nIntroduir nome do projeto para alterar:");
                        texto=sc.nextLine();
                        projeto.setNome(texto);
                        break;
                    case 2:
                        buffer=sc.nextLine();
                        System.out.println("\nIntroduir Nome do cliente para alterar:");
                        texto=sc.nextLine();
                        projeto.setNomeCliente(texto);
                        break;
                    case 3:
                        buffer=sc.nextLine();
                        System.out.println("\nIntroduir numero de horas para alterar:");
                        int number =sc.nextInt();
                        projeto.setPrecoHora(number);
                        break;
                    case 4:
                        buffer=sc.nextLine();
                        System.out.println("\nIntroduir nome do projeto para eliminar:");
                        System.out.println("\n nome do projeto selecionado: " +  projeto.getNome());
                        texto=sc.nextLine();
                        if (Objects.equals(projeto.getNome(), texto))
                        {
                            conta.eleminarProjeto(projeto);
                            return;
                        }else
                        {
                        System.out.println("Erro na verificação");
                        break;
                        }
                    case 5:
                        buffer=sc.nextLine();
                        if (conta.verificartarefas()) {
                            System.out.println("selecionar id tarefa:");
                            conta.listarTarefas();
                            texto = sc.nextLine();
                            for (Tarefa t : conta.getTarefas()) {
                                if (Objects.equals(t.getID(), texto)) {
                                    projeto.criartarefa(t);
                                }
                            }
                        }
                        break;
                    case 6:
                        buffer=sc.nextLine();
                        if (projeto.verificartarefas()) {
                            projeto.listarTarefas();
                        }
                        break;
                    case 7:
                        buffer=sc.nextLine();
                        if(projeto.verificartarefas()) {
                            System.out.println("selecionar id tarefa:");
                            projeto.listarTarefas();
                            texto = sc.nextLine();
                            for (Tarefa t : projeto.getTarefas()) {
                                if (Objects.equals(t.getID(), texto)) {
                                    tarefa = t;
                                }
                            }
                            MenuTarefas.tarefasP(projeto,tarefa);
                        }
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


