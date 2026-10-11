package Remodelado.Comparadores;

import Remodelado.Modelo.Paquete;

import java.util.Comparator;

public class ComparadorPorTiempo  implements Comparator<Paquete> {
    @Override
    public int compare(Paquete a, Paquete b) {
        return Double.compare(a.getTiempoEstimado(),b.getTiempoEstimado());
    }

}
