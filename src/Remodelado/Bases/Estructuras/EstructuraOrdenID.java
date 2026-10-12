package Remodelado.Bases.Estructuras;

import Remodelado.Bases.Paquete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class EstructuraOrdenID implements IEstructura<TreeSet<Paquete>,String> {
    private TreeSet<Paquete> paquetes;

    public EstructuraOrdenID(){
        this.paquetes = new TreeSet<>();
    }

    @Override
    public TreeSet<Paquete> getPaquetes() {
        return this.paquetes;
    }

    @Override
    public void addPaquete(Paquete paquete) {
        boolean exito = paquetes.add(paquete);
        if (!exito){
            throw new RuntimeException("El ID paquete ya existe con ID: " + paquete.getCodigo());
        }
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
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Paquete p : this.paquetes) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
