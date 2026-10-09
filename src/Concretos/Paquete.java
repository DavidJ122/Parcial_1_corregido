package Concretos;

import java.util.HashMap;
import java.util.Random;
import Enum.Destino;

public class Paquete{
    private String Codigo;
    private Destino destino;
    private float peso;
    private int Prioridad;
    private int Tiempo_estimado;
    private Paquete next;

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


public boolean existe(String t) {
    if (t.equals(this.Codigo)) {
        return true;
    }
    return false;
}


public void add(Paquete nodo) {
    if (this.next.existe(nodo.getCodigo())) {
        throw new IllegalArgumentException("La ID del paquete ya existe");}

    if (this.hasNext()) { this.setNext(nodo);}
    else { this.next.add(nodo);}
}


public Paquete obtener(Paquete nodo) {
    if (this.existe(nodo.getCodigo())){ return this;}
    if (this.hasNext()) { return this.next.obtener(nodo);}
    throw new IllegalArgumentException("El paquete no existe");
}


public Paquete eliminar(Paquete nodo) {
    if (this.existe(nodo.getCodigo())){
        return this.next();
    }
    else if (!this.hasNext()) {
        this.setNext(this.next.eliminar(nodo));
        return this;
    }
    throw new IllegalArgumentException("El paquete no existe");
}


public int Contar() {
    if (!this.hasNext()) { return 1;}
    return 1+this.next.Contar();
}


public boolean hasNext() {
    if (this.next()==null) { return false;}
    return true;
}




public String getCodigo(){
    return this.Codigo;
}

public Paquete next() {
        return this.next;
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

private void setDestino(Destino destino){
    if (destino==null) { throw new IllegalArgumentException("El destino no puede ser nulo");}
    this.destino=destino;
}

private void setPeso(float peso){
    if (peso<=0) { throw new IllegalArgumentException("El peso debe ser mayor a 0");}
    this.peso=peso;

}
private void setPrioridad(int Prioridad){
    if (Prioridad < 1 || Prioridad > 5) { throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5");}
    this.Prioridad=Prioridad;

}

private void setTiempo_estimado(int Tiempo_estimado){
    if (Tiempo_estimado < 0) { throw new IllegalArgumentException("El tiempo estimado debe ser mayor a 0");}
    this.Tiempo_estimado=Tiempo_estimado;
}

private void setNext(Paquete next){
    this.next=next;
}

public int getTiempo_estimado(){
    return this.Tiempo_estimado;
}
public Destino getDestino(){
    return this.destino;
}
public float getPeso(){
    return this.peso;
}
public int getPrioridad(){
    return this.Prioridad;
}

}
