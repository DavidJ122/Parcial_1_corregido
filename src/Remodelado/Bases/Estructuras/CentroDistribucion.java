package Remodelado.Bases.Estructuras;

import Remodelado.Bases.Recursivos.FiltroPesoMajor;
import Remodelado.Bases.Recursivos.FiltroPesoTotal;
import Remodelado.Bases.Recursivos.FiltroPrioridad;
import Remodelado.Bases.modelo.Paquete;
import Remodelado.Bases.Comparadores.*;
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
    public Paquete despacharSiguienteUrgente() {
        if (colaDespacho.isEmpty()) {
            return null;
        }
        this.historialPaquetes.add(colaDespacho.getPaquetes().peek());
        this.registroPorId.removePaquete(colaDespacho.getPaquetes().peek());
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
        // Lógica de impresión usando ComparadorPeso
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