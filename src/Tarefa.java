import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Tarefa {

    private static AtomicInteger nextId = new AtomicInteger(0);
    private static String getNextId() {
        return Integer.toString(nextId.incrementAndGet());
    }

    private  static SimpleDateFormat obj=new SimpleDateFormat("MM-dd-yyyy HH:mm");

    private String ID;
    private  String descricao;
    private Date dataI;
    private Date dataF;
    //private int estado;

    private int precohora;

    public Tarefa(String descricao, Date dataI,Date dataF,int precohora) {
        this.descricao=descricao;
        this.dataI=dataI;
        this.dataF=dataF;
        this.ID=getNextId();
        this.precohora=precohora;
    }


    public int getPrecohora() {
        return precohora;
    }

    public void setPrecohora(int precohora) {
        this.precohora = precohora;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataI() {
        return dataI;
    }

    public void setData(Date data) {
        this.dataI = data;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }

    public void tostring() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (this.dataF == null) {
            System.out.println(this.ID + this.descricao + (formatter.format(this.dataI)) + "data final por selecionar");
        } else {
            System.out.println(this.ID + this.descricao + (formatter.format(this.dataI)) + (formatter.format(this.dataF)));
        }

    }

    public void terminartarefa() {

        Calendar cal = Calendar.getInstance();
        Date dataF = new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner sc = new Scanner(System.in);
        System.out.print("\nFinalizar tarefa: ");
        System.out.print("\ninserir data?");
        String text = sc.nextLine();
        if (Objects.equals(text, "sim")){
            System.out.print("\ninserir data de data =");
            System.out.print("\ninserir data tipo yyyy/MM/dd HH:mm");
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
            dataF = cal.getTime();
        }
        this.dataF=dataF;
        System.out.println("tarefa terminada");
    }

    public String listarcomtempo(){
        if (this.dataF == null) {
            Date data = new Date();
            long time_difference = data.getTime() - this.dataI.getTime();
            long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
            long years_difference = (time_difference / (1000l * 60 * 60 * 24 * 365));
            long minutes_difference = (time_difference / (1000 * 60)) % 60;
            long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
            return(hours_difference + "horas," + minutes_difference + "minutos,"
                    + years_difference + "anos," + days_difference + "dias gasto na tarefa");
        }
        return("Tarefa ja finalizada");
    }

}
