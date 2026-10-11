package Remodelado.Modelo;

import Remodelado.Enum.Destino;

public class Paquete implements Comparable<Paquete>{

    // Constantes de prioridad
    public static final int PRIORIDAD_MINIMA=0;
    public static final int PRIORIDAD_MAX=5;
    public static final int PRIORIDAD_PORDEFECTO=3;

    //ATRIBUTOS DE CLASE

    private final String codigo;
    private final Destino destino;
    private final double peso;
    private final int prioridad ;
    private final int tiempoEstimado;

    public Paquete(String codigo, Destino destino, double peso, int prioridad, int tiempoEstimado) {
        if (codigo == null || codigo.isBlank()){
            throw new IllegalArgumentException("el codigo del paquete debe ser asignado ahora mismo");
        }
        if (destino==null) {
            throw new IllegalArgumentException("el destino del paquete debe decidirse ahora mismo");
        }
        if (peso<0){
            throw new IllegalArgumentException("el peso del paquete no debe ser menor a 0");
        }
        if (prioridad < PRIORIDAD_MINIMA||prioridad > PRIORIDAD_MAX){
            throw new IllegalArgumentException("la prioridad debe estar entre" + PRIORIDAD_MINIMA + "Y" +PRIORIDAD_MAX);
        }
        if(tiempoEstimado<=0){
            throw new IllegalArgumentException("el tiempo estimado debe ser mayor a 0");
        }
        this.codigo = codigo.trim();
        this.destino = destino;
        this.peso = peso;
        this.prioridad = prioridad;
        this.tiempoEstimado = tiempoEstimado;
    }
    public Paquete(String codigo, Destino destino, double peso, int tiempoEstimado){
        this(codigo, destino, peso, PRIORIDAD_PORDEFECTO, tiempoEstimado);
    }
    @Override
    public int compareTo(Paquete otro){
        return this.codigo.compareTo(otro.codigo);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Paquete otro = (Paquete) o;
        return codigo.equals(otro.codigo);
    }

    @Override
    public int hashCode(){
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s [%s, %.1f kg, prioridad %d, %d min]",
                codigo, destino.getNombre(), peso, prioridad, tiempoEstimado);
    }

    public String getCodigo() {
        return codigo;
    }

    public Destino getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }
}
