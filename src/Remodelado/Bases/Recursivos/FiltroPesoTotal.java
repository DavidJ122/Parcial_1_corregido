package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
//Filtro que calcula el peso total de los paquetes.
//Se utilizan metodos recursivos
public class FiltroPesoTotal implements FiltrosRecursivos<ArrayList<Paquete>, Double>{

    @Override
    public Double filtrar(ArrayList<Paquete> dato, int i) {
        //Caso Base
        if (i == dato.size() - 1){ return dato.get(i).getPeso();}
        //Caso Recursivo cuando se empieza
        if (i == 0){ return dato.getFirst().getPeso() + this.filtrar(dato,i+1);}
        //Caso recursivo
        return this.filtrar(dato,i) + this.filtrar(dato,i+1);
    }
}
