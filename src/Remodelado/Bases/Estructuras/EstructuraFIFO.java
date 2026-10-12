package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayDeque;
import java.util.Collection;
//Estructura FIFO
/* Lista -no prioritaria- especializada en FIFO, es decir, first in first out.
se utiliza para las operaciones de despacho que no requieren de prioridad.
Se uso un queue para que tengan un orden de quien llega primero, y sacar al primero.
 */
public class EstructuraFIFO implements IEstructura<ArrayDeque<Paquete>,String> {
    ArrayDeque<Paquete> paquetes;
    //Constructor
    public EstructuraFIFO(){
        this.paquetes = new ArrayDeque<>();
    }
    //Obtiene el ArrayDeque de paquetes.
    @Override
    public ArrayDeque<Paquete> getPaquetes() {
        return paquetes;
    }
    //Agrega un paquete al ArrayDeque.
    @Override
    public void addPaquete(Paquete paquete) {
        this.paquetes.offer(paquete);
    }
    //Elimina un paquete del ArrayDeque.
    @Override
    public void removePaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }
    //¿Se borra?
    @Override
    public Paquete getPaquete(String ID) {
        return this.getFirst();
    }
    //Obtiene el primer paquete del ArrayDeque.
    private Paquete getFirst(){
        return this.paquetes.poll();
    }
    //Obtiene el tamaño del ArrayDeque.
    @Override
    public int getSize() {
        return this.paquetes.size();
    }
    //Verdadero para vacio, falso para no vacio.
    @Override
    public boolean isEmpty() {
        return this.paquetes.isEmpty();
    }
    //Copia todos los paquetes de una coleccion generica en el ArrayDeque.
    @Override
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    //Devuelve una cadena con todos los paquetes del ArrayDeque.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Paquete p : this.paquetes) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
