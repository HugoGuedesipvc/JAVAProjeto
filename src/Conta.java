import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.SimpleDateFormat;

public abstract class Conta {
    private static AtomicInteger nextId = new AtomicInteger(0);
    private static String getNextId() {
        return Integer.toString(nextId.incrementAndGet());
    }
    private String ID;
    private String user=null;
    private String password=null;
    private String nome=null;
    private int numeroHorasTrabalho=0;
    private List<Projeto> projetos=null;

    private List<Tarefa> tarefas=null;


    public Conta(String user,String password,String nome, int numeroHorasTrabalho){
        this.user=user;
        this.password=password;
        this.ID= getNextId();
        this.nome=nome;
        this.numeroHorasTrabalho=numeroHorasTrabalho;
        this.projetos= new ArrayList<>();
        this.tarefas= new ArrayList<>();
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

    public List<Projeto> getProjeto() {
        return projetos;
    }

    public void setProjeto(List<Projeto> projeto) {
        this.projetos = projeto;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public String tostring(){
        return "\nID da conta:"+ this.ID +"\nNome:" + this.nome + "\nUtilizador:" + this.user + "\nPassword:"+ this.password +"\nNumero de horas de trabalho:"+ this.numeroHorasTrabalho;
    }

    public void criarProjeto() {
        Projeto projeto = new Projeto(null,null,0);
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNome do Projeto=");
        projeto.setNome(sc.nextLine());
        System.out.print("\nNome do cliente=");
        projeto.setNomeCliente(sc.nextLine());
        System.out.print("\nNumero de horas=");
        projeto.setPrecoHora(sc.nextInt());
        adicionarProjeto(projeto);
    }

    public void adicionarProjeto(Projeto projeto){
        boolean existe=false;
        for(Projeto p : projetos)
            if(Objects.equals(p.getNome(), projeto.getNome()))
                existe = true;

        if(!existe)
            this.projetos.add(projeto);//verificar se necessario usar Serializable
        else
            System.out.println("erro ID");//fazer expection
    }
    public void listarProjetos(){
        for (Projeto p :projetos) {
            System.out.println(p.getID()+ " "+ p.getNome());
        }
    }

    public Projeto VerificacaoDemenu(){
        Projeto projeto =null;
        boolean existe=false;
        Scanner sc = new Scanner(System.in);
        System.out.println("selecionar id projeto:");
        listarProjetos();
        String id = sc.nextLine();
        for(Projeto p : getProjeto()){
            if (p.getID().equals(id)){
                existe=true;
                projeto = p;
            }
        }if (existe) {
            return projeto;
        }
        else{
            System.out.println("Erro id nao encontrado");
            return null;
        }
    }


    public void eleminarProjeto(Projeto y){
        projetos.remove(y);
    }

    public void adicionartarefa(Tarefa tarefa){
        boolean existe=false;
        for(Tarefa t : tarefas)
            if(t.getID().equals(tarefa.getID()))
                existe = true;

        if(!existe)
            this.tarefas.add(tarefa);//verificar se necessario usar Serializable
        else
            System.out.println("erro ID");//fazer expection
    }

    public void listarTarefas(){
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for (Tarefa t :tarefas) {
            if (t.getDataF()==null){
                System.out.println(t.getID() + t.getDescricao() + (formatter.format(t.getDataI())) + t.listarcomtempo());
            }else {
            System.out.println(t.getID() + t.getDescricao() + (formatter.format(t.getDataI())) + (formatter.format(t.getDataF())));
            }
        }
    }

    public void eleminarTarefa(Tarefa y){
        tarefas.remove(y);
    }

    public Boolean verificarprojetos() {
        Projeto test = null;
        if (projetos.isEmpty()) {
            System.out.println("Nehum projeto em curso");
            return false;
        }
        return true;
    }

    public void criartarefa() {

        Calendar cal = Calendar.getInstance();
        Date dataI = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        System.out.print("\ndescrição da Tarefa=");
        String Dtarefa = sc.nextLine();
        System.out.print("\nInserir Data de inicio ? ");
        System.out.print("\nsim ou nao");
        String text = sc.nextLine();
        if (Objects.equals(text, "sim")){
            System.out.print("\ninserir data tipo yyyy/MM/dd HH:mm  =");
            System.out.println("\nano:");
            int ano = sc.nextInt();
            System.out.println("\nmes:");
            int mes = sc.nextInt();
            System.out.println("\ndia:");
            int dia = sc.nextInt();
            System.out.println("\nhora:");
            int hora = sc.nextInt();
            System.out.println("\nminuto:");
            int minuto = sc.nextInt();
            cal.set(ano,mes,dia,hora,minuto);
            dataI = cal.getTime();
        }
        System.out.print("\nInserir Preço hora");
        int preco = sc.nextInt();
        Tarefa tarefa = new Tarefa(Dtarefa,dataI,null,preco);
        adicionartarefa(tarefa);
        System.out.println("tarefa criada");
        listarTarefas();
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



