import Remodelado.Bases.Comparadores.ComparadorDespacho;
import Remodelado.Bases.Comparadores.ComparadorTiempo;
import Remodelado.Bases.Comparadores.ComparadorPeso;
import Remodelado.Bases.Comparadores.ComparadorPrioritario;
import Remodelado.Bases.Estructuras.*;
import Remodelado.Bases.Paquete;
import Remodelado.Enum.Destino;

import java.util.HashMap;

//Main
public class Main {
    public static void main(String[] args) {
        EstructuraOrdenID estructuraPrincipal = new EstructuraOrdenID();
        EstructuraLlegada estructuraLlegada = new EstructuraLlegada();
        Boolean flag = true;
        while (flag) {
            try {
                generarPaquetes(estructuraPrincipal, estructuraLlegada);
                flag = false;
            } catch (Exception e) {
                System.out.println("Error al generar los paquetes, reintentando");
                estructuraLlegada = new EstructuraLlegada();
                estructuraPrincipal = new EstructuraOrdenID();
            }
        }


       // printID(estructuraPrincipal);
       // printLL(estructuraLlegada);
        //EstructuraDestino estructuraDestino = new EstructuraDestino();
        //printD(estructuraDestino,estructuraLlegada);
        //EstructuraFIFO estructuraFIFO = new EstructuraFIFO();
        //printFIFO(estructuraFIFO,estructuraLlegada);
        EstructuraPrioritaria estructuraPrioritaria = null;
        printPri(estructuraPrioritaria,estructuraLlegada);







    }
    public static void generarPaquetes(EstructuraOrdenID estructuraPrincipal, EstructuraLlegada estructuraLlegada){

        //Declaracion de variables
        HashMap<String, Object> datos1 = new HashMap<>();
        datos1.put("Codigo", "PD000");
        datos1.put("Destino", Destino.Armenia);
        datos1.put("Peso", 100);
        datos1.put("Prioridad", 1);
        datos1.put("Tiempo_estimado", 10);
        Paquete paquete1 = new Paquete(datos1);
        estructuraPrincipal.addPaquete(paquete1);
        estructuraLlegada.addPaquete(paquete1);

        HashMap<String, Object> datos2 = new HashMap<>();
        datos2.put("Destino", Destino.Pereira);
        datos2.put("Peso", 250);
        datos2.put("Prioridad", 3);
        datos2.put("Tiempo_estimado", 20);
        Paquete paquete2 = new Paquete(datos2);
        estructuraPrincipal.addPaquete(paquete2);
        estructuraLlegada.addPaquete(paquete2);


        HashMap<String, Object> datos3 = new HashMap<>();
        datos3.put("Codigo", "PD002");
        datos3.put("Destino", Destino.Circacia);
        datos3.put("Peso", 50);
        datos3.put("Tiempo_estimado", 15);
        Paquete paquete3 = new Paquete(datos3);
        estructuraPrincipal.addPaquete(paquete3);
        estructuraLlegada.addPaquete(paquete3);



        HashMap<String, Object> datos4 = new HashMap<>();
        datos4.put("Codigo", "PD003");
        datos4.put("Destino", Destino.El_valle);
        datos4.put("Peso", 120);
        datos4.put("Prioridad", 5);
        datos4.put("Tiempo_estimado", 30);
        Paquete paquete4 = new Paquete(datos4);
        estructuraPrincipal.addPaquete(paquete4);
        estructuraLlegada.addPaquete(paquete4);

        HashMap<String, Object> datos5 = new HashMap<>();
        datos5.put("Destino", Destino.Armenia);
        datos5.put("Peso", 80);
        datos5.put("Tiempo_estimado", 12);
        Paquete paquete5 = new Paquete(datos5);
        estructuraPrincipal.addPaquete(paquete5);
        estructuraLlegada.addPaquete(paquete5);

        HashMap<String, Object> datos6 = new HashMap<>();
        datos6.put("Codigo", "PD005");
        datos6.put("Destino", Destino.Pereira);
        datos6.put("Peso", 300);
        datos6.put("Prioridad", 1);
        datos6.put("Tiempo_estimado", 25);
        Paquete paquete6 = new Paquete(datos6);
        estructuraPrincipal.addPaquete(paquete6);
        estructuraLlegada.addPaquete(paquete6);

        HashMap<String, Object> datos7 = new HashMap<>();
        datos7.put("Codigo", "PD006");
        datos7.put("Destino", Destino.Circacia);
        datos7.put("Peso", 175);
        datos7.put("Prioridad", 3);
        datos7.put("Tiempo_estimado", 18);
        Paquete paquete7 = new Paquete(datos7);
        estructuraPrincipal.addPaquete(paquete7);
        estructuraLlegada.addPaquete(paquete7);

        HashMap<String, Object> datos8 = new HashMap<>();
        datos8.put("Destino", Destino.El_valle);
        datos8.put("Peso", 60);
        datos8.put("Prioridad", 2);
        datos8.put("Tiempo_estimado", 8);
        Paquete paquete8 = new Paquete(datos8);
        estructuraPrincipal.addPaquete(paquete8);
        estructuraLlegada.addPaquete(paquete8);

        HashMap<String, Object> datos9 = new HashMap<>();
        datos9.put("Codigo", "PD008");
        datos9.put("Destino", Destino.Armenia);
        datos9.put("Peso", 220);
        datos9.put("Tiempo_estimado", 22);
        Paquete paquete9 = new Paquete(datos9);
        estructuraPrincipal.addPaquete(paquete9);
        estructuraLlegada.addPaquete(paquete9);

        HashMap<String, Object> datos10 = new HashMap<>();
        datos10.put("Destino", Destino.Pereira);
        datos10.put("Peso", 90);
        datos10.put("Prioridad", 2);
        datos10.put("Tiempo_estimado", 14);
        Paquete paquete10 = new Paquete(datos10);
        estructuraPrincipal.addPaquete(paquete10);
        estructuraLlegada.addPaquete(paquete10);

        HashMap<String, Object> datos11 = new HashMap<>();
        datos11.put("Codigo", "PD010");
        datos11.put("Destino", Destino.Circacia);
        datos11.put("Peso", 400);
        datos11.put("Prioridad", 4);
        datos11.put("Tiempo_estimado", 35);
        Paquete paquete11 = new Paquete(datos11);
        estructuraPrincipal.addPaquete(paquete11);
        estructuraLlegada.addPaquete(paquete11);

        HashMap<String, Object> datos12 = new HashMap<>();
        datos12.put("Destino", Destino.El_valle);
        datos12.put("Peso", 135);
        datos12.put("Tiempo_estimado", 16);
        Paquete paquete12 = new Paquete(datos12);
        estructuraPrincipal.addPaquete(paquete12);
        estructuraLlegada.addPaquete(paquete12);

        HashMap<String, Object> datos13 = new HashMap<>();
        datos13.put("Codigo", "PD012");
        datos13.put("Destino", Destino.Armenia);
        datos13.put("Peso", 45);
        datos13.put("Prioridad", 5);
        datos13.put("Tiempo_estimado", 7);
        Paquete paquete13 = new Paquete(datos13);
        estructuraPrincipal.addPaquete(paquete13);
        estructuraLlegada.addPaquete(paquete13);

        HashMap<String, Object> datos14 = new HashMap<>();
        datos14.put("Destino", Destino.Pereira);
        datos14.put("Peso", 190);
        datos14.put("Prioridad", 1);
        datos14.put("Tiempo_estimado", 19);
        Paquete paquete14 = new Paquete(datos14);
        estructuraPrincipal.addPaquete(paquete14);
        estructuraLlegada.addPaquete(paquete14);

        HashMap<String, Object> datos15 = new HashMap<>();
        datos15.put("Codigo", "PD014");
        datos15.put("Destino", Destino.Circacia);
        datos15.put("Peso", 275);
        datos15.put("Tiempo_estimado", 28);
        Paquete paquete15 = new Paquete(datos15);
        estructuraPrincipal.addPaquete(paquete15);
        estructuraLlegada.addPaquete(paquete15);

        HashMap<String, Object> datos16 = new HashMap<>();
        datos16.put("Codigo", "PD015");
        datos16.put("Destino", Destino.El_valle);
        datos16.put("Peso", 110);
        datos16.put("Prioridad", 3);
        datos16.put("Tiempo_estimado", 13);
        Paquete paquete16 = new Paquete(datos16);
        estructuraPrincipal.addPaquete(paquete16);
        estructuraLlegada.addPaquete(paquete16);

        HashMap<String, Object> datos17 = new HashMap<>();
        datos17.put("Destino", Destino.Armenia);
        datos17.put("Peso", 320);
        datos17.put("Tiempo_estimado", 32);
        Paquete paquete17 = new Paquete(datos17);
        estructuraPrincipal.addPaquete(paquete17);
        estructuraLlegada.addPaquete(paquete17);

        HashMap<String, Object> datos18 = new HashMap<>();
        datos18.put("Codigo", "PD017");
        datos18.put("Destino", Destino.Pereira);
        datos18.put("Peso", 70);
        datos18.put("Prioridad", 4);
        datos18.put("Tiempo_estimado", 9);
        Paquete paquete18 = new Paquete(datos18);
        estructuraPrincipal.addPaquete(paquete18);
        estructuraLlegada.addPaquete(paquete18);

        HashMap<String, Object> datos19 = new HashMap<>();
        datos19.put("Destino", Destino.Circacia);
        datos19.put("Peso", 155);
        datos19.put("Prioridad", 2);
        datos19.put("Tiempo_estimado", 17);
        Paquete paquete19 = new Paquete(datos19);
        estructuraPrincipal.addPaquete(paquete19);
        estructuraLlegada.addPaquete(paquete19);

        HashMap<String, Object> datos20 = new HashMap<>();
        datos20.put("Codigo", "PD019");
        datos20.put("Destino", Destino.El_valle);
        datos20.put("Peso", 500);
        datos20.put("Tiempo_estimado", 40);
        Paquete paquete20 = new Paquete(datos20);
        estructuraPrincipal.addPaquete(paquete20);
        estructuraLlegada.addPaquete(paquete20);

        HashMap<String, Object> datos21 = new HashMap<>();
        datos21.put("Destino", Destino.Armenia);
        datos21.put("Peso", 95);
        datos21.put("Prioridad", 5);
        datos21.put("Tiempo_estimado", 11);
        Paquete paquete21 = new Paquete(datos21);
        estructuraPrincipal.addPaquete(paquete21);
        estructuraLlegada.addPaquete(paquete21);

        HashMap<String, Object> datos22 = new HashMap<>();
        datos22.put("Codigo", "PD021");
        datos22.put("Destino", Destino.Pereira);
        datos22.put("Peso", 210);
        datos22.put("Prioridad", 2);
        datos22.put("Tiempo_estimado", 23);
        Paquete paquete22 = new Paquete(datos22);
        estructuraPrincipal.addPaquete(paquete22);
        estructuraLlegada.addPaquete(paquete22);

        HashMap<String, Object> datos23 = new HashMap<>();
        datos23.put("Destino", Destino.Circacia);
        datos23.put("Peso", 30);
        datos23.put("Tiempo_estimado", 6);
        Paquete paquete23 = new Paquete(datos23);
        estructuraPrincipal.addPaquete(paquete23);
        estructuraLlegada.addPaquete(paquete23);

        HashMap<String, Object> datos24 = new HashMap<>();
        datos24.put("Codigo", "PD023");
        datos24.put("Destino", Destino.El_valle);
        datos24.put("Peso", 180);
        datos24.put("Prioridad", 1);
        datos24.put("Tiempo_estimado", 21);
        Paquete paquete24 = new Paquete(datos24);
        estructuraPrincipal.addPaquete(paquete24);
        estructuraLlegada.addPaquete(paquete24);

        HashMap<String, Object> datos25 = new HashMap<>();
        datos25.put("Destino", Destino.Armenia);
        datos25.put("Peso", 65);
        datos25.put("Prioridad", 3);
        datos25.put("Tiempo_estimado", 8);
        Paquete paquete25 = new Paquete(datos25);
        estructuraPrincipal.addPaquete(paquete25);
        estructuraLlegada.addPaquete(paquete25);

        HashMap<String, Object> datos26 = new HashMap<>();
        datos26.put("Codigo", "PD025");
        datos26.put("Destino", Destino.Pereira);
        datos26.put("Peso", 350);
        datos26.put("Tiempo_estimado", 34);
        Paquete paquete26 = new Paquete(datos26);
        estructuraPrincipal.addPaquete(paquete26);
        estructuraLlegada.addPaquete(paquete26);

        HashMap<String, Object> datos27 = new HashMap<>();
        datos27.put("Destino", Destino.Circacia);
        datos27.put("Peso", 140);
        datos27.put("Prioridad", 4);
        datos27.put("Tiempo_estimado", 16);
        Paquete paquete27 = new Paquete(datos27);
        estructuraPrincipal.addPaquete(paquete27);
        estructuraLlegada.addPaquete(paquete27);

        HashMap<String, Object> datos28 = new HashMap<>();
        datos28.put("Codigo", "PD027");
        datos28.put("Destino", Destino.El_valle);
        datos28.put("Peso", 230);
        datos28.put("Prioridad", 5);
        datos28.put("Tiempo_estimado", 24);
        Paquete paquete28 = new Paquete(datos28);
        estructuraPrincipal.addPaquete(paquete28);
        estructuraLlegada.addPaquete(paquete28);

        HashMap<String, Object> datos29 = new HashMap<>();
        datos29.put("Destino", Destino.Armenia);
        datos29.put("Peso", 85);
        datos29.put("Tiempo_estimado", 10);
        Paquete paquete29 = new Paquete(datos29);
        estructuraPrincipal.addPaquete(paquete29);
        estructuraLlegada.addPaquete(paquete29);

        HashMap<String, Object> datos30 = new HashMap<>();
        datos30.put("Codigo", "PD029");
        datos30.put("Destino", Destino.Pereira);
        datos30.put("Peso", 420);
        datos30.put("Prioridad", 3);
        datos30.put("Tiempo_estimado", 38);
        Paquete paquete30 = new Paquete(datos30);
        estructuraPrincipal.addPaquete(paquete30);
        estructuraLlegada.addPaquete(paquete30);
    }

