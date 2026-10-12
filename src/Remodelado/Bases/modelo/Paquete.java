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
        if (datos.isEmpty()  || !datos.containsKey("Destino") || !datos.containsKey("Peso")  || !datos.containsKey("Tiempo_estimado") )
        { throw new IllegalArgumentException("Faltaron uno o mas datos");}

        if (datos.containsKey("Codigo")) {
            setCodigo((String) datos.get("Codigo"));
        }else{
            setCodigo("");
        }

        setDestino((Destino) datos.get("Destino"));

        int peso = (int) datos.get("Peso");
        setPeso(Float.parseFloat(peso+".0"));

        if (datos.containsKey("Prioridad")) {
            setPrioridad((int) datos.get("Prioridad"));
        }
        else{ this.Prioridad=3;}

        setTiempo_estimado((int) datos.get("Tiempo_estimado"));
    }

    public String getCodigo(){
        return this.Codigo;
    }

    private void setCodigo(String Codigo){
        String Codigo_aux=Codigo;
        if (Codigo.isEmpty()) {
            Codigo_aux = generateCodigo();
        }
        else{Codigo_aux=Codigo;};
        this.Codigo=Codigo_aux;
    }

    private String generateCodigo(){
        Random entero=new Random();
        int random = entero.nextInt(999);
        if (random < 10){
            return "PD000" + random;
        }
        if (random < 100){
            return "PD00" + random;
        }

        return "PD" + entero.nextInt(9999);
    }

    public void setDestino(Destino destino){
        if (destino==null) { throw new IllegalArgumentException("El destino no puede ser nulo");}
        this.destino=destino;
    }

    public Destino getDestino(){
        return this.destino;
    }

    private void setPeso(double peso){
        if (peso<=0) { throw new IllegalArgumentException("El peso debe ser mayor a 0");}
        this.peso=peso;
    }

    public double getPeso(){
        return this.peso;
    }

    private void setPrioridad(int Prioridad){
        if (Prioridad < 1 || Prioridad > 5) { throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5");}
        this.Prioridad=Prioridad;

    }

    public int getPrioridad(){
        return this.Prioridad;
    }

    private void setTiempo_estimado(int Tiempo_estimado){
        if (Tiempo_estimado < 0) { throw new IllegalArgumentException("El tiempo estimado debe ser mayor a 0");}
        this.Tiempo_estimado=Tiempo_estimado;
    }

    public int getTiempo_estimado(){
        return this.Tiempo_estimado;
    }

    public int getPID_Raw(){
        return Integer.parseInt(this.Codigo.substring(2));
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.getCodigo()).append("\n");
        sb.append("Destino: ").append(this.getDestino()).append("\n");
        sb.append("Peso: ").append(this.getPeso()).append("\n");
        sb.append("Prioridad: ").append(this.getPrioridad()).append("\n");
        sb.append("Tiempo_estimado: ").append(this.getTiempo_estimado()).append("\n");
        sb.append("----------------------------------------\n");
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Paquete o) {
        return Integer.compare(this.getPID_Raw(), o.getPID_Raw());
    }
}
