package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.ArrayDeque;
import java.util.Collection;

public class EstructuraFIFO implements IEstructura<ArrayDeque<Paquete>,String> {
    ArrayDeque<Paquete> paquetes;

    public EstructuraFIFO(){
        this.paquetes = new ArrayDeque<>();
    }
    @Override
    public ArrayDeque<Paquete> getPaquetes() {
        return paquetes;
    }

    @Override
    public void addPaquete(Paquete paquete) {
        this.paquetes.offer(paquete);
    }

    @Override
    public void removePaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }

    @Override
    public Paquete getPaquete(String ID) {
        return null;
    }

    public Paquete getFirst(){
        return this.paquetes.poll();
    }

    @Override
    public int getSize() {
        return this.paquetes.size();
    }

    @Override
    public boolean isEmpty() {
        return this.paquetes.isEmpty();
    }

    @Override
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Paquete p : this.paquetes) {
            sb.append(p.toString());
        }
        return sb.toString();
    }
}
