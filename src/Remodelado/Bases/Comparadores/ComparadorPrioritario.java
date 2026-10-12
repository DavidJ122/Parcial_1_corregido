package Remodelado.Bases.Comparadores;

import Remodelado.Bases.modelo.Paquete;

import java.util.Comparator;

public class ComparadorPrioritario implements Comparator<Paquete> {
    @Override
    public int compare(Paquete o1, Paquete o2) {
        return Integer.compare(o2.getPrioridad(), o1.getPrioridad());
    }
}
