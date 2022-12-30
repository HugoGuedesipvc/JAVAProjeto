import java.util.concurrent.atomic.AtomicInteger;

public abstract class Conta {
    private static AtomicInteger nextId = new AtomicInteger(0);
    private static String getNextId() {
        return Integer.toString(nextId.incrementAndGet());
    }
    String ID;
    String user=null;
    String password=null;
    String nome=null;
    int numeroHorasTrabalho=0;

    int key =0;

    public Conta(String user,String password,String nome, int numeroHorasTrabalho){
        this.user=user;
        this.password=password;
        this.ID= getNextId();
        this.nome=nome;
        this.numeroHorasTrabalho=numeroHorasTrabalho;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroHorasTrabalho() {
        return numeroHorasTrabalho;
    }

    public void setNumeroHorasTrabalho(int numeroHorasTrabalho) {
        this.numeroHorasTrabalho = numeroHorasTrabalho;
    }

    public String getID() {
        return ID;
    }

    public void alterarnome(String nome){

    }

    public void criarProjeto(String nome){}

}
