package model.data_structures;


import org.w3c.dom.Node;

public interface IArbolRojoNegro<T1, T2> {

    int size();

    boolean isEmpty();

    Value get(T1 t);

    boolean contains(T1 t);

    void put(T1 t, T2 t2);

    Node deleteMin(T1 t);

    Node deleteMax(T1 t);

    void delete();

    void height();

    void min();

    void max();

    void floor();

    void ceiling();

    void select();

    void rank();

    void keys();

}
