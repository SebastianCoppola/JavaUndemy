package com.gm.mundopc;

public class Monitor {
    //Attributes:
    private int idMonitor;
    private String marca;
    private double tamano;
    private static int contadorMonitores;
    
    //Constructors:
    public Monitor(){
        this.idMonitor = ++Monitor.contadorMonitores;
    }
    public Monitor(String marca, double tamano) {
        this();
        this.marca = marca;
        this.tamano = tamano;
    }
    //Getters & Setters:
    public int getIdMonitor() {
        return this.idMonitor;
    }
    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getTamano() {
        return this.tamano;
    }
    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
    //toString:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monitor{");
        sb.append("idMonitor: ").append(idMonitor);
        sb.append(", marca: ").append(marca);
        sb.append(", tamaño: ").append(tamano);
        sb.append('}');
        return sb.toString();
    }
    
}
