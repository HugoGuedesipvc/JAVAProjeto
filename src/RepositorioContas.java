import java.util.ArrayList;
import java.util.List;

public class RepositorioContas {
    private List<Conta> contas;

    public RepositorioContas(){
        this.contas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }
    public void listar(){
        for (Conta c :contas)
        {
            System.out.println(c.getNome()+c.getID());
        }
    }
    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void registarConta(Conta conta){
        boolean existe=false;
        for(Conta c : contas)
            if(c.getID() == conta.getID())
                existe = false;

        if(!existe)
            this.contas.add(conta);//verificar se necessario usar Serializable
        else
            System.out.println("erro ID");//fazer expection
    }

}
