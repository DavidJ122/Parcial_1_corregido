package Metodos_Sort;
import java.util.Comparator;
import Concretos.Paquete;
//Ordena por codigo
public class porCodigo implements Sort<Paquete> {


    @Override
    public boolean compare(Paquete o1, Paquete o2) {
        int numero = Integer.parseInt(o1.getCodigo().substring(2));
        int numero2 = Integer.parseInt(o2.getCodigo().substring(2));
        return numero > numero2;
    }
}
