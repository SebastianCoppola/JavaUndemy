package test;
import clases.*;
 
public class Test {
    public static void main(String[] args) {
        //empleado1
        Empleado empleado1 = new Empleado("Juan","Perez",5300,"Marketing");
        System.out.println("empleado1 = " + empleado1);
        //empleado2
        Empleado empleado2 = new Empleado("Marcelo","Gonzalez",4500,"Marketing");
        System.out.println("empleado2 = " + empleado2);
        //cliente1
        Cliente cliente1 = new Cliente("Marco","Antonio",true);
        System.out.println("cliente1 = " + cliente1);
        //cliente2
        Cliente cliente2 = new Cliente("Klara","Kava",true);
        System.out.println("cliente2 = " + cliente2);
        
        int numeros[] = {1,2,3};
        for( int i = 0 ; i < numeros.length ; i++ ){
            System.out.println("numero " + i + " = " + numeros[i]);
        }
        
    }
}
