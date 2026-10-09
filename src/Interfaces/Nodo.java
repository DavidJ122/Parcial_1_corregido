package Interfaces;
//
public interface Nodo {
    public String getCodigo();
    public boolean existe(Object t);
    public void add(Nodo nodo);
    public Nodo obtener(Nodo nodo);
    public Nodo eliminar(Nodo nodo);
    public int Contar();
    public boolean hasNext();
    public Nodo next();
}
