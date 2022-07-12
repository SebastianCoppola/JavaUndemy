package mx.com.gm.peliculas.datos;

import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    
    public abstract boolean existe(String nombreRecurso) throws AccesoDatosEx;
    
    public abstract List<Pelicula> listar(String nombre) throws LecturaDatosEx;
    
    public abstract void escribir(Pelicula pelicula, String nombre, boolean anexar) throws EscrituraDatosEx;
    
    public abstract String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    
    public abstract void crear(String nombreRecurso) throws AccesoDatosEx;
    
    public abstract void borrar(String nombreRecurso) throws AccesoDatosEx;
    
}
