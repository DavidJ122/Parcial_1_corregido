package Metodos_Sort;

import Concretos.Paquete;

import java.util.Comparator;

public class porTiempo implements Sort<Paquete>{


    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        return o1.getTiempo_estimado()<o2.getTiempo_estimado();
    }
}