    public static void printID(EstructuraOrdenID estructuraOrdenID) {
        System.out.println("Estructura de paquete organizada por ID");
        System.out.println(estructuraOrdenID);
        System.out.println("----------------------------------------");
    }
    public static void printLL(EstructuraLlegada estructuraLlegada) {
        System.out.println("Estructura de paquete organizada por llegada");
        System.out.println(estructuraLlegada);
        System.out.println("----------------------------------------");
    }
    public static void printD(EstructuraDestino estructuraDestino,EstructuraLlegada estructuraLlegada) {

        estructuraDestino.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por destino");
        System.out.println(estructuraDestino);
        System.out.println("----------------------------------------");
    }
    public static void printFIFO(EstructuraFIFO estructuraFIFO, EstructuraLlegada estructuraLlegada) {
        estructuraFIFO.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por FIFO");
        System.out.println(estructuraFIFO);
        System.out.println("Primero de la lista:");
        System.out.println(estructuraFIFO.getFirst());
        System.out.println("Estructura luego de sacar el primero");
        System.out.println(estructuraFIFO);
    }
    public static void printPri(EstructuraPrioritaria estructuraPrioritaria, EstructuraLlegada estructuraLlegada) {
        estructuraPrioritaria = new EstructuraPrioritaria(new ComparadorDespacho());
        estructuraPrioritaria.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por despacho prioritario");
        System.out.println(estructuraPrioritaria);
        System.out.println("--------------------------------------------------");
        estructuraPrioritaria = new EstructuraPrioritaria(new ComparadorTiempo());
        estructuraPrioritaria.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por tiempo");
        System.out.println(estructuraPrioritaria);
        System.out.println("--------------------------------------------------");
        estructuraPrioritaria = new EstructuraPrioritaria(new ComparadorPeso());
        estructuraPrioritaria.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por peso");
        System.out.println(estructuraPrioritaria);
        System.out.println("-----------------------------------------------");
        estructuraPrioritaria = new EstructuraPrioritaria(new ComparadorPrioritario());
        estructuraPrioritaria.copyAll(estructuraLlegada.getPaquetes());
        System.out.println("Estructura de paquete organizada por prioridad");
        System.out.println(estructuraPrioritaria);
    }
}


