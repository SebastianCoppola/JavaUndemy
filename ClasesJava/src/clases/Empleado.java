package clases;

public class Empleado extends Persona {
    private int id;
    private static int counterId;
    private double salary; 
    private String area; 

    //Getters & Setters
    public int getId(){
        return this.id;
    }
    public double getSalary() {
        return this.salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    //Constructor
    public Empleado() {
        this.id = ++Empleado.counterId;
    }
    public Empleado(String name, String lastName, double salary, String area) {
        //super(name,lastName);
        this();
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.area = area; 
    }
    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado[");
        sb.append(super.toString());
        sb.append(", id: ").append(this.id);
        sb.append(", salary: ").append(this.salary);
        sb.append(", area: ").append(this.area);
        sb.append(']');
        return sb.toString();
    }
}
