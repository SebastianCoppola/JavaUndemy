package com.gm.mundopc;

public class Raton extends DispositivoEntrada {
    //Attributes:
    private int idRaton;
    private static int contadorId;
    
    //Constructors:
    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idRaton = ++Raton.contadorId;
    }
    
    //toString:
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raton{");
        sb.append("idRaton: ").append(idRaton);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
