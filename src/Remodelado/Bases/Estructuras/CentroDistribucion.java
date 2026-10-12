package Remodelado.Bases.Estructuras;

import Remodelado.Bases.Recursivos.FiltroPesoMajor;
import Remodelado.Bases.Recursivos.FiltroPesoTotal;
import Remodelado.Bases.Recursivos.FiltroPrioridad;
import Remodelado.Bases.modelo.Paquete;
import Remodelado.Bases.Comparadores.*;
import Remodelado.Bases.modelo.Repartidor;
import Remodelado.Enum.Destino;
import Remodelado.ListCustom.List;

import java.util.Comparator;
import java.util.Scanner;

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
    private final GestorRepartidores gestorRepartidores;

    // (Opcional) Si manejan repartidores en una estructura propia o estándar
    private final EstructuraFIFO colaEntregasNormales;

    public CentroDistribucion() {

        // Inicializamos las estructuras
        this.historialLlegada = new EstructuraAuditoria();
        this.paquetesPorDestino = new EstructuraDestino();
        this.registroPorId = new EstructuraOrdenID();
        this.colaEntregasNormales = new EstructuraFIFO();
        this.historialPaquetes = new List<>();
        // La estructura prioritaria recibe el comparador compuesto complejo
        this.colaDespacho = new EstructuraPrioritaria(new ComparadorDespacho());
        this.gestorRepartidores = new GestorRepartidores();
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
     * ELIMINACION COORDINADA: Un paquete sale del sistema y se elimina de las estructuras
     */
    public void eliminarPaquete(String codigoId) {
        Paquete paqueteEliminado = buscarPaquete(codigoId);
        try{
            this.historialLlegada.removePaquete(paqueteEliminado);
        }catch(Exception e){
            System.out.println("[Warning] El paquete no existe en el historial de llegada");
        }
        try{
            this.registroPorId.removePaquete(paqueteEliminado);
        }catch (Exception e){
            System.out.println("[Warning] El paquete no existe en el registro organizado por ID");
        }
        try{
            this.paquetesPorDestino.removePaquete(paqueteEliminado);

        }catch (Exception e){
            System.out.println("[Warning] El paquete no existe en el registro por destino");
        }
        try{
            this.colaDespacho.removePaquete(paqueteEliminado);
        }
        catch (Exception e){
            System.out.println("[Warning] El paquete no existe en la cola de prioridad");
        }
        try{
            this.colaEntregasNormales.removePaquete(paqueteEliminado);
        }catch(Exception e){
            System.out.println("[Warning] El paquete no existe en las estructuras auxiliares");
        }
        try{
            this.historialLlegada.removePaquete(paqueteEliminado);
        }
        catch (Exception e){
            System.out.println("[Warning] El paquete no existe en el historial de llegada");
        }
    }
    /**
     * DESPACHO PRIORITARIO: Extrae el paquete más urgente según ComparadorDespacho
     */
    public Paquete despacharSiguienteUrgente(EstructuraPrioritaria colaDestino) {
        if (colaDestino.isEmpty()) {
            return null;
        }
        Paquete paquete = colaDestino.getPaquetes().peek();
        if (paquete == null) {
            return null;
        }
        this.historialPaquetes.add(paquete);
        this.registroPorId.removePaquete(paquete);
        this.paquetesPorDestino.removePaquete(paquete);
        this.colaDespacho.removePaquete(paquete);
        return colaDestino.getFirst(); // Internamente usa O(log n)
    }

    /**
     * REGISTRO: Un repartidor se registra en el sistema
     */
    public void registrarRepartidor(Repartidor repartidor) {
        gestorRepartidores.registrar(repartidor);
    }
    /**
     * BUSQUEDA: Un repartidor se busca por su ID
     */
    public Repartidor buscarRepartidor(String id){
        Repartidor repartidor = gestorRepartidores.buscar(id);
        if(repartidor == null){
            System.out.println("El repartidor con el ID " + id + " no existe");
            return null;
        }else{
            System.out.println("El repartidor con el ID " + id + " existe");
            return repartidor;
        }

    }
    /**
     * BÚSQUEDA DIRECTA: Utiliza la estructura especializada de IDs
     */
    public Paquete buscarPaquete(String codigoId) {
        return registroPorId.getPaquete(codigoId);
    }

    /**
     * Se asigna un repartidor a un paquete en caso de que exista disponibilidad
     */
    public void asignacionRepartidor(String repartidorID){
        EstructuraPrioritaria colaDestino = new EstructuraPrioritaria(new ComparadorDespacho());
        colaDestino.copyAll(this.paquetesPorDestino.getDestinoPaquete(this.gestorRepartidores.consultarRepartidorDestino(repartidorID)));
        Paquete paquete = this.despacharSiguienteUrgente(colaDestino);
        try {
            gestorRepartidores.asignar(repartidorID,paquete);
        }catch (Exception e){
            System.out.println("No hay repartidores disponibles");
            this.registrarPaquete(paquete);
            this.historialPaquetes.del(paquete);
        }
    }

    /**
     * Libera un repartidor de un paquete
     * @param codigoId
     */
    public void liberacionRepartidor(String codigoId){
        gestorRepartidores.liberar(codigoId);
    }

    /**
     * Consulta el paquete asignado a un repartidor
     * @param repartidor
     */
    public void consultarPaquete(Repartidor repartidor){
        System.out.println("El repartidor " + repartidor.getNombre()
                + " tiene asignado el paquete: "+ this.gestorRepartidores.consultarPaquete(repartidor));
    }

    /**
     * Consulta el repartidor asignado a un paquete
     * @param idPaquete
     */
    public void consultarRepartidor(String idPaquete){
        System.out.println("El paquete con id " + idPaquete + " tiene asignado el repartidor: " + this.gestorRepartidores.consultarRepartidor(idPaquete));
    }

    public void consultarRepartidores(boolean Disponibles){
        System.out.println("--- Disponibilidad de repartidores ---");
        gestorRepartidores.consultarRepartidores(Disponibles);
    }

    // ===================================================================
    // GENERACIÓN DE REPORTES (USO DE LOS OTROS COMPARADORES / LAMBDAS)
    // ===================================================================

    /**
     * Ejemplo utilizando las clases comparadoras independientes que crearon
     */
    public void imprimirReportePorComparador(Comparator<Paquete> comparador) {
        if (comparador == null) {
            throw new IllegalArgumentException("El comparador no puede ser nulo");
        }
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        sb.append("--- Reporte por ");
        switch (comparador.getClass().getSimpleName()) {
            case "ComparadorPrioritario":
                sb.append("Prioridad (Descendente) ---");
                break;
            case "ComparadorTiempo":
                sb.append("Tiempo Estimado (Ascendente) ---");
                break;
            case "ComparadorPeso":
                sb.append("Peso (Descendente) ---");
                break;
            case "ComparadorDespacho":
                sb.append("Despacho (Prioridad>Tiempo>Codigo) ---"); break;
                default: sb.append("sin especificar ---"); break;
        }
        System.out.println(sb);
        EstructuraPrioritaria orden_comparator = new EstructuraPrioritaria(comparador);
        // Lógica de impresión usando un comp
        orden_comparator.copyAll(historialLlegada.getPaquetes());
        System.out.println(orden_comparator);
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }

    /**
     * Ejemplo mostrando el orden de las distintas estructuras
     */
    public void imprimirReportePorTipoEstructura(String tipoEstructura) {
        System.out.println("--- Reporte por " + tipoEstructura + " ---");
        Scanner sc = new Scanner(System.in);
        switch (tipoEstructura) {
            case "Auditoria":
                System.out.println(historialLlegada);
                break;
            case "Destino":
                System.out.println(paquetesPorDestino);
                break;
            case "OrdenID":
                System.out.println(registroPorId);
                break;
            case "Despacho":
                System.out.println(colaDespacho);
                break;
            case "ListaSimple":
                System.out.println(historialPaquetes);
                break;
        }
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }
    /**
     *
     */
    public void imprimirReportesEspecialesPesoMayor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Reporte Especial ---");
        System.out.println("El mayor peso del conjunto de paquetes es:");
        System.out.println(new FiltroPesoMajor(this.historialLlegada.getPaquetes()).buscar());
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }
    public void imprimirReportesEspecialesPesoTotal(Destino destino){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Reporte Especial ---");
        System.out.println("El total de peso de los paquetes del destino " + destino + " es:");
        Destino destino_filtro = Destino.getDestino(destino.toString());
        System.out.println(new FiltroPesoTotal(this.paquetesPorDestino.getPaquetes().get(destino_filtro)).filtrar());
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }

    public void imprimirReportesEspecialesPrioridadMinima(int prioridad){
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Reporte Especial ---");
        System.out.println("La cantidad de paquetes con prioridad " + prioridad + " o mayor son:");
        System.out.println(new FiltroPrioridad(this.historialLlegada.getPaquetes()).filtrar(prioridad));
        System.out.println("Presione Enter para continuar...");
        sc.nextLine();
    }

}