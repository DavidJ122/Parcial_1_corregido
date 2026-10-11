package Remodelado.Modelo;

import java.util.ArrayList;

public class EstructuraBase {
    ArrayList<Paquete> paquetes;

    public EstructuraBase(){
        this.paquetes = new ArrayList<>();
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public void addPaquete(Paquete paquete){
        if (this.paquetes.contains(paquete)) {throw new IllegalArgumentException("PID already exists");}
        ArrayList<Paquete> aux = new ArrayList<>();

        for (Paquete p : paquetes) {
            if (this.firstThan(p, paquete)) {
                aux.add(p);
            }
            else {
                aux.add(paquete);
            }
        }
        if (!aux.contains(paquete)) {
            aux.add(paquete);
        }
        this.replace(aux);
    }

    public void removePaquete(Paquete paquete){
        this.paquetes.remove(paquete);
    }

    public Paquete getPaquete(int PID){
        return this.paquetes.get(PID);
    }

    public int getSize(){
        return this.paquetes.size();
    }

    public boolean isEmpty(){
        return this.paquetes.isEmpty();
    }

    public boolean firstThan(Paquete o1, Paquete o2) {
        if (o1.getPrioridad()<o2.getPrioridad()) { return true;}
        else if (o1.getPrioridad()==o2.getPrioridad()) {
            if (o1.getTiempo_estimado()<o2.getTiempo_estimado()){
                return true;
            }
            else if (o1.getTiempo_estimado()==o2.getTiempo_estimado()){
                return o1.getPID_Raw()<o2.getPID_Raw();
            }
        }
        return false;
    }
    public void replace(ArrayList<Paquete> paquetes){
        this.clear();
        this.paquetes.addAll(paquetes);
    }
    private void clear(){
        this.paquetes.clear();
    }
}
