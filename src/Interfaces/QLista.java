package Interfaces;

public interface QLista<T> extends Iterable<T>{
    void agregar(T nodo);
    void eliminar(T nodo);
    T obtener(T nodo);
    int Tamaño(T nodo);
    boolean vacio();
    boolean contains(Object o);
}
