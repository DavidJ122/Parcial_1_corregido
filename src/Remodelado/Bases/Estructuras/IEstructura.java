package Remodelado.Bases.Estructuras;

import Remodelado.Bases.Paquete;

import java.util.Collection;

public interface IEstructura<T,J>{
    public T getPaquetes();
    public void addPaquete(Paquete paquete);
    public void removePaquete(Paquete paquete);
    public Paquete getPaquete(J ID);
    public int getSize();
    public boolean isEmpty();
    public void copyAll(Collection<Paquete> paquetes);
}
