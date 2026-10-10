package Remodelado.ListCustom;

import java.util.Iterator;

public class List<T> implements Iterable<T>{
    Nodo<T> header = null;

    public void add(T dato){
        Nodo<T> nodo = this.generateNode(dato);
        if (this.isEmpty()){
            this.setHeader(nodo);
        }
        else{
            this.header.add(nodo);
        }
    }

    public void del(T dato){
       this.setHeader(header.del(dato));
    }

    public T get(T dato){
        return this.header.get(dato);
    }

    public T getSlot(int position){
        return this.header.get(position,0);
    }

    public int lenght(){
        return this.header.lenght();
    }

    private Nodo<T> generateNode(T dato){
        return new Nodo<T>(dato);
    }

    public void setHeader(Nodo<T> nodo){
        this.header=nodo;
    }
    public Nodo<T> getHeader(){
        return this.header;
    }
    public boolean isEmpty(){
        return header == null;
    }


    @Override
    public Iterator<T> iterator() {
        return new NodoIterator<>(this.header);
    }
}
