package mundopc;
import com.gm.mundopc.*;

public class MundoPC {
    public static void main(String[] args) {
        
        //CREO COMPU 1
        Teclado teclado1 = new Teclado("USB","Genius");
        Raton raton1 = new Raton("USB","Genius");
        Monitor monitor1 = new Monitor("LG",25.7);
        Computadora compu1 = new Computadora("Lenovo",monitor1,teclado1,raton1);
        
        //CREO COMPU 2
        Monitor monitor2 = new Monitor("Samsung",35.2);
        Computadora compu2 = new Computadora("Lenovo",monitor2,teclado1,raton1);
        
        //CREO ORDEN 1
        Orden orden1 = new Orden();
        orden1.agregarComputadora(compu1);
        orden1.agregarComputadora(compu2);
        orden1.mostrarOrder();
    }
}
