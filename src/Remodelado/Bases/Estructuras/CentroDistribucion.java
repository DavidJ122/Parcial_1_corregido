package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;
import Remodelado.Bases.Comparadores.*;
import Remodelado.ListCustom.List;

/**
 * Clase principal que actúa como Fachada (Facade).
 * Coordina las estructuras de datos propias sin acoplar la lógica de negocio.
 */
public class CentroDistribucion {

    // 1. Atributos: Instancias de las estructuras especializadas que crearon
    private final EstructuraAuditoria historialLlegada;
    private final EstructuraPrioritaria colaDespacho;
    private final EstructuraDestino paquetesPorDestino;
    private final EstructuraOrdenID registroPorId;
    private final List<Paquete> historialPaquetes;

    // (Opcional) Si manejan repartidores en una estructura propia o estándar
    private final EstructuraFIFO colaEntregasNormales;

    public CentroDistribucion(List<Paquete> historialPaquetes) {

        // Inicializamos las estructuras
        this.historialLlegada = new EstructuraAuditoria();
        this.paquetesPorDestino = new EstructuraDestino();
        this.registroPorId = new EstructuraOrdenID();
        this.colaEntregasNormales = new EstructuraFIFO();
        this.historialPaquetes = historialPaquetes; // Lista simplemente enlazada
        // La estructura prioritaria recibe el comparador compuesto complejo
        this.colaDespacho = new EstructuraPrioritaria(new ComparadorDespacho());
    }

    /**
     * REGISTRO COORDINADO: Un paquete entra al sistema y se distribuye
     * en las estructuras correspondientes en O(1) u O(log n).
     */
    public void registrarPaquete(Paquete paquete) {
        if (paquete == null) {
            throw new IllegalArgumentException("El paquete no puede ser nulo");
        }

        // 1. Guardar en el historial de auditoría
        historialLlegada.addPaquete(paquete);

        // 2. Guardar en el índice de búsqueda rápida por ID
        registroPorId.addPaquete(paquete);

        // 3. Agrupar por ciudad destino
        paquetesPorDestino.addPaquete(paquete);

        // 4. Enviar a la cola de prioridad para ser despachado
        colaDespacho.addPaquete(paquete);
    }

    /**
     * DESPACHO PRIORITARIO: Extrae el paquete más urgente según ComparadorDespacho
     */
    public Paquete despacharSiguienteUrgente() {
        if (colaDespacho.isEmpty()) {
            return null;
        }
        this.historialPaquetes.add(colaDespacho.getPaquetes().peek());
        return colaDespacho.getFirst(); // Internamente usa O(log n)
    }

    /**
     * BÚSQUEDA DIRECTA: Utiliza la estructura especializada de IDs
     */
    public Paquete buscarPaquete(String codigoId) {
        return registroPorId.getPaquete(codigoId);
    }

    // ===================================================================
    // GENERACIÓN DE REPORTES (USO DE LOS OTROS COMPARADORES / LAMBDAS)
    // ===================================================================

    /**
     * Ejemplo utilizando las clases comparadoras independientes que crearon
     */
    public void imprimirReportePorPeso() {
        // Asumiendo que historialLlegada puede retornar una lista para ordenar
        // o que tu estructura tiene un método de ordenamiento.
        System.out.println("--- Reporte por Peso (Descendente) ---");
        EstructuraPrioritaria orden_peso = new EstructuraPrioritaria(new ComparadorPeso());
        // Lógica de impresión usando ComparadorPeso
        orden_peso.copyAll(historialLlegada.getPaquetes());
        System.out.println(orden_peso);
    }

    /**
     * Ejemplo utilizando el enfoque Híbrido (Java 17) para impresionar al profesor
     */
    public void imprimirReportePorTiempoEstimado() {
        System.out.println("--- Reporte por Tiempo Estimado (Ascendente) ---");
        EstructuraPrioritaria orden_tiempo = new EstructuraPrioritaria(new ComparadorTiempo());
        orden_tiempo.copyAll(historialLlegada.getPaquetes());
        System.out.println(orden_tiempo);
        // Si tuvieras que ordenar una lista nativa en este punto, usarías:
        // lista.sort(Comparator.comparingInt(Paquete::getTiempoEstimado));
    }
}