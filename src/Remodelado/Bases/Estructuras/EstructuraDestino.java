package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import Remodelado.Enum.Destino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
//Estructura especializada para los paquetes con destino.
/* Esta diseñada con el proposito de utilizar un hashmap de tal manera
que el destino sea la clave y el valor sea una lista de paquetes asignadas al destino.
 */
public class EstructuraDestino implements IEstructura<HashMap<Destino, ArrayList<Paquete>>,HashMap<String, Object>> {
    HashMap<Destino, ArrayList<Paquete>> paquetes;
    public EstructuraDestino(){
        this.paquetes = new HashMap<>();
    }

    @Override
    //Devuelve el hashmap de paquetes.
    public HashMap<Destino, ArrayList<Paquete>> getPaquetes() {
        return this.paquetes;
    }
    //Agrega un paquete al hashmap, tomando el destino del paquete como clave.
    //En caso de que el destino ya exista, se agrega el paquete a la lista de paquetes del destino.
    //En caso de que el destino no exista, se crea un nuevo destino con el paquete como valor.
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
    //Elimina un paquete del hashmap, tomando el destino del paquete como clave.
    //En caso de que el destino se quede sin paquetes, se elimina el destino del hashmap.
    @Override
    public void removePaquete(Paquete paquete) {
        ArrayList<Paquete> paquetes = this.paquetes.get(paquete.getDestino());
        paquetes.remove(paquete);
        if (paquetes.isEmpty()){
            this.paquetes.remove(paquete.getDestino());
        }
    }

    //Devuelve el paquete con el ID dado, tomando el destino del paquete como clave.
    //Se ingresa un hashmap con el destino y el ID del paquete.
    //Con claves "Destino" y "ID" cono valor.
    //Se desempaqueta el hashmap para obtener el destino y obtener el valor.
    //Y luego se busca el paquete con el ID dado.
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
    //Obtener el tamaño del hashmap.
    @Override
    public int getSize() {
        return this.paquetes.size();
    }
    //Retorna verdadero o falso en caso de que el hashmap este vacio.
    @Override
    public boolean isEmpty() {
        return this.paquetes.isEmpty();
    }
    //Copia todos los paquetes de una coleccion generica en el hashmap.
    //Es util para cuando se crea un nueva copia de la estructura.
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
    //Retorna una cadena con todos los paquetes del hashmap.
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
