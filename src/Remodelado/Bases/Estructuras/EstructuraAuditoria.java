package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.Collection;
import java.util.LinkedList;
//Estructura especializada para los paquetes en orden de llegada para razones de auditorias.
/*
Se utiliza para las operaciones de auditorias, se registran los paquetes entrantes.
No obstante, no se utiliza para las operaciones de despacho.
Se usa un LinkedList para que tengan un orden de llegada.

 */
public class EstructuraAuditoria implements IEstructura<LinkedList<Paquete>,String>{
    LinkedList<Paquete> paquetes;
    //Constructor
    public EstructuraAuditoria(){
        this.paquetes = new LinkedList<>();
    }
    //Obtiene el LinkedList de paquetes.
    @Override
    public LinkedList<Paquete> getPaquetes() {
        return this.paquetes;
    }
    //Agrega un paquete al LinkedList.
    @Override
    public void addPaquete(Paquete paquete) {
            this.paquetes.add(paquete);
    }
    //Elimina un paquete del LinkedList.
    @Override
    public void removePaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }
    //Devuelve el paquete con el ID dado.
    @Override
    public Paquete getPaquete(String ID) {
        for (Paquete p : this.paquetes) {
            if (p.getCodigo().equals(ID)){
                return p;
            }
        }
        return null;
    }
    //Devuelve el tamaño del LinkedList.
    @Override
    public int getSize() {
        return paquetes.size();
    }
    //Verdadero para vacio, falso para no vacio.
    @Override
    public boolean isEmpty() {
        return paquetes.isEmpty();
    }
    //Copia todos los paquetes de una coleccion generica en el LinkedList.
    @Override
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    //Devuelve una cadena con todos los paquetes del LinkedList.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Paquete p : this.paquetes) {
            sb.append(p.toString());
            sb.append("↓");
        }
        return sb.toString();
    }
}
