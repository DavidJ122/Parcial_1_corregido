package Remodelado.Bases.Comparadores;

import Remodelado.Bases.modelo.Paquete;

import java.util.Comparator;
//Compara de acuerdo al tiempo estimado.
public class ComparadorTiempo implements Comparator<Paquete> {

    @Override
    public int compare(Paquete o1, Paquete o2) {
        return Integer.compare(o1.getTiempo_estimado(), o2.getTiempo_estimado());
    }
}
