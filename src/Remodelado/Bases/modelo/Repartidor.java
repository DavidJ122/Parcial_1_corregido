package Remodelado.Bases.modelo;

import Remodelado.Enum.Destino;

import java.util.Objects;

public class Repartidor {

    /** Identificación única. */
    private final String id;
    /** Nombre completo. */
    private final String nombre;
    /** Municipio donde normalmente realiza sus entregas. */
    private final Destino zona;
    /** Indica si puede recibir una nueva asignación. */
    private boolean disponible;

    /**
     * @param id         identificación, no nula ni vacía
     * @param nombre     nombre completo, no nulo ni vacío
     * @param zona       municipio principal, no nulo
     * @param disponible disponibilidad inicial
     * @throws IllegalArgumentException si algún dato no cumple las reglas
     */
    public Repartidor(String id, String nombre, Destino zona, boolean disponible) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación del repartidor no puede ser nula ni vacía.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del repartidor no puede ser nulo ni vacío.");
        }
        if (zona == null) {
            throw new IllegalArgumentException("La zona del repartidor no puede ser nula.");
        }
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.zona = zona;
        this.disponible = disponible;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Destino getZona() {
        return zona;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    /** Lo marca como ocupado (lo usa la asignación). */
    public void ocupar() {
        disponible = false;
    }

    /** Lo vuelve a dejar disponible (lo usa el registro de entrega). */
    public void liberar() {
        disponible = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return id.equals(((Repartidor) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s - %s [zona %s, %s]", id, nombre, zona.getNombre(),
                disponible ? "disponible" : "ocupado");
    }
}
