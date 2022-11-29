public abstract class Conta {

    int ID=0;
    String user;
    String password;

    public Conta(String user,String password){
        this.user=user;
        this.password=password;
        this.ID++;
    }

    public int getID() {
        return ID;
    }

}
