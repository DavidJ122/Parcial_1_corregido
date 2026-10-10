package Legacy.Metodos_Sort;
//Ordena por peso
import Legacy.Concretos.Paquete;

public class porPeso implements Sort<Paquete>{
    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        return o1.getPeso()>o2.getPeso();
    }
}

