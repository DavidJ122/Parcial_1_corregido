package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

// Busca un paquete por su código mediante el algoritmo de divide y vencerás.
public class FiltroPesoMajor {

    // Lista de paquetes ordenada que se utilizará para realizar las búsquedas.
    ArrayList<Paquete> lista;

    // Inicializa la lista a partir de una colección y ordena sus elementos.
    public FiltroPesoMajor(Collection<Paquete> lista_paquete) {
        this.lista = new ArrayList<>(lista_paquete);

        // Ordena los paquetes para permitir la búsqueda binaria.
        Collections.sort(lista);
    }

    // Inicia la búsqueda recursiva utilizando la lista previamente ordenada.
    public Double Buscar() {
        return buscarRecursivo(lista);
    }

    // Busca un paquete dividiendo repetidamente la lista en dos mitades.
    private Double buscarRecursivo(ArrayList<Paquete> lista) {
        if (lista.isEmpty()) {return 0.0;}
        if (lista.size() == 1) {return lista.getFirst().getPeso();}
        int medio = lista.size() / 2;
        ArrayList<Paquete> lista_Izquierda= new ArrayList<>(lista.subList(0, medio));
        ArrayList<Paquete> lista_Derecha = new ArrayList<>(lista.subList(medio+1, lista.size()));
        Double peso_Izquierda = buscarRecursivo(lista_Izquierda);
        Double peso_Derecha = buscarRecursivo(lista_Derecha);
        if (peso_Izquierda < peso_Derecha){
            return peso_Derecha;
        }
        return peso_Izquierda;
    }
}