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

    public String getNombre() {
        return nombre;
    }

    public static Destino ConvertirTextoDestino(String texto){
        if (texto == null || texto.isBlank()){
            throw new IllegalArgumentException("el destino no puede estar vacio");
        }
        String buscado = normalizar(texto);
        for(Destino destino: values()){
            if (normalizar(destino.nombre).equals(buscado)) {
                return destino;
            }
        }
        throw new IllegalArgumentException("destino desconocido");
    }
    private static String normalizar(String s){
        String SinTildes=Normalizer.normalize(s.trim(),Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return SinTildes.toLowerCase();
    }

}
