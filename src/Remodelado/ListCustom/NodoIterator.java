package Remodelado.ListCustom;

import java.util.Iterator;

public class NodoIterator<T>  implements Iterator<T> {
    private Nodo<T> current;

    public NodoIterator(Nodo<T> current){
        this.current = current;
    }
    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T aux = current.getDato();
        current = current.next();
        return aux;
    }
}
