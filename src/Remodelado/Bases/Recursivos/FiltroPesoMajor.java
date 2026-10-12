package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;
import java.util.ArrayList;
import java.util.Collection;

// Obtiene el peso mayor mediante divide y venceras.
public class FiltroPesoMajor {

    private ArrayList<Paquete> lista;

    public FiltroPesoMajor(Collection<Paquete> lista_paquete) {
        this.lista = new ArrayList<>(lista_paquete);
    }

    public Double buscar() {
        if (lista.isEmpty()) {
            return 0.0;
        }

        return buscarRecursivo(lista, 0, lista.size() - 1);
    }

    private Double buscarRecursivo(ArrayList<Paquete> lista, int inicio, int fin) {
        // Caso base
        if (inicio == fin) {
            return lista.get(inicio).getPeso();
        }

        // Dividir
        int medio = inicio + (fin - inicio) / 2;

        // Resolver cada mitad
        Double pesoIzquierda = buscarRecursivo(lista, inicio, medio);
        Double pesoDerecha = buscarRecursivo(lista, medio + 1, fin);

        // Combinar resultados
        return Math.max(pesoIzquierda, pesoDerecha);
    }
}