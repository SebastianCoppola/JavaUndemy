package com.gm.mundopc;

public class Teclado extends DispositivoEntrada{
    //Attributes:
    private int idTeclado;
    private static int contadorId;
    
    //Constructors:
    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++Teclado.contadorId;
    }
    
    //toString:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teclado{");
        sb.append("idTeclado: ").append(idTeclado);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
