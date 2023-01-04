import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Projeto {

    private static AtomicInteger nextId = new AtomicInteger(0);
    private static String getNextId() {
        return Integer.toString(nextId.incrementAndGet());
    }

    private String ID;
    private String nome;
    private String nomeCliente;
    private int precoHora;

    private List<Tarefa> tarefas=null;

    public Projeto(String nome,String nomeCliente,int precoHora){
        this.nome=nome;
        this.nomeCliente=nomeCliente;
        this.precoHora=precoHora;
        this.ID= getNextId();
        this.tarefas= new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(int precoHora) {
        this.precoHora = precoHora;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }



    public void criartarefa(Tarefa x){
        boolean existe=false;
        for(Tarefa t : tarefas)
            if(t.getID().equals(x.getID()))
                existe = false;

        if(!existe)
            this.tarefas.add(x);//verificar se necessario usar Serializable
        else
            System.out.println("erro ID");//fazer expection
    }

    public void listarTarefas(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Tarefa t :tarefas) {
            if (t.getDataF()==null){
                System.out.println(t.getID() + t.getDescricao() + t.getDataI() + "data final por selecionar");
            }else {
                System.out.println(t.getID() + t.getDescricao() + t.getDataI() + t.getDataF());
            }
        }
    }

    public void eleminarTarefa(Tarefa y){
        tarefas.remove(y);
    }

    public Boolean verificartarefas() {
        Projeto test = null;
        if (tarefas.isEmpty()) {
            System.out.println("Nehuma tarefa em curso");
            return false;
        }
        return true;
    }


}
