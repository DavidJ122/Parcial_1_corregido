package Remodelado.Bases.Recursivos;



import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
import java.util.Collection;

public class BusquedaCodigo {


    public Paquete Buscar(Collection<Paquete> lista_paquete, String dato){
        ArrayList<Paquete> lista = new ArrayList<>(lista_paquete);
        int medio = lista.size()/2;
        ArrayList<Paquete> sublista = new ArrayList<>(lista.subList(0,medio));
        ArrayList<Paquete> sublista2 = new ArrayList<>(lista.subList(medio+1,lista_paquete.size()));
        int indice1 = Buscar_recursivo(sublista,dato,0) + 1;
        int indice2 = Buscar_recursivo(sublista2,dato,0) +1;
        if (indice1 == 0 && indice2 == 0){ return null;}
        if (indice1 == 0){ return lista.get(indice2+medio-1);}
        if (indice2 == 0){ return lista.get(indice1-1);}
        return null;
    }

    private int Buscar_recursivo(ArrayList<Paquete> lista, String dato,int i){
        if (i == lista.size()){ return -1;}
        Paquete p = lista.get(i);
        if (p.getCodigo().equals(dato)){ return lista.indexOf(p);}
        return this.Buscar_recursivo(lista,dato,i+1);
    }




}
