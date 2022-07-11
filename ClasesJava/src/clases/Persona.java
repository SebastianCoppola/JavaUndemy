package clases;

public class Persona {
    //atributos
    protected int id;
    protected String name;
    protected String lastName;
    protected static int counterId; 
    
    //getters & setters    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }
    
    //constructores
    public Persona(){
    }
    public Persona(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    
    //toString
    @Override
    public String toString() {
        return "Persona[name: " + this.name + ", lastname: " + lastName + ']';
    }
}
