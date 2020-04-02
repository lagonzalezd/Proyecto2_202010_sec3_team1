package model.data_structures;

public class ArbolRojoNegro<T extends Comparable<T>, V> {

    public NodoHash raiz;

    public ArbolRojoNegro() {

    }

    public void put(T llave, V pELemento) {
        if (llave == null) throw new IllegalArgumentException("first argument to put() is null");
        if (pELemento == null) {

            delete(llave);
        }


    }

    private void delete(T llave) {
    }

    public int size() {
        return x;
    }
}
