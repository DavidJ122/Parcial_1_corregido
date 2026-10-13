 package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Busca un paquete por su código mediante el algoritmo de divide y vencerás.
public class BusquedaCodigo {

    // Lista de paquetes ordenada que se utilizará para realizar las búsquedas.
    ArrayList<Paquete> lista;

    // Inicializa la lista a partir de una colección y ordena sus elementos.
    public BusquedaCodigo(Collection<Paquete> lista_paquete) {
        this.lista = new ArrayList<>(lista_paquete);

        // Ordena los paquetes para permitir la búsqueda binaria.
        Collections.sort(lista);
    }

    // Inicia la búsqueda recursiva utilizando la lista previamente ordenada.
    public Paquete Buscar(String dato) {
        return buscarRecursivo(lista, dato);
    }

    // Busca un paquete dividiendo repetidamente la lista en dos mitades.
    private Paquete buscarRecursivo(ArrayList<Paquete> lista, String dato) {

        // Si la lista está vacía, significa que el código no se encontró.
        if (lista.isEmpty()) {
            return null;
        }

        // Calcula el índice del elemento central de la lista.
        int medio = lista.size() / 2;

        // Compara el código del paquete central con el código buscado.
        int comparativa_medio = lista.get(medio).getCodigo().compareTo(dato);
        int comparativa_alto = lista.getLast().getCodigo().compareTo(dato);
        int comparativa_bajo = lista.getFirst().getCodigo().compareTo(dato);
        if (comparativa_medio == comparativa_alto && comparativa_medio == comparativa_bajo && comparativa_medio == 0){
            return lista.get(medio);
        }

        if (comparativa_medio == 0 || comparativa_alto == 0 || comparativa_bajo == 0 ) {
            if (comparativa_medio == 0){
                return lista.get(medio);
            }
            if (comparativa_alto == 0){
                return lista.getLast();
            }
            return lista.getFirst();


        } else if (comparativa_medio > 0) {
            // Si el código central es mayor, busca en la mitad izquierda.
            return buscarRecursivo(
                    new ArrayList<>(lista.subList(0, medio)), dato
            );

        } else {
            // Si el código central es menor, busca en la mitad derecha.
            return buscarRecursivo(
                    new ArrayList<>(lista.subList(medio + 1, lista.size())), dato
            );
        }
    }
}
