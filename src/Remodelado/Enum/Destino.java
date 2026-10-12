package Remodelado.Enum;

import java.text.Normalizer;

//Destino
public enum Destino {
    Armenia("Armenia"),
    Salento("Salento"),
    Circasia("Circasia"),
    Filandia("Filandia"),
    Montenegro("Montenegro");


    private final String nombre;
    Destino(String nombre){
        this.nombre = nombre;
    }
    public static Destino getDestino(String nombre){
        String nombre_aux = Normalizer.normalize(nombre,Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        for (Destino d : Destino.values()) {
            if (d.nombre.equalsIgnoreCase(nombre_aux)){
                return d;
            }
        }
        throw new IllegalArgumentException("Destino no encontrado: " + nombre);
    }

    @Override
    public String toString(){
        return nombre;
    }

}
