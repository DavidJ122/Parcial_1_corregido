package Remodelado.Bases;

import Remodelado.Enum.Destino;

import java.util.Objects;

public class Repartidor {
    private final String id;
    private final String nombreCompleto;
    private final Destino zona;
    private  boolean disponible;

    public Repartidor(String id, String nombreCompleto, Destino zona, boolean disponible) {
        if (id == null || id.isBlank() ){
            throw new IllegalArgumentException("el id no puede estar vacio");
        }
        if (nombreCompleto== null || nombreCompleto.isBlank()){
            throw new IllegalArgumentException("el campo del nombre debe ser llenado");
        }
        if (zona==null){
            throw new IllegalArgumentException("la zona del repartidor no puede estar vacia");
        }
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.zona = zona;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public Destino getZona() {
        return zona;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String Ocupar(){
        disponible=false;
        return "el repartidor se ha ocupado";
    }

    public String Desocupar(){
        disponible=true;
        return "el repartidor se ha desocupado";
    }
    @Override
    public int hashCode(){
       return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s - %s [zona %s, %s]", id, nombreCompleto, zona.getNombre(),
                disponible ? "disponible" : "ocupado");
    }
    @Override
    public boolean equals(Object cualquiera ){
        if (this==cualquiera){
            return true;
        }
        if (cualquiera==null||getClass() != cualquiera.getClass()){
            return false;
        }
        return id.equals(((Repartidor)cualquiera).id);


    }
}
