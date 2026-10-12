package Remodelado.Bases.Estructuras;

import Remodelado.Bases.modelo.Paquete;

import java.util.Collection;
//Interfaz para las estructuras de datos.
/* Se realizo la interfaz con la intencion de que las estructuras de datos
tengan un contrato en comun
T: Tipo de colecion de la estructura
J: Tipo de dato que se va a utilizar para buscar un paquete

 */
public interface IEstructura<T,J>{
    //Operaciones comunes a todas las estructuras.
    //Obtiene el tipo de coleccion de paquetes.
    public T getPaquetes();
    //Agregar un paquete a la coleccion.
    public void addPaquete(Paquete paquete);
    //Eliminar un paquete de la coleccion.
    public void removePaquete(Paquete paquete);
    //Buscar un paquete por un ID de tipo J
    public Paquete getPaquete(J ID);
    //Obtiene el tamaño de la coleccion.
    public int getSize();
    //Verdadero para vacio, falso para no vacio.
    public boolean isEmpty();
    //Copia todos los paquetes de una coleccion generica en la coleccion especializada
    public void copyAll(Collection<Paquete> paquetes);
}
