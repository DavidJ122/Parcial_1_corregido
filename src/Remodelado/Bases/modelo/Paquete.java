package Remodelado.Bases.modelo;

import java.util.HashMap;
import java.util.Random;
import Remodelado.Enum.Destino;
//Clase Paquete
public class Paquete implements Comparable<Paquete>{
    private String Codigo;
    private Destino destino;
    private double peso;
    private int Prioridad;
    private int Tiempo_estimado;

    //Constructor: Necesita un hashmap con los datos del paquete
    // Codigo: El PID del paquete (Opcional)
    // Destino: El destino del paquete
    // Peso: El peso del paquete
    // Prioridad: La prioridad del paquete (Opcional)
    // Tiempo_estimado: El tiempo estimado de entrega del paquete
    // Las llaves del hashmap deben ser: "Codigo", "Destino", "Peso", "Prioridad", "Tiempo_estimado"
    public Paquete(HashMap<String, Object> datos){
        //Validar que los datos sean correctos
        //Destino, Peso, Tiempo_estimado no deben de estar vacios
        if (datos.isEmpty()  || !datos.containsKey("Destino") || !datos.containsKey("Peso")  || !datos.containsKey("Tiempo_estimado") )
        { throw new IllegalArgumentException("Faltaron uno o mas datos");}

        //Si el hashmap contiene el codigo, se le asigna el codigo, sino se genera uno aleatorio
        if (datos.containsKey("Codigo")) {
            setCodigo((String) datos.get("Codigo"));
        }else{
            setCodigo("");
        }
        //Asignar el destino
        setDestino((Destino) datos.get("Destino"));
        //Asignar el peso
        setPeso((double) datos.get("Peso"));
        //Si el hashmap contiene la prioridad, se le asigna la prioridad, sino se asigna la prioridad por defecto (3)
        if (datos.containsKey("Prioridad")) {
            setPrioridad((int) datos.get("Prioridad"));
        }
        else{ this.Prioridad=3;}
        //Asignar el tiempo estimado
        setTiempo_estimado((int) datos.get("Tiempo_estimado"));
    }

    //Devuelve el codigo del paquete
    public String getCodigo(){
        return this.Codigo;
    }
    //Asigna el codigo al paquete, en caso de que el codigo este vacio, se genera uno aleatorio
    private void setCodigo(String Codigo){
        String Codigo_aux= "";
        if (Codigo.isEmpty()) {
            Codigo_aux = generateCodigo();
        }
        else{Codigo_aux=Codigo;};
        this.Codigo=Codigo_aux;
    }
    //Genera un codigo aleatorio, con el formato "PDXXXX"
    private String generateCodigo(){
        Random entero=new Random();
        int random = entero.nextInt(999);
        if (random < 10){
            return "PQ00" + random;
        }
        if (random < 100){
            return "PQ0" + random;
        }

        return "PQ" + entero.nextInt(999);
    }
    //Asigna el destino al paquete
    //En caso de que el destino sea nulo, se lanza una excepcion
    private void setDestino(Destino destino){
        if (destino==null) { throw new IllegalArgumentException("El destino no puede ser nulo");}
        this.destino=destino;
    }
    //Devuelve el destino del paquete
    public Destino getDestino(){
        return this.destino;
    }

    //Asigna el peso al paquete
    //En caso de que el peso sea menor o igual a 0, se lanza una excepcion
    private void setPeso(double peso){
        if (peso<=0) { throw new IllegalArgumentException("El peso debe ser mayor a 0");}
        this.peso=peso;
    }
    //Devuelve el peso del paquete
    public double getPeso(){
        return this.peso;
    }
    //Asigna la prioridad al paquete
    //En caso de que la prioridad sea menor que 1 o mayor que 5, se lanza una excepcion
    private void setPrioridad(int Prioridad){
        if (Prioridad < 1 || Prioridad > 5) { throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5");}
        this.Prioridad=Prioridad;

    }
    //Devuelve la prioridad del paquete
    public int getPrioridad(){
        return this.Prioridad;
    }
    //Asigna el tiempo estimado al paquete
    //En caso de que el tiempo estimado sea menor o igual que 0, se lanza una excepcion
    private void setTiempo_estimado(int Tiempo_estimado){
        if (Tiempo_estimado <= 0) { throw new IllegalArgumentException("El tiempo estimado debe ser mayor a 0");}
        this.Tiempo_estimado=Tiempo_estimado;
    }
    //Devuelve el tiempo estimado del paquete
    public int getTiempo_estimado(){
        return this.Tiempo_estimado;
    }

    //Devuelve el PID del paquete sin el prefijo "PD", util para comparaciones entre codigo
    public int getPID_Raw(){
        return Integer.parseInt(this.Codigo.substring(2));
    }
    //Imprime los datos del paquete
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.getCodigo()).append("|");
        sb.append("Destino: ").append(this.getDestino()).append("|");
        sb.append("Peso: ").append(this.getPeso()).append(" kg").append("|");
        sb.append("Prioridad: ").append(this.getPrioridad()).append("|");
        sb.append("Tiempo_estimado: ").append(this.getTiempo_estimado()).append("|");
        sb.append("----------------------------------------\n");
        return sb.toString();
    }
    //Compara dos paquetes por el codigo"
    @Override
    public int compareTo(Paquete o) {
        return this.getCodigo().compareTo(o.getCodigo());
    }

    //Compara dos paquetes por su hashcode
    @Override
    public boolean equals(Object o) {
        return o.hashCode() == this.hashCode();
    }


}
