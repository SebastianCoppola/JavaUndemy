package com.gm.mundopc;

public class Orden {
    //Attributes:
    private int idOrden;
    private Computadora computadoras[];
    private static int contadorOrden;
    private int contadorComputadora;
    private static final int MAX_COMPUTADORAS = 5;
    
    //Constructors:
    public Orden(){
        this.idOrden = ++Orden.contadorOrden;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    //Methods:
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadora < Orden.MAX_COMPUTADORAS){
            computadoras[contadorComputadora++] = computadora; 
        }else{
            System.out.println("Máximo de " + Orden.MAX_COMPUTADORAS + " computadoras alcanzado.");
        }
    }
    public void mostrarOrder(){
        System.out.println("Id: " + this.idOrden);
        System.out.println("Products: ");
        for (int i = 0; i < this.contadorComputadora; i++) {
            System.out.println(this.computadoras[i]);
        }
    }
}
