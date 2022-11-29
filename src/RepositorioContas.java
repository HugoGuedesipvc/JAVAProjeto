import java.util.ArrayList;
import java.util.List;

public class RepositorioContas {
    private List<Conta> contas;

    public RepositorioContas(){
        this.contas = new ArrayList<>();
    }

    public void registarConta(Conta conta){
        boolean existe=false;
        for(Conta c : contas)
            if(c.getID() == conta.getID())
                existe = true;

        if(!existe)
            this.contas.add(conta);//verificar se necessario usar Serializable
        else
            System.out.println("erro ID");//fazer expection
    }

}
