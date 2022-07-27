package org.formacion;

import java.util.Collection;

public interface Agrupador {

	void add (Object elemento);
	
	int numeroElementos();
	
	default void addAll(Collection objetos){
		for(Object objeto : objetos) {
			add(objeto);
		}
	}
	
}
