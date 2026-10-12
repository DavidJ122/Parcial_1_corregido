package Remodelado.ListCustom;

import java.util.NoSuchElementException;

//Nodo de la lista
/*
Almacena un dato de tipo T y un puntero al siguiente nodo.
Es comandada por la lista.
Realiza las operaciones de agregar, eliminar, buscar, etc mediante recursividad.
 */
public class Nodo<T>{
    private T dato;
    private Nodo<T> next = null;
    //Constructor
    Nodo(T dato){
        this.dato = dato;
    }
    //Recorre los nodos hasta encontrar el final, luego agrega el nodo al final.
    public void add(Nodo<T> nodo){
      if (next == null){
          this.setNext(nodo);
      }
      else{
          next.add(nodo);
      }
    };
    //Establece el siguiente nodo.
    private void setNext(Nodo<T> nodo){
        this.next = nodo;
    }
    //Busca el nodo con el dato dado mediante recursividad.
    public T get(T dato_nuevo){
        if (this.equal(dato_nuevo)){
            return dato;
        }
        if (next == null){
            return null;
        }

        return next.get(dato_nuevo);
    }
    //Busca el nodo con la posicion dada mediante recursividad.
    public T get(int position,int current){
        if (position == current){
            return dato;
        }
        if (this.hasNext()) {return next.get(position,current+1);}
        throw new NoSuchElementException("No element found");
    }
    //Elimina el nodo con el dato dado mediante recursividad.
    //Si no se encuentra el dato, lanza una excepcion.
    //Funciona de tal forma que:
    //Devuelve siempre el siguiente nodo.
    //Si el siguiente nodo es nulo, devuelve null y se detiene la busqueda.
    //Si el siguiente nodo no es nulo:
    // Si el nodo es el que se va a eliminar:
    // Devuelve el siguiente nodo.
    // Si el nodo no es el que se va a eliminar:
    // Se asigna el siguiente nodo como el siguiente nodo del siguiente nodo, y se vuelve a llamar a la funcion
    //Ej: Nodo1 -> Nodo2 -> Nodo3 -> Nodo4 -> Nodo5 -> Nodo6
    //del(Nodo3)
    //Nodo1 -> Nodo2 -> (Nodo3) ->Nodo4 -> Nodo5 -> Nodo6
    //Nodo1 -> Nodo2 -> Nodo4 -> Nodo5 -> Nodo6
    public Nodo<T> del(T dato_nuevo){
        if (this.equal(dato_nuevo)){
            return next;
        }
        Nodo<T> aux = this;
        if (this.hasNext()){
            this.setNext(next.del(dato_nuevo));
            return this;
        }
        throw new NoSuchElementException("No element found");

    }
    //Compara el dato del nodo con el dato dado.
    //Si son iguales devuelve true, de lo contrario devuelve false.
    public boolean equal(T dato_nuevo){
        return dato.toString().equals(dato_nuevo.toString());
    }
    //Metodo complementario de lista.
    //Si no es el final de la lista:
    //Se suma 1 y se pasa al siguiente nodo.
    //Si es el final de la lista:
    //Se devuelve 1 y se empieza a sumar consecutivamente hasta llegar a la llamada original.
    public int lenght(){
        if (this.hasNext()){
            return 1+next.lenght();
        }
        return 1;
    };
    //Verdadero si el siguiente nodo no es nulo, falso si es nulo.
    public boolean hasNext(){
        if (next == null){
            return false;
        }
        return true;
    }
    //Devuelve el siguiente nodo.
    public Nodo<T> next(){
        return this.next;
    }
    //Devuelve el dato del nodo.
    public T getDato(){
        return this.dato;
    }
    //Devuelve una cadena con el dato del nodo y el siguiente nodo.
    @Override
    public String toString(){
        if (this.next == null){return this.dato.toString();}
        return this.dato.toString() + " -> "+ this.next.toString();
    }
}
