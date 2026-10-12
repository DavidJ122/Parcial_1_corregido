package Remodelado.ListCustom;

//
public class Nodo<T>{
    private T dato;
    private Nodo<T> next = null;

    Nodo(T dato){
        this.dato = dato;
    }
    public void add(Nodo<T> nodo){
      if (next == null){
          this.setNext(nodo);
      }
      else{
          next.add(nodo);
      }
    };

    private void setNext(Nodo<T> nodo){
        this.next = nodo;
    }
    public T get(T dato_nuevo){
        if (this.equal(dato_nuevo)){
            return dato;
        }
        if (next == null){
            return null;
        }

        return next.get(dato_nuevo);
    }
    public T get(int position,int current){
        if (position == current){
            return dato;
        }
        if (this.hasNext()) {return next.get(position,current+1);}
        throw new IllegalArgumentException("No element found");
    }

    public Nodo<T> del(T dato_nuevo){
        if (this.equal(dato_nuevo)){
            return next;
        }
        Nodo<T> aux = this;
        if (this.hasNext()){
            this.setNext(next.del(dato_nuevo));
            return this;
        }
        throw new IllegalArgumentException("No element found");

    }
    public boolean equal(T dato_nuevo){
        return dato.toString().equals(dato_nuevo.toString());
    }
    public int lenght(){
        if (this.hasNext()){
            return 1+next.lenght();
        }
        return 1;
    };
    public boolean hasNext(){
        if (next == null){
            return false;
        }
        return true;
    }
    public Nodo<T> next(){
        return this.next;
    }
    public T getDato(){
        return this.dato;
    }
    @Override
    public String toString(){
        if (this.next == null){return this.dato.toString();}
        return this.dato.toString() + " -> "+ this.next.toString();
    }
}
