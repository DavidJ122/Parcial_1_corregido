package Remodelado.Bases;

import Remodelado.Enum.Destino;

import java.util.Objects;

public class Repartidor {
    private final int id;
    private Destino destino;
    private int Tiempo_estimado;
    private Repartidor next;

    public int getId() {
        return id;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getTiempo_estimado() {
        return Tiempo_estimado;
    }

    public void setTiempo_estimado(int tiempo_estimado) {
        Tiempo_estimado = tiempo_estimado;
    }

    public Repartidor getNext() {
        return next;
    }

    public void setNext(Repartidor next) {
        this.next = next;
    }

    public Repartidor(int id, Destino destino, int tiempo_estimado, Repartidor next) {
        this.id = id;
        this.destino = destino;
        Tiempo_estimado = tiempo_estimado;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Repartidor that = (Repartidor) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Repartidor{" +
                "id=" + id +
                ", destino=" + destino +
                ", Tiempo_estimado=" + Tiempo_estimado +
                ", next=" + next +
                '}';
    }
}
