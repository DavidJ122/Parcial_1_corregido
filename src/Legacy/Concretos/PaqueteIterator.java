package Legacy.Concretos;

import java.util.Iterator;
//Iterator
public class PaqueteIterator implements Iterator<Paquete> {
    Paquete here;
    PaqueteIterator(Paquete here){
        this.here=here;
    }

    @Override
    public boolean hasNext() {
        if (this.here==null) { throw new IllegalArgumentException("La lista esta vacia");}
        return this.here.hasNext();
    }

    @Override
    public Paquete next() {
        if (this.hasNext()) {
            Paquete aux=this.here;
            here = this.here.next();
            return aux;
        }
        return null;
    }
}
