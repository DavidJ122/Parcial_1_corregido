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

    public void asignar(Paquete paquete, Repartidor repartidor) {
        if (!repartidor.estaDisponible()) {
            throw new IllegalStateException("El repartidor " + repartidor.getId() + " no está disponible.");
        }
        if (repartidor.getZona() != paquete.getDestino()) {
            throw new IllegalStateException("La zona del repartidor (" + repartidor.getZona()
                    + ") no coincide con el destino del paquete (" + paquete.getDestino() + ").");
        }
        repartidor.ocupar();
        asignaciones.put(paquete.getCodigo(), repartidor);
    }

    public void liberar(String codigoPaquete) {
        asignaciones.remove(codigoPaquete).liberar();
    }
}
