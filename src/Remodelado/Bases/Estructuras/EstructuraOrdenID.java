package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.Collection;
import java.util.DuplicateFormatFlagsException;
import java.util.TreeSet;
//Estructura especializada para organizar los paquetes por su ID.
/* En esta estructura, los paquetes son ordenados por su ID y con un orden natural.
Tambien se utiliza para chequear automaticamnete si el ID del paquete ya existe.
Se usa un TreeSet para que tengan un orden natural.
 */
public class EstructuraOrdenID implements IEstructura<TreeSet<Paquete>,String> {
    private TreeSet<Paquete> paquetes;
    //Constructor
    public EstructuraOrdenID(){
        this.paquetes = new TreeSet<>();
    }
    //Obtiene el TreeSet de paquetes.
    @Override
    public TreeSet<Paquete> getPaquetes() {
        return this.paquetes;
    }
    //Agrega un paquete al TreeSet.
    //Si el ID del paquete ya existe, se lanza una excepcion.
    @Override
    public void addPaquete(Paquete paquete) {
        boolean exito = paquetes.add(paquete);
        if (!exito){
            throw new IllegalArgumentException("El ID paquete ya existe con ID: " + paquete.getCodigo());
        }
    }
    //Elimina un paquete del TreeSet.
    @Override
    public void removePaquete(Paquete paquete) {
        this.paquetes.remove(paquete);
    }
    //Devuelve el paquete con el ID dado.
    @Override
    public Paquete getPaquete(String Codigo) {
        for (Paquete p : this.paquetes) {
            if (p.getCodigo().equals(Codigo)) {
                return p;
            }
        }
        return null;
    }
    //Devuelve el tamaño del TreeSet.
    @Override
    public int getSize() {
        return this.paquetes.size();
    }
    //Verdadero para vacio, falso para no vacio.
    @Override
    public boolean isEmpty() {
        return this.paquetes.isEmpty();
    }
    //Copia todos los paquetes de una coleccion generica en el TreeSet.
    @Override
    public void copyAll(Collection<Paquete> paquetes) {
        this.paquetes.addAll(paquetes);
    }
    //Devuelve una cadena con todos los paquetes del TreeSet.
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Paquete p : this.paquetes) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
