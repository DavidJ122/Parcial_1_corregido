package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.Collection;
import java.util.LinkedList;

public class EstructuraLlegada implements IEstructura<LinkedList<Paquete>,String>{
    LinkedList<Paquete> paquetes;
    public EstructuraLlegada(){
        this.paquetes = new LinkedList<>();
    }
    @Override
    public LinkedList<Paquete> getPaquetes() {
        return this.paquetes;
    }

    @Override
    public void addPaquete(Paquete paquete) {
            this.paquetes.add(paquete);
    }

    @Override
    public void removePaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }

    @Override
    public Paquete getPaquete(String ID) {
        for (Paquete p : this.paquetes) {
            if (p.getCodigo().equals(ID)){
                return p;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return paquetes.size();
    }

    @Override
    public boolean isEmpty() {
        return paquetes.isEmpty();
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
