package Remodelado.Bases.Estructuras;

import Remodelado.Bases.Paquete;

import java.util.ArrayList;
import java.util.Collection;

public class EstructuraLlegada implements IEstructura<ArrayList<Paquete>,String> {
    private ArrayList<Paquete> paquetes;

    public EstructuraLlegada(){
        this.paquetes = new ArrayList<>();
    }

    @Override
    public ArrayList<Paquete> getPaquetes() {
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
    public Paquete getPaquete(String Codigo) {
        for (Paquete p : this.paquetes) {
            if (p.getCodigo().equals(Codigo)) {
                return p;
            }
        }
        return null;
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
    public void addAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
}
