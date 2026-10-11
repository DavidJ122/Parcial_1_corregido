
package Remodelado.Enum;
import java.text.Normalizer;
//Destino
public enum Destino {
    ARMENIA("Armenia"),
    CALARCA("Calarcá"),
    SALENTO("Salento"),
    MONTENEGRO("Montenegro"),
    QUIMBAYA("Quimbayá"),
    CIRCASIA("Circasia"),
    LA_TEBAIDA("La Tebaida");

    public final String nombre;
    Destino(String nombre){
        this.nombre=nombre;
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
    @Override
    public String toString(){
        return nombre;
    }
}

