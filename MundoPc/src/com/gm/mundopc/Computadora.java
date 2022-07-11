package com.gm.mundopc;

public class Computadora {
    //Attributes:
    private int idComputadora;
    private static int contadorId;
    private String nombre;
    private Monitor monitor; 
    private Teclado teclado;
    private Raton raton;

    //Constructors:
    public Computadora(){
        this.idComputadora = ++Computadora.contadorId;
    }
    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton) {
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }
    
    //Getters & Setters:
    public int getIdComputadora() {
        return this.idComputadora;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Monitor getMonitor() {
        return this.monitor;
    }
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
    public Teclado getTeclado() {
        return this.teclado;
    }
    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }
    public Raton getRaton() {
        return this.raton;
    }
    public void setRaton(Raton raton) {
        this.raton = raton;
    }
    
    //toString:

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computadora{");
        sb.append("idComputadora: ").append(idComputadora);
        sb.append(", nombre: ").append(nombre);
        sb.append(", monitor: ").append(monitor);
        sb.append(", teclado: ").append(teclado);
        sb.append(", raton: ").append(raton);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
