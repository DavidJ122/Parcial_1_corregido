package Metodos_Sort;
//Ordena por peso
import Concretos.Paquete;

import java.util.Comparator;

public class porPeso implements Sort<Paquete>{
    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        return o1.getPeso()>o2.getPeso();
    }
}

