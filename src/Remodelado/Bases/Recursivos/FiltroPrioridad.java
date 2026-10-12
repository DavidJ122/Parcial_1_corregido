package Remodelado.Bases.Recursivos;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;

public class FiltroPrioridad{

    public Integer filtrar(ArrayList<Paquete> dato, int priminima,int i) {
        if (i == dato.size() - 1) {
            if (this.filtro(dato.get(i),priminima)){
                return 1 + this.filtrar(dato,priminima,i+1);
            }
            return 0;
        }
        if (this.filtro(dato.get(i),priminima)){
            return 1 + this.filtrar(dato,priminima,i+1);
        }
        return this.filtrar(dato,priminima,i+1);
    }

    private boolean filtro(Paquete p, int priminima){
        if (p.getPrioridad() >= priminima){
            return true;
        }
        return false;
    }
}
