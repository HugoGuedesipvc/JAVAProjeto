/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Conta teste = new Utilizador("hugo","guedes");
        RepositorioContas data = new RepositorioContas();
        data.registarConta(teste);
    }
}