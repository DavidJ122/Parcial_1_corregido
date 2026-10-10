package Legacy.Concretos;

import Legacy.Interfaces.QLista;

import java.util.Iterator;
import Legacy.Enum.Shuffle;
import Legacy.Metodos_Sort.*;
//Lista
public class ListaCustom implements QLista<Paquete> {
    Paquete header = null;


    @Override
    public void agregar(Paquete nodo) {
        if (this.vacio()) {this.header=nodo;}
        else {this.header.add(nodo);}
    }

    @Override
    public void eliminar(Paquete nodo) {
        if (this.vacio() ){ throw new IllegalArgumentException("La lista esta vacia");}
        this.header= this.header.eliminar(nodo);
    }

    @Override
    public Paquete obtener(Paquete nodo) {
        if (this.vacio()) { throw new IllegalArgumentException("La lista esta vacia");}
        return header.obtener(nodo);
    }

    @Override
    public int Tamaño(Paquete nodo) {
        if (this.vacio()) { return 0;}
        return header.Contar();
    }

    @Override
    public boolean vacio() {
        if (header==null) { return true;}
        return false;
    }

    private ListaCustom shuffle(Shuffle type) {
        switch (type) {
            case Peso:
                return shuffle(new porPeso());
            case Tiempo:
                return shuffle(new porTiempo());
            case Codigo:
                return shuffle(new porCodigo());
            case Prioridad:
                return shuffle(new porPrioridad());
        }

        return null;
    }

    //Caso general
    private ListaCustom shuffle(Sort<Paquete> sort){
        if (this.vacio()) { throw new IllegalArgumentException("La lista esta vacia");}
        ListaCustom lista=new ListaCustom();
        Boolean flag=true;
        while (flag) {
            flag = false;
            Paquete nodo_mayor;
            for (Paquete nodo : this) {
                nodo_mayor = null;
                for (Paquete nodo2 : lista) {
                    if (nodo2 == nodo || lista.contains(nodo2.getCodigo()))  { continue;}
                    if (sort.compare(nodo, nodo2)) {
                        nodo_mayor = nodo2;
                    }
                    if (!nodo2.hasNext() && nodo_mayor == null && !lista.contains(nodo2.getCodigo())){
                        nodo_mayor = nodo2;
                    }
                }
                if (nodo_mayor != null) {
                    lista.agregar(nodo_mayor);
                    flag = true;
                }
            }

        }
        return lista;
    }

    //Caso especial para la prioridad
    private ListaCustom shuffle(porPrioridad sort){
        if (this.vacio()) { throw new IllegalArgumentException("La lista esta vacia");}

        ListaCustom lista=new ListaCustom();
        Boolean flag=true;
        while (flag) {
            flag = false;
            for (Paquete nodo : this) {
                Paquete nodo_mayor = null;
                for (Paquete nodo2 : lista) {
                    if (nodo2 == nodo || lista.contains(nodo2.getCodigo()))  { continue;}
                    if (sort.compare(nodo, nodo2)){ nodo_mayor = nodo2;}
                    else if (nodo.getPrioridad() == nodo2.getPrioridad()){
                        if (nodo.getTiempo_estimado() > nodo2.getTiempo_estimado()){
                            nodo_mayor = nodo2;
                        }
                        else if (nodo.getTiempo_estimado() == nodo2.getTiempo_estimado()){
                            if (sort.compare(nodo, nodo2)){
                                nodo_mayor = nodo2;
                            }
                        }
                    }
                    if (!nodo2.hasNext() && nodo_mayor == null && !lista.contains(nodo2.getCodigo())){
                        nodo_mayor = nodo2;
                    }
                }
                if (nodo_mayor != null) {
                    lista.agregar(nodo_mayor);
                    flag = true;
                }
            }
        }
        return lista;
    }

    @Override
    public Iterator<Paquete> iterator() {
        return new PaqueteIterator(this.header);
    }

    @Override
    public boolean contains(Object o) {
        if (this.vacio()) { throw new IllegalArgumentException("La lista esta vacia");}
        for (Paquete nodo : this) {
            if (nodo.getCodigo().equals(o)) {
                return true;
            }
        }
        return false;
    }

}
