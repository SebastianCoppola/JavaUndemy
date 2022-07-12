package mx.com.gm.peliculas.domain;

public class Pelicula {
    //ATTRIBUTES:
    private String nombre;
    
    //CONSTRUCTOR:
    public Pelicula(){};
    public Pelicula(String nombre){
        this.nombre = nombre;
    }
    
    //GETTERS & SETTERS:
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //toString:
    @Override
    public String toString() {
        return this.nombre;
    }
}
