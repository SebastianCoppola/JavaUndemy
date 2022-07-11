package clases;
import java.util.Date;

public class Cliente extends Persona{
    private int id;
    private static int counterId;
    private Date registerDate;
    private boolean vip; 

    //getters & setters
    public boolean isVip() {
        return vip;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public Date getRegisterDate(){
        return this.registerDate;
    }
    
    //constructor: 
    public Cliente(){
        this.id = ++Cliente.counterId;
    }
    public Cliente(String name, String lastName, boolean vip) {
        this();
        this.name = name;
        this.lastName = lastName;
        Date date = new Date();
        this.registerDate = date;
        this.vip = vip;

    }
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente[");
        sb.append(super.toString());
        sb.append(", id: ").append(id);
        sb.append(", registerDate: ").append(registerDate);
        sb.append(", vip:").append(vip);
        sb.append(']');
        return sb.toString();
    }
    
    
    
}
