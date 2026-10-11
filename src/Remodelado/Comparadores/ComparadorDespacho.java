package Remodelado.Comparadores;

import Remodelado.Modelo.Paquete;

import java.util.Comparator;

public class ComparadorDespacho implements Comparator<Paquete> {
    @Override
    public int compare(Paquete A, Paquete B) {
        int PorPrioridad =  Integer.compare(B.getPrioridad(),A.getPrioridad());{
            if (PorPrioridad!=0){
                return PorPrioridad;
            }
        }
        int PorTiempo =  Integer.compare(   A.getTiempoEstimado(),B.getTiempoEstimado());{
            if (PorTiempo != 0){
                return PorTiempo;
            }
            return A.compareTo(B);
        }
    }

}
