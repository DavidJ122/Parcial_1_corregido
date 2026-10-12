import Remodelado.Bases.Comparadores.ComparadorDespacho;
import Remodelado.Bases.Comparadores.ComparadorPeso;
import Remodelado.Bases.Comparadores.ComparadorPrioritario;
import Remodelado.Bases.Comparadores.ComparadorTiempo;
import Remodelado.Bases.Estructuras.*;
import Remodelado.Bases.modelo.Paquete;
import Remodelado.Enum.Destino;

import java.util.HashMap;
import java.util.Scanner;

//Main
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        final CentroDistribucion quindioExpress = new CentroDistribucion();
        generarPaquetes(quindioExpress);
        menuPrincipal(quindioExpress);

    }
    public static void generarPaquetes(CentroDistribucion CD){
        HashMap<String, Object> p1 = new HashMap<>();
        p1.put("Codigo", "PQ027");
        p1.put("Destino", Destino.Armenia);
        p1.put("Peso", 2.5);
        p1.put("Prioridad", 3);
        p1.put("Tiempo_estimado", 12);

        HashMap<String, Object> p2 = new HashMap<>();
        p2.put("Codigo", "PQ004");
        p2.put("Destino", Destino.Salento);
        p2.put("Peso", 1.2);
        p2.put("Prioridad", 5);
        p2.put("Tiempo_estimado", 25);

        HashMap<String, Object> p3 = new HashMap<>();
        p3.put("Codigo", "PQ019");
        p3.put("Destino", Destino.Circasia);
        p3.put("Peso", 4.8);
        p3.put("Tiempo_estimado", 18);

        HashMap<String, Object> p4 = new HashMap<>();
        p4.put("Codigo", "PQ002");
        p4.put("Destino", Destino.Filandia);
        p4.put("Peso", 3.1);
        p4.put("Prioridad", 2);
        p4.put("Tiempo_estimado", 30);

        HashMap<String, Object> p5 = new HashMap<>();
        p5.put("Codigo", "PQ025");
        p5.put("Destino", Destino.Montenegro);
        p5.put("Peso", 0.8);
        p5.put("Prioridad", 4);
        p5.put("Tiempo_estimado", 10);

        HashMap<String, Object> p6 = new HashMap<>();
        p6.put("Codigo", "PQ011");
        p6.put("Destino", Destino.Armenia);
        p6.put("Peso", 6.0);
        p6.put("Prioridad", 1);
        p6.put("Tiempo_estimado", 15);

        HashMap<String, Object> p7 = new HashMap<>();
        p7.put("Codigo", "PQ030");
        p7.put("Destino", Destino.Salento);
        p7.put("Peso", 2.3);
        p7.put("Tiempo_estimado", 28);

        HashMap<String, Object> p8 = new HashMap<>();
        p8.put("Codigo", "PQ008");
        p8.put("Destino", Destino.Circasia);
        p8.put("Peso", 1.7);
        p8.put("Prioridad", 3);
        p8.put("Tiempo_estimado", 14);

        HashMap<String, Object> p9 = new HashMap<>();
        p9.put("Codigo", "PQ016");
        p9.put("Destino", Destino.Filandia);
        p9.put("Peso", 5.2);
        p9.put("Prioridad", 5);
        p9.put("Tiempo_estimado", 35);

        HashMap<String, Object> p10 = new HashMap<>();
        p10.put("Codigo", "PQ001");
        p10.put("Destino", Destino.Montenegro);
        p10.put("Peso", 3.6);
        p10.put("Prioridad", 2);
        p10.put("Tiempo_estimado", 20);

        HashMap<String, Object> p11 = new HashMap<>();
        p11.put("Codigo", "PQ022");
        p11.put("Destino", Destino.Armenia);
        p11.put("Peso", 1.1);
        p11.put("Prioridad", 4);
        p11.put("Tiempo_estimado", 8);

        HashMap<String, Object> p12 = new HashMap<>();
        p12.put("Codigo", "PQ006");
        p12.put("Destino", Destino.Salento);
        p12.put("Peso", 7.4);
        p12.put("Prioridad", 1);
        p12.put("Tiempo_estimado", 40);

        HashMap<String, Object> p13 = new HashMap<>();
        p13.put("Codigo", "PQ013");
        p13.put("Destino", Destino.Circasia);
        p13.put("Peso", 2.9);
        p13.put("Prioridad", 3);
        p13.put("Tiempo_estimado", 16);

        HashMap<String, Object> p14 = new HashMap<>();
        p14.put("Codigo", "PQ029");
        p14.put("Destino", Destino.Filandia);
        p14.put("Peso", 0.5);
        p14.put("Tiempo_estimado", 32);

        HashMap<String, Object> p15 = new HashMap<>();
        p15.put("Codigo", "PQ009");
        p15.put("Destino", Destino.Montenegro);
        p15.put("Peso", 4.2);
        p15.put("Prioridad", 5);
        p15.put("Tiempo_estimado", 22);

        HashMap<String, Object> p16 = new HashMap<>();
        p16.put("Codigo", "PQ018");
        p16.put("Destino", Destino.Armenia);
        p16.put("Peso", 8.1);
        p16.put("Prioridad", 2);
        p16.put("Tiempo_estimado", 11);

        HashMap<String, Object> p17 = new HashMap<>();
        p17.put("Codigo", "PQ003");
        p17.put("Destino", Destino.Salento);
        p17.put("Peso", 3.4);
        p17.put("Prioridad", 4);
        p17.put("Tiempo_estimado", 27);

        HashMap<String, Object> p18 = new HashMap<>();
        p18.put("Codigo", "PQ024");
        p18.put("Destino", Destino.Circasia);
        p18.put("Peso", 1.9);
        p18.put("Prioridad", 1);
        p18.put("Tiempo_estimado", 13);

        HashMap<String, Object> p19 = new HashMap<>();
        p19.put("Codigo", "PQ012");
        p19.put("Destino", Destino.Filandia);
        p19.put("Peso", 6.3);
        p19.put("Prioridad", 3);
        p19.put("Tiempo_estimado", 38);

        HashMap<String, Object> p20 = new HashMap<>();
        p20.put("Codigo", "PQ020");
        p20.put("Destino", Destino.Montenegro);
        p20.put("Peso", 2.1);
        p20.put("Prioridad", 5);
        p20.put("Tiempo_estimado", 17);

        HashMap<String, Object> p21 = new HashMap<>();
        p21.put("Codigo", "PQ005");
        p21.put("Destino", Destino.Armenia);
        p21.put("Peso", 3.8);
        p21.put("Tiempo_estimado", 9);

        HashMap<String, Object> p22 = new HashMap<>();
        p22.put("Codigo", "PQ026");
        p22.put("Destino", Destino.Salento);
        p22.put("Peso", 5.5);
        p22.put("Prioridad", 2);
        p22.put("Tiempo_estimado", 31);

        HashMap<String, Object> p23 = new HashMap<>();
        p23.put("Codigo", "PQ015");
        p23.put("Destino", Destino.Circasia);
        p23.put("Peso", 0.9);
        p23.put("Prioridad", 4);
        p23.put("Tiempo_estimado", 19);

        HashMap<String, Object> p24 = new HashMap<>();
        p24.put("Codigo", "PQ007");
        p24.put("Destino", Destino.Filandia);
        p24.put("Peso", 4.6);
        p24.put("Prioridad", 1);
        p24.put("Tiempo_estimado", 26);

        HashMap<String, Object> p25 = new HashMap<>();
        p25.put("Codigo", "PQ021");
        p25.put("Destino", Destino.Montenegro);
        p25.put("Peso", 2.7);
        p25.put("Prioridad", 3);
        p25.put("Tiempo_estimado", 14);

        HashMap<String, Object> p26 = new HashMap<>();
        p26.put("Codigo", "PQ014");
        p26.put("Destino", Destino.Armenia);
        p26.put("Peso", 9.2);
        p26.put("Prioridad", 5);
        p26.put("Tiempo_estimado", 42);

        HashMap<String, Object> p27 = new HashMap<>();
        p27.put("Codigo", "PQ028");
        p27.put("Destino", Destino.Salento);
        p27.put("Peso", 1.4);
        p27.put("Tiempo_estimado", 24);

        HashMap<String, Object> p28 = new HashMap<>();
        p28.put("Codigo", "PQ010");
        p28.put("Destino", Destino.Circasia);
        p28.put("Peso", 3.3);
        p28.put("Prioridad", 2);
        p28.put("Tiempo_estimado", 21);

        HashMap<String, Object> p29 = new HashMap<>();
        p29.put("Codigo", "PQ023");
        p29.put("Destino", Destino.Filandia);
        p29.put("Peso", 5.7);
        p29.put("Prioridad", 4);
        p29.put("Tiempo_estimado", 33);

        HashMap<String, Object> p30 = new HashMap<>();
        p30.put("Codigo", "PQ017");
        p30.put("Destino", Destino.Montenegro);
        p30.put("Peso", 1.6);
        p30.put("Prioridad", 1);
        p30.put("Tiempo_estimado", 7);

// Registro de paquetes
        Paquete paquete1 = new Paquete(p1);
        CD.registrarPaquete(paquete1);

        Paquete paquete2 = new Paquete(p2);
        CD.registrarPaquete(paquete2);

        Paquete paquete3 = new Paquete(p3);
        CD.registrarPaquete(paquete3);

        Paquete paquete4 = new Paquete(p4);
        CD.registrarPaquete(paquete4);

        Paquete paquete5 = new Paquete(p5);
        CD.registrarPaquete(paquete5);

        Paquete paquete6 = new Paquete(p6);
        CD.registrarPaquete(paquete6);

        Paquete paquete7 = new Paquete(p7);
        CD.registrarPaquete(paquete7);

        Paquete paquete8 = new Paquete(p8);
        CD.registrarPaquete(paquete8);

        Paquete paquete9 = new Paquete(p9);
        CD.registrarPaquete(paquete9);

        Paquete paquete10 = new Paquete(p10);
        CD.registrarPaquete(paquete10);

        Paquete paquete11 = new Paquete(p11);
        CD.registrarPaquete(paquete11);

        Paquete paquete12 = new Paquete(p12);
        CD.registrarPaquete(paquete12);

        Paquete paquete13 = new Paquete(p13);
        CD.registrarPaquete(paquete13);

        Paquete paquete14 = new Paquete(p14);
        CD.registrarPaquete(paquete14);

        Paquete paquete15 = new Paquete(p15);
        CD.registrarPaquete(paquete15);

        Paquete paquete16 = new Paquete(p16);
        CD.registrarPaquete(paquete16);

        Paquete paquete17 = new Paquete(p17);
        CD.registrarPaquete(paquete17);

        Paquete paquete18 = new Paquete(p18);
        CD.registrarPaquete(paquete18);

        Paquete paquete19 = new Paquete(p19);
        CD.registrarPaquete(paquete19);

        Paquete paquete20 = new Paquete(p20);
        CD.registrarPaquete(paquete20);

        Paquete paquete21 = new Paquete(p21);
        CD.registrarPaquete(paquete21);

        Paquete paquete22 = new Paquete(p22);
        CD.registrarPaquete(paquete22);

        Paquete paquete23 = new Paquete(p23);
        CD.registrarPaquete(paquete23);

        Paquete paquete24 = new Paquete(p24);
        CD.registrarPaquete(paquete24);

        Paquete paquete25 = new Paquete(p25);
        CD.registrarPaquete(paquete25);

        Paquete paquete26 = new Paquete(p26);
        CD.registrarPaquete(paquete26);

        Paquete paquete27 = new Paquete(p27);
        CD.registrarPaquete(paquete27);

        Paquete paquete28 = new Paquete(p28);
        CD.registrarPaquete(paquete28);

        Paquete paquete29 = new Paquete(p29);
        CD.registrarPaquete(paquete29);

        Paquete paquete30 = new Paquete(p30);
        CD.registrarPaquete(paquete30);
    }
    public static void menuPrincipal(CentroDistribucion CD){
        int opcion ;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Administracion de paquetes");
            System.out.println("2. Consultar paquetes");
            System.out.println("3. Imprimir reporte");
            System.out.println("4. Reportes especiales");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    menuAdministracion(CD);
                    break;
                case 2:
                    consultarPaquetes(CD);
                    break;
                case 3:
                    imprimirReporte(CD);
                    break;
                case 4:
                    reportesEspeciales(CD);
                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion !=5);
        sc.close();
    }
    public static void imprimirReporte(CentroDistribucion CD){
        int opcion;
        do{
            System.out.println("\n===== Reportes =====");
            System.out.println("1. Reporte de paquetes por prioridad");
            System.out.println("2. Reporte de paquetes por despacho");
            System.out.println("3. Reporte de paquetes por peso");
            System.out.println("4. Reporte de paquetes por tiempo estimado");
            System.out.println("5. Reporte de historial de paquetes");
            System.out.println("6. Volver al menu principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    CD.imprimirReportePorComparador(new ComparadorPrioritario());
                    break;
                case 2:
                    CD.imprimirReportePorComparador(new ComparadorDespacho());
                    break;
                case 3:
                    CD.imprimirReportePorComparador(new ComparadorPeso());
                    break;
                case 4:
                    CD.imprimirReportePorComparador(new ComparadorTiempo());
                    break;
                case 5:
                    CD.imprimirReportePorTipoEstructura("ListaSimple");
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion !=6);
    }
    public static void consultarPaquetes(CentroDistribucion CD){
        int opcion;
        do{
            System.out.println("\n===== Consulta de paquetes =====");
            System.out.println("1. Consultar paquete individual por codigo");
            System.out.println("2. Consultar paquetes ordenados por destino");
            System.out.println("3. Consultar paquete ordenados por orden de llegada");
            System.out.println("4. Consultar paquete ordenados por orden de ID");
            System.out.println("5. Consultar paquete ordenados por orden de despacho");
            System.out.println("6. Volver al menu principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese codigo del paquete a consultar: ");
                    String codigo;
                    codigo = sc.nextLine();
                    System.out.println("\n" + CD.buscarPaquete(codigo));
                    break;
                case 2:
                    CD.imprimirReportePorTipoEstructura("Destino");
                    break;
                case 3:
                    CD.imprimirReportePorTipoEstructura("Auditoria");
                    break;
                case 4:
                    CD.imprimirReportePorTipoEstructura("OrdenID");
                    break;
                case 5:
                    CD.imprimirReportePorTipoEstructura("Despacho");
                    break;
                case 6:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion !=6);
    }
    public static void menuAdministracion(CentroDistribucion CD){
        int opcion;
        do{
            System.out.println("\n===== Administracion de paquetes =====");
            System.out.println("1. Crear paquete");
            System.out.println("2. Eliminar paquete");
            System.out.println("3. Obtener siguiente paquete por despachar");
            System.out.println("4. Volver al menu principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    crearPaquete(CD);
                    break;
                case 2:
                    System.out.println("Ingrese codigo del paquete a eliminar: ");
                    String codigo = sc.nextLine();
                    CD.eliminarPaquete(codigo);
                    break;
                case 3:
                    System.out.println("El siguiente paquete a despachar es: ");
                    System.out.println(CD.despacharSiguienteUrgente());
                    break;
                case 4:
                    System.out.println("Volviendo al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }

        }while(opcion !=4);
    }
    public static void crearPaquete(CentroDistribucion CD) {
        System.out.println("===== Creacion de paquete =====");

        String codigo;
        Destino destino = null;
        double peso;
        int prioridad;
        int tiempo_estimado;
        boolean valido;

// Codigo
        do {
            System.out.println("Ingrese codigo del paquete (PQXXX): ");
            codigo = sc.nextLine();

            valido = !codigo.matches("PQ[0-9]{3}");

            if (valido) {
                System.out.println("El codigo debe tener el formato PQXXX");
            } else if (CD.buscarPaquete(codigo) != null) {
                System.out.println("El codigo ya existe");
                valido = true;
            }
        } while (valido);

// Destino
        do {
            System.out.println("Ingrese destino (Armenia, Salento, Circasia, Filandia, Montenegro): ");

            try {
                destino = Destino.getDestino(sc.nextLine());
                valido = false;
            } catch (Exception e) {
                System.out.println("Destino no valido");
                valido = true;
            }
        } while (valido);

// Peso
        while (true) {
            System.out.println("Ingrese peso del paquete: ");

            try {
                peso = Double.parseDouble(sc.nextLine());

                if (peso > 0) {
                    break;
                }

                System.out.println("El peso debe ser mayor a 0");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un peso numerico valido");
            }
        }

// Prioridad (opcional)
        while (true) {
            System.out.println("Ingrese prioridad (1-5) o presione Enter para omitirla: ");
            String entrada = sc.nextLine();

            if (entrada.isBlank()) {
                prioridad = 0;
                break;
            }

            try {
                prioridad = Integer.parseInt(entrada);

                if (prioridad >= 1 && prioridad <= 5) {
                    break;
                }

                System.out.println("La prioridad debe estar entre 1 y 5");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido");
            }
        }

// Tiempo estimado
        while (true) {
            System.out.println("Ingrese tiempo estimado del paquete: ");

            try {
                tiempo_estimado = Integer.parseInt(sc.nextLine());

                if (tiempo_estimado > 0) {
                    break;
                }

                System.out.println("El tiempo estimado debe ser mayor a 0");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero entero valido");
            }
        }

// Crear y registrar paquete
        HashMap<String, Object> datos = new HashMap<>();
        datos.put("Codigo", codigo);
        datos.put("Destino", destino);
        datos.put("Peso", peso);

        if (prioridad != 0) {
            datos.put("Prioridad", prioridad);
        }

        datos.put("Tiempo_estimado", tiempo_estimado);

        CD.registrarPaquete(new Paquete(datos));

        System.out.println("Paquete registrado correctamente.");
    }
    public static void reportesEspeciales(CentroDistribucion CD){
        int opcion;
        do{
            System.out.println("\n===== Reporte especial de paquetes =====");
            System.out.println("1. Reporte especial: El mayor peso de paquetes");
            System.out.println("2. Reporte especial: El peso total por destino");
            System.out.println("3. Reporte especial: Paquetes por prioridad minima");
            System.out.println("4. Volver al menu principal");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    CD.imprimirReportesEspecialesPesoMayor();
                    break;
                case 2:
                    Destino destino = null;
                    boolean valido;
                    do {
                        System.out.println("Ingrese destino (Armenia, Salento, Circasia, Filandia, Montenegro): ");
                        try {
                            destino = Destino.getDestino(sc.nextLine());
                            valido = false;
                        } catch (Exception e) {
                            System.out.println("Destino no valido");
                            valido = true;
                        }
                    } while (valido);
                    CD.imprimirReportesEspecialesPesoTotal(destino);
                case 3:
                    int prioridad;
                    while (true) {
                        System.out.println("Ingrese prioridad (1-5): ");
                        String entrada = sc.nextLine();
                        try {
                            prioridad = Integer.parseInt(entrada);

                            if (prioridad >= 1 && prioridad <= 5) {
                                break;
                            }

                            System.out.println("La prioridad debe estar entre 1 y 5");
                        } catch (NumberFormatException e) {
                            System.out.println("Ingrese un numero entero valido");
                        }
                    }
                    CD.imprimirReportesEspecialesPrioridadMinima(prioridad);
                case 4:
                    System.out.println("Volver al menu principal");
                default:
                    System.out.println("Opcion no valida");
            }
        }while(opcion !=4);
    }
}


