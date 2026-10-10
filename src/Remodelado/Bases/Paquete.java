package Remodelado.Bases;

import java.util.HashMap;
import java.util.Random;
import Remodelado.Enum.Destino;
//Clase Paquete
public class Paquete implements Comparable<Paquete>{
    private String Codigo;
    private Destino destino;
    private float peso;
    private int Prioridad;
    private int Tiempo_estimado;


    Paquete(HashMap<String,Object> datos){
        if (datos.isEmpty()  || !datos.containsKey("Destino") || !datos.containsKey("Peso")  || !datos.containsKey("Tiempo_estimado") )
        { throw new IllegalArgumentException("Faltaron uno o mas datos");}

        if (datos.containsKey("Codigo")) {
            setCodigo((String) datos.get("Codigo"));
        }else{
            setCodigo("");
        }

        setDestino((Destino) datos.get("Destino"));

        setPeso((float) datos.get("Peso"));

        if (datos.containsKey("Prioridad")) {
            setPrioridad((int) datos.get("Prioridad"));
        }
        else{ this.Prioridad=5;}

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
        return "PQ" + entero.nextInt(999);
    }

    public void setDestino(Destino destino){
        if (destino==null) { throw new IllegalArgumentException("El destino no puede ser nulo");}
        this.destino=destino;
    }

    public Destino getDestino(){
        return this.destino;
    }

    private void setPeso(float peso){
        if (peso<=0) { throw new IllegalArgumentException("El peso debe ser mayor a 0");}
        this.peso=peso;
    }

    public float getPeso(){
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
    public int compareTo(Paquete o) {
        return Integer.compare(this.Prioridad, o.getPrioridad());
    }
}
