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
        int comparativa = lista.get(medio).getCodigo().compareTo(dato);

        if (comparativa == 0) {
            // Si los códigos coinciden, devuelve el paquete encontrado.
            return lista.get(medio);

        } else if (comparativa > 0) {
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
