package Remodelado.Bases.Recursivos;



import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayList;
import java.util.Collection;
//Busca un paquete por su codigo de forma "eficiente" y por divide y venceras.
/*
Se utiliza para la busqueda de un paquete por su codigo.
Funciona dividiendo la lista en dos partes y buscando en cada una de ellas.
Se itera sobre las dos mitades.
Se evalua recursivamente.
En caso de que:
- El codigo no se encuentra en el nodo del indice:
    - Si es final: Devuelve -1
    - Si no es final: Se evalua recursivamente.
-  El codigo se encuentra en el nodo del indice:
    - Devuelve el indice del nodo.
    - En caso de que sea la segunda mitad: Devuelve el indice del nodo + la mitad de la lista.
Indice1: Indica el indice del nodo del codigo en la primera mitad, sumado con 1 para que de si no se encuentra.
Indice2: Indica el indice del nodo del codigo en la segunda mitad, sumado con 1 para que de si no se encuentra.
Si ambos indice son 0, devuelve null.
 */
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
