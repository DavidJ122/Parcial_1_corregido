package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import java.util.*;

public class EstructuraPrioritaria implements IEstructura<PriorityQueue<Paquete>, String> {

    private PriorityQueue<Paquete> paquetes;

    public EstructuraPrioritaria(Comparator<Paquete> comparador) {
        this.paquetes = new PriorityQueue<>(comparador);
    }

    @Override
    public PriorityQueue<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(PriorityQueue<Paquete> paquetes) {
        this.paquetes = paquetes;
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
            if (Objects.equals(p.getCodigo(), Codigo)) {
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

    public Paquete extraerSiguiente() {
        return this.paquetes.poll();
    }

    private void replace(ArrayList<Paquete> paquetes) {
        this.clear();
        this.paquetes.addAll(paquetes);
    }

    private void clear() {
        this.paquetes.clear();
    }

    @Override
    public String toString() {
        PriorityQueue<Paquete> copia = new PriorityQueue<>(this.paquetes);
        StringBuilder sb = new StringBuilder();

        while (!copia.isEmpty()) {
            sb.append(copia.poll());
            sb.append("\n");
        }
        return sb.toString();
    }
}