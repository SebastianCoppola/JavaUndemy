package com.gm.mundopc;

public class DispositivoEntrada {
    //Attributes:
    protected String tipoEntrada;
    protected String marca;
    
    //Constructors:
    public DispositivoEntrada(String tipoEntrada, String marca) {
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }
        
    //Getters & Setters:
    public String getTipoEntrada() {
        return this.tipoEntrada;
    }
    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }
    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    //toString:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DispositivoEntrada{");
        sb.append("tipoEntrada: ").append(tipoEntrada);
        sb.append(", marca: ").append(marca);
        sb.append('}');
        return sb.toString();
    }
}
