package Remodelado.Bases.Comparadores;

import Remodelado.Bases.modelo.Paquete;

import java.util.Comparator;

public class ComparadorPeso implements Comparator<Paquete> {
    @Override
    public int compare(Paquete o1, Paquete o2) {
        return Float.compare(o2.getPeso(), o1.getPeso());
    }
}
