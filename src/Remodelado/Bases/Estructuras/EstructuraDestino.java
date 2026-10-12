package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import Remodelado.Enum.Destino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class EstructuraDestino implements IEstructura<HashMap<Destino, ArrayList<Paquete>>,HashMap<String, Object>> {
    HashMap<Destino, ArrayList<Paquete>> paquetes;
    public EstructuraDestino(){
        this.paquetes = new HashMap<>();
    }

    @Override
    public HashMap<Destino, ArrayList<Paquete>> getPaquetes() {
        return this.paquetes;
    }

    @Override
    public void addPaquete(Paquete paquete) {
        Destino destino = paquete.getDestino();
        if (this.paquetes.containsKey(destino)){
            ArrayList<Paquete> paquetes = this.paquetes.get(destino);
            paquetes.add(paquete);
        }
        else{
            ArrayList<Paquete> paquetes = new ArrayList<>();
            paquetes.add(paquete);
            this.paquetes.put(destino, paquetes);
        }
    }

    @Override
    public void removePaquete(Paquete paquete) {
        ArrayList<Paquete> paquetes = this.paquetes.get(paquete.getDestino());
        paquetes.remove(paquete);
        if (paquetes.isEmpty()){
            this.paquetes.remove(paquete.getDestino());
        }
    }


    @Override
    public Paquete getPaquete(HashMap<String,Object> ID) {
        Destino destino = (Destino) ID.get("Destino");
        ArrayList<Paquete> paquetes = this.paquetes.get(destino);
        for (Paquete p : paquetes) {
            if (p.getCodigo().equals(ID.get("ID"))){
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
        for (Paquete p : paquetes) {
            if (this.paquetes.containsKey(p.getDestino())){
                ArrayList<Paquete> paquetesDestino = this.paquetes.get(p.getDestino());
                paquetesDestino.add(p);
            }
            else{
                ArrayList<Paquete> paquetesDestino = new ArrayList<>();
                paquetesDestino.add(p);
                this.paquetes.put(p.getDestino(), paquetesDestino);
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Destino d : this.paquetes.keySet()) {
            sb.append(d.toString());
            sb.append("\n");
            for (Paquete p : this.paquetes.get(d)) {
                sb.append(p.toString());
            }
        }
        return sb.toString();
    }
}
