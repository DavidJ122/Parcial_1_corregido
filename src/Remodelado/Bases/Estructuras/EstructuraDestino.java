package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import Remodelado.Enum.Destino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class EstructuraDestino implements IEstructura<HashMap<Destino, ArrayList<Paquete>>, HashMap<String, Object>> {

    private HashMap<Destino, ArrayList<Paquete>> paquetes;

    public EstructuraDestino() {
        this.paquetes = new HashMap<>();
    }

    @Override
    public HashMap<Destino, ArrayList<Paquete>> getPaquetes() {
        return this.paquetes;
    }

    @Override
    public void addPaquete(Paquete paquete) {
        Destino destino = paquete.getDestino();
        if (this.paquetes.containsKey(destino)) {
            ArrayList<Paquete> listaDestino = this.paquetes.get(destino);
            listaDestino.add(paquete);
        } else {
            ArrayList<Paquete> listaDestino = new ArrayList<>();
            listaDestino.add(paquete);
            this.paquetes.put(destino, listaDestino);
        }
    }

    @Override
    public void removePaquete(Paquete paquete) {
        ArrayList<Paquete> listaDestino = this.paquetes.get(paquete.getDestino());
        if (listaDestino != null) {
            listaDestino.remove(paquete);
            // Si la lista queda vacía tras eliminar el paquete, borramos la llave del mapa
            if (listaDestino.isEmpty()) {
                this.paquetes.remove(paquete.getDestino());
            }
        }
    }

    @Override
    public Paquete getPaquete(HashMap<String, Object> ID) {
        Destino destino = (Destino) ID.get("Destino");
        ArrayList<Paquete> listaDestino = this.paquetes.get(destino);

        if (listaDestino != null) {
            for (Paquete p : listaDestino) {
                if (p.getCodigo().equals(ID.get("ID"))) {
                    return p;
                }
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
        for (Paquete p : paquetes) {
            this.addPaquete(p);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Destino d : this.paquetes.keySet()) {
            sb.append("--- DESTINO: ").append(d.toString()).append(" ---\n");
            for (Paquete p : this.paquetes.get(d)) {
                sb.append(p.toString()).append("\n"); // Agregado el salto de línea aquí
            }
        }
        return sb.toString();
    }

    public void agregarPorDestino(Destino destino, Paquete paquete) {
        this.addPaquete(paquete);
    }
}