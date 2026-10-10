package Legacy.Metodos_Sort;
//Ordena por prioridad
import Legacy.Concretos.Paquete;

public class porPrioridad implements Sort<Paquete>{
    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        return o1.getPrioridad()>o2.getPrioridad();
    }
}
