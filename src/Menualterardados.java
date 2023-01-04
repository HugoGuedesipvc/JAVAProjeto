import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Menualterardados {

    static Scanner sc = new Scanner(System.in);
    static String t;
    static int opc = 0;
    public static int MenuDados(Conta x){
        System.out.println(x.tostring());
        System.out.println("1-alterar nome");
        System.out.println("2-alterar user");
        System.out.println("3-alterar password");
        System.out.println("4-alterar numero de horas de trabalho");
        System.out.println("0-sair\n");
        opc = sc.nextInt();
        return opc;
    }

    public static Conta Dados(Conta x,RepositorioContas database){
        System.out.print("Password=");
        String text = sc.nextLine();
        if (Objects.equals(text, x.getPassword())){
            do {
                opc=MenuDados(x);
                    switch (opc) {
                        case 1 :
                            t=sc.nextLine();
                            System.out.println("\nIntroduir nome para alterar:");
                            text =sc.nextLine();
                            x.setNome(text);
                            break;
                        case 2:
                            t=sc.nextLine();
                            System.out.println("\nIntroduir utilizador para alterar:");
                            text=sc.nextLine();
                            x.setUser(text);
                            break;
                        case 3:
                            t=sc.nextLine();
                            System.out.println("\nIntroduir palavra chave para alterar:");
                            text =sc.nextLine();
                            x.setPassword(text);
                            break;
                        case 4:
                            t=sc.nextLine();
                            System.out.println("\nIntroduir numero para alterar:");
                            int numero =sc.nextInt();
                            x.setNumeroHorasTrabalho(numero);
                            break;
                        case 0:
                            t=sc.nextLine();
                            break;
                        default:
                            System.out.println("Opcao errada...\n");
                            break;
                                }
                } while (opc != 0);
                     for (Conta c : database.getContas()) {
                    if (c.getID()==x.getID()) {
                        c=x;
                    }

                 }

            }
        return x;
        }
    }

