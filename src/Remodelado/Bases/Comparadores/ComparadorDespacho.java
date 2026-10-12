package Remodelado.Bases.Comparadores;

import Remodelado.Bases.Paquete;

import java.util.Comparator;

public class ComparadorDespacho implements Comparator<Paquete> {
    @Override
    public int compare(Paquete o1, Paquete o2) {
        int comp = Integer.compare(o2.getPrioridad(),o1.getPrioridad());
        if (comp==0){
            comp = Integer.compare(o1.getTiempo_estimado(),o2.getTiempo_estimado());
            if (comp==0){
                 return Integer.compare(o1.getPID_Raw(),o2.getPID_Raw());
            }
            return comp;
        }
        return comp;
    }



}
