package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "pelicula.txt";
    
    public abstract void agregarPelicula(String nombrePelicula);
    
    public abstract void listarPerliculas();
    
    public abstract void buscarPerliculas(String buscar);
    
    public abstract void iniciarArchivo();
    
}
