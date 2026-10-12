package Remodelado.Bases.Comparadores;

import Remodelado.Bases.modelo.Paquete;

import java.util.Comparator;


//Compara de acuerdo al despacho.
// Prioridad -> Tiempo estimado -> PID
public class ComparadorDespacho implements Comparator<Paquete> {
    @Override
    public int compare(Paquete o1, Paquete o2) {
        //Compara de acuerdo a la prioridad
        int comp = Integer.compare(o2.getPrioridad(),o1.getPrioridad());
        //Si son iguales
        if (comp==0){
            //Compara de acuerdo al tiempo estimado
            comp = Integer.compare(o1.getTiempo_estimado(),o2.getTiempo_estimado());
            if (comp==0){
                //Compara de acuerdo al PID
                 return Integer.compare(o1.getPID_Raw(),o2.getPID_Raw());
            }
            return comp;
        }
        return comp;
    }



}
