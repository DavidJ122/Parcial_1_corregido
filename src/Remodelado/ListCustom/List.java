package Remodelado.ListCustom;

import java.util.Iterator;
//Lista simplemente enlazada generica
/*
Estructura principal de la lista, aloja un nodo tipo T generico.
Principalmente comanda a la cabeza a realizar las operaciones.
 */
public class List<T> implements Iterable<T>{
    Nodo<T> header = null;
    //Agrega un nodo al final de la lista.
    public void add(T dato){
        Nodo<T> nodo = this.generateNode(dato);
        if (this.isEmpty()){
            this.setHeader(nodo);
        }
        else{
            this.header.add(nodo);
        }
    }
    //Elimina un nodo de la lista.
    public void del(T dato){
       this.setHeader(header.del(dato));
    }
    //Devuelve el nodo con el dato dado.
    public T get(T dato){
        return this.header.get(dato);
    }
    //Devuelve el nodo en la posicion dada.
    public T getSlot(int position){
        return this.header.get(position,0);
    }
    //Devuelve el tamaño de la lista.
    public int lenght(){
        return this.header.lenght();
    }
    //Genera un nodo con el dato dado.
    private Nodo<T> generateNode(T dato){
        return new Nodo<T>(dato);
    }
    //Establece la cabeza de la lista.
    public void setHeader(Nodo<T> nodo){
        this.header=nodo;
    }
    //Devuelve la cabeza de la lista.
    private Nodo<T> getHeader(){
        return this.header;
    }
    //Devuelve true si la lista esta vacia.
    public boolean isEmpty(){
        return header == null;
    }
    //Devuelve una cadena con todos los datos de la lista.
    @Override
    public String toString(){
        return this.header.toString();
    }

    //Iterador de la lista.
    @Override
    public Iterator<T> iterator() {
        return new NodoIterator<>(this.header);
    }
}
