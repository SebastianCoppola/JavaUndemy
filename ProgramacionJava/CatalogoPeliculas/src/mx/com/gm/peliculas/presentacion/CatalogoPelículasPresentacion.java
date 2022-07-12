package mx.com.gm.peliculas.presentacion;
import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CatalogoPelículasPresentacion {
    public static void main(String[] args) {
        
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        while(opcion != 0){
            
            System.out.println("Elige una opción: \n"
                + "1. Iniciar catálogo peliculas\n"
                + "2. Agregar pelicula\n"
                + "3. Listar peliculas\n"
                + "4. Buscar película\n"
                + "0. Salir\n");
            opcion = Integer.parseInt(scanner.nextLine());
                        
            switch(opcion){
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Intoduce el nombre de la película");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPerliculas();
                    break;
                case 4:
                    System.out.println("Introduce una pelicula a buscar:");
                    var buscar = scanner.nextLine();
                    catalogo.buscarPerliculas(buscar);
                    break;
                case 0:
                    System.out.println("Hasta Pronto!");
                    break;
                default:
                    System.out.println("Opción no encontrada");
                    break;  
            }
        }        
    }
}
