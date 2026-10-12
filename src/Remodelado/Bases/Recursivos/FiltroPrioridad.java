package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;
import java.util.ArrayList;
import java.util.Collection;

// Filtro que cuenta los paquetes con prioridad mayor o igual a la minima.
public class FiltroPrioridad {

    private ArrayList<Paquete> dato;

    public FiltroPrioridad(Collection<Paquete> paquetes) {
        this.dato = new ArrayList<Paquete>(paquetes);
    }

    // Metodo publico
    public Integer filtrar(int priminima) {
        if (dato.isEmpty()) {
            return 0;
        }

        return filtrar(priminima, 0);
    }

    // Metodo recursivo auxiliar
    private Integer filtrar(int priminima, int i) {
        // Caso base: ultimo elemento
        if (i == dato.size() - 1) {
            return filtro(dato.get(i), priminima) ? 1 : 0;
        }

        // Caso recursivo
        int cantidad = filtro(dato.get(i), priminima) ? 1 : 0;

        return cantidad + filtrar(priminima, i + 1);
    }

    // Metodo condicional
    private boolean filtro(Paquete p, int priminima) {
        return p.getPrioridad() >= priminima;
    }
}