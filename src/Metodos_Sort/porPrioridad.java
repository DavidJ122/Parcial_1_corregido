package Metodos_Sort;

import Concretos.Paquete;

public class porPrioridad implements Sort<Paquete>{
    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        return o1.getPrioridad()>o2.getPrioridad();
    }
}
