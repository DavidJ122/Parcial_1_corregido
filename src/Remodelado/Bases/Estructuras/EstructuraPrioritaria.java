package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.*;
//Estructura especializada para los paquetes con prioridad.
/* Esta estructura esta diseñada para que los paquetes esten organizados por medio de
un filtro specializado (Comparator) que se le pasa al constructor.
1.- ComparadorDespacho: Prioridad -> Tiempo estimado -> PID
2.- ComparadorPeso: Mayor a menor
3.- ComparadorTiempo: menor a mayor
4.- ComparadorPrioritario: mayor a menor
Debido a esto, se utiliza priorityQueue para ordenar los paquetes.
Y un comparator para establecer el orden de los paquetes.
 */
public class EstructuraPrioritaria implements IEstructura<PriorityQueue<Paquete>,String> {
    PriorityQueue<Paquete> paquetes;
    //Constructor con un comparador como parametro.
    public EstructuraPrioritaria(Comparator<Paquete> comparador){
        this.paquetes = new PriorityQueue<>(comparador);
    }
    //Obtiene el PriorityQueue de paquetes.
    @Override
    public PriorityQueue<Paquete> getPaquetes() {
        return paquetes;
    }
    //Establece el PriorityQueue de paquetes.
    public void setPaquetes(PriorityQueue<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
    //Agrega un paquete al PriorityQueue.
    @Override
    public void addPaquete(Paquete paquete){
        this.paquetes.add(paquete);
    }
    //Elimina un paquete del PriorityQueue.
    @Override
    public void removePaquete(Paquete paquete){
        this.paquetes.remove(paquete);
    }
    //Devuelve el paquete con el ID dado.
    @Override
    public Paquete getPaquete(String Codigo){
        for (Paquete p : this.paquetes) {
            if (Objects.equals(p.getCodigo(), Codigo)) {
                return p;
            }
        }
        return null;
    }
    //Obtiene el tamaño del PriorityQueue.
    @Override
    public int getSize(){
        return this.paquetes.size();
    }
    //Verdadero para vacio, falso para no vacio.
    @Override
    public boolean isEmpty(){
        return this.paquetes.isEmpty();
    }
    //Copia todos los paquetes de una coleccion generica en el PriorityQueue.
    @Override
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    //Devuelve el primer paquete del PriorityQueue.
    public Paquete getFirst(){
        return this.paquetes.poll();
    }
    //Devuelve una cadena con todos los paquetes del PriorityQueue.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        while (!this.isEmpty()) {
            sb.append(paquetes.poll());
            sb.append("\n");
        }
        return sb.toString();
    }
}
