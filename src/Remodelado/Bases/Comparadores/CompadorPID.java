package Remodelado.Bases.Comparadores;

import Remodelado.Bases.Paquete;

import java.util.Comparator;

public class CompadorPID implements Comparator<Paquete> {

    @Override
    public int compare(Paquete o1, Paquete o2) {
        return Integer.compare(o1.getPID_Raw(), o2.getPID_Raw());
    }
}
