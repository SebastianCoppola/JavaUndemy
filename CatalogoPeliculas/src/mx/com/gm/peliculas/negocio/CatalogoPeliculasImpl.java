package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.excepciones.*;
import mx.com.gm.peliculas.domain.Pelicula;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos; 
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos: " + e);
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPerliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            peliculas.forEach(pelicula ->{
                System.out.println(pelicula);
            });
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos: " + e );
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPerliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        }catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos: " + e );
            e.printStackTrace(System.out);
        }
        System.out.println(resultado);
    }

    @Override
    public void iniciarArchivo() {
        try {
            if(this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
        }catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catálogo de películas: " + e );
            e.printStackTrace(System.out);
        }        
        
        
            
    }
    
}
