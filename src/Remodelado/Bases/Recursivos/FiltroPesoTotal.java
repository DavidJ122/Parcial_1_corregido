package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
import java.util.Collection;

//Filtro que calcula el peso total de los paquetes.
//Se utilizan metodos recursivos
public class FiltroPesoTotal {
    ArrayList<Paquete> dato;

    public FiltroPesoTotal(Collection<Paquete> paquetes) {
        this.dato = new ArrayList<>(paquetes);
    }

    // Metodo publico
    public Double filtrar() {
        return filtrar(0);
    }

    // Metodo recursivo auxiliar
    private Double filtrar(int i) {
        // Caso base: lista vacia
        if (dato.isEmpty()) {
            return 0.0;
        }

        // Caso base: ultimo elemento
        if (i == dato.size() - 1) {
            return dato.get(i).getPeso();
        }

        // Caso recursivo
        return dato.get(i).getPeso() + filtrar(i + 1);
    }
}
