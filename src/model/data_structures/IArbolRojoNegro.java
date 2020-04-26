package model.data_structures;


public interface IArbolRojoNegro<T1, T2> {

    int size();

    boolean isEmpty();


    boolean contains(T1 t);

    void put(T1 t, T2 t2);


}
