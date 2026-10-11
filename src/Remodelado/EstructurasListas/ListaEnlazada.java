package Remodelado.EstructurasListas;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaEnlazada<T> implements Coleccion<T>,Iterable<T>{
    private static class Nodo<T>{
        private final T valor;
        private Nodo<T> siguiente;

        private Nodo(T valor){
            this.valor=valor;
            this.siguiente=null;
        }

    }
    private Nodo<T> cabeza;
    private Nodo<T>cola;
    private int tamano;
    public ListaEnlazada(){
        this.cabeza=null;
        this.cola=null;
        this.tamano=0;
    }
    @Override
    public void agregar(T elemento){
        if (elemento==null){
            throw new IllegalArgumentException("el elemento no puede estar vacio");
        }
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (estaVacia()){
            cabeza=nuevo;
        }else {
            cola.siguiente=nuevo;
        }
        cola=nuevo;
        tamano++;
    }

    @Override
    public boolean eliminar(T elemento) {
        if (estaVacia()) {
            return false;
        }
        if (Objects.equals(cabeza.valor, elemento)) {
            cabeza = cabeza.siguiente;
            if (cabeza == null) {
                cola = null;
            }
            tamano--;
            return true;
        }
        Nodo<T> anterior = cabeza;
        Nodo<T> actual = cabeza.siguiente;
        while (actual != null) {
            if (Objects.equals(actual.valor, elemento)) {
                anterior.siguiente = actual.siguiente;
                if (actual == cola) {
                    cola = anterior;
                }

                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false;
    }
    @Override
    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamano) {
            throw new IndexOutOfBoundsException("Posición " + posicion + ", tamaño " + tamano);
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    @Override
    public int tamano() {
        return tamano;
    }

    @Override
    public boolean estaVacia() {
        return tamano == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    private class IteradorLista implements Iterator<T> {


        private Nodo<T> actual = cabeza;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No quedan elementos en la lista.");
            }
            T valor = actual.valor;
            actual = actual.siguiente;
            return valor;
        }
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "(vacía)";
        }
        StringBuilder sb = new StringBuilder();
        for (T elemento : this) {
            if (sb.length() > 0) {
                sb.append(" → ");
            }
            sb.append(elemento);
        }
        return sb.toString();
    }

}
