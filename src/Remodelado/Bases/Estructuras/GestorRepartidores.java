package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import Remodelado.Bases.modelo.Repartidor;
import Remodelado.Enum.Destino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GestorRepartidores {

    private final Set<Repartidor> repartidores = new HashSet<>();
    private final Map<String, Repartidor> repartidoresPorId = new HashMap<>();
    private final Map<String, Repartidor> asignaciones = new HashMap<>();

    public void registrar(Repartidor repartidor) {
        if (repartidor == null) {
            throw new IllegalArgumentException("El repartidor no puede ser nulo.");
        }
        if (!repartidores.add(repartidor)) {
            throw new IllegalArgumentException("Ya existe un repartidor con la identificación " + repartidor.getId());
        }
        repartidoresPorId.put(repartidor.getId(), repartidor);
    }

    public Repartidor buscar(String id) {
        return repartidoresPorId.get(id);
    }

    public boolean estaRegistrado(Repartidor repartidor) {
        return repartidor != null && repartidores.contains(repartidor);
    }

    public List<Repartidor> disponibles(Destino zona) {
        List<Repartidor> resultado = new ArrayList<>();
        for (Repartidor r : repartidores) {
            if (r.estaDisponible() && r.getZona() == zona) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public void asignar(String repartidorID,Paquete paquete) {
        Repartidor repartidor = this.buscar(repartidorID);
        if (repartidor == null) {
            throw new IllegalArgumentException("El repartidor no puede ser nulo.");
        }
        if (!repartidor.estaDisponible()){
            throw new IllegalArgumentException("El repartidor no esta disponible");
        }
        repartidor.ocupar();
        System.out.println("Paquete "+ paquete.getCodigo()+" asignado a " + repartidor.getId());
        asignaciones.put(paquete.getCodigo(), repartidor);
    }

    public void liberar(String codigoPaquete) {
        Repartidor repartidor = asignaciones.get(codigoPaquete);
        if (repartidor == null) {
            throw new IllegalArgumentException("No existe una asignacion para el paquete con codigo " + codigoPaquete );
        }
        asignaciones.remove(codigoPaquete);
        repartidor.liberar();
    }

    public Repartidor consultarRepartidor(String codigoPaquete){
        return asignaciones.get(codigoPaquete);
    }
    public String consultarPaquete(Repartidor repartidor){
        for (Map.Entry<String, Repartidor> entry : asignaciones.entrySet()) {
            if (entry.getValue().equals(repartidor)) {
                return entry.getKey();
            }
        }
        return null;
    }
    public Destino consultarRepartidorDestino(String repartidorID){
        Repartidor repartidor = this.buscar(repartidorID);
        if (repartidor == null) {
            throw new IllegalArgumentException("El repartidor no puede ser nulo.");
        }
        return repartidor.getZona();
    }
    public void consultarRepartidores(boolean disponibles){
        for (Repartidor repartidor : repartidores) {
            if (repartidor.estaDisponible() == disponibles) {
                System.out.println("Repartidor: " + repartidor);
                System.out.println("Zona: " + repartidor.getZona());
                if (!disponibles){
                    System.out.println("Paquete: " + this.consultarPaquete(repartidor));
                }
            }
        }
    }
}
