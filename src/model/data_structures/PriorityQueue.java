package model.data_structures;



import javax.swing.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>>implements Iterator<T> {

    //Este codigo se hizo basado en la implementacion MaxPriorityQueue del libro Algorithms 4th edition Sedgewick- Wayne

    private T[] elementos;
    private int size;
    private Comparator<T> comparador;

    public PriorityQueue(int max)
    {
        elementos = (T[])new Comparable[max+1];
        size = 0;
    }
    public PriorityQueue()
    {
        this(1);
    }
    public PriorityQueue(int max, Comparator<T> comparador)
    {
        this.comparador = comparador;
        elementos = (T[])new Comparable[max+1];
        size = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param  comparator the order in which to compare the keys
     */
    public PriorityQueue(Comparator<T> comparator) {
        this(1, comparator);
    }

    public PriorityQueue(T[] keys) {
        size = keys.length;
        elementos = (T[]) new Comparable[keys.length + 1];
        for (int i = 0; i < size; i++)
            elementos[i+1] = keys[i];
        for (int k = size/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }

    /**
     *
     * @param i index
     * @return .
     */
    public T getElement(int i)
    {
        return elementos[i];
    }

    /**
     *
     * @return .
     */
    public int darElementos()
    {
        return size;
    }

    /**
     *
     * @param elemento .
     */
    public void agregar(T elemento)
    {
        if(size == elementos.length -1)
            resizeArr(2 * elementos.length);
        elementos[++size] = elemento;
        swim(size);
        assert isMaxHeap();
    }

    public void swim(int i)
    {
        while(i > 1 && less(i/2, i))
        {
            swap(i, i/2);
            i = i/2;
        }
    }

    public void swap(int i, int j)
    {
        T aCambiar = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = aCambiar;
    }

    public boolean less(int i, int k)
    {
        if (comparador == null) {
            return elementos[i].compareTo(elementos[k]) < 0;
        }
        else {
            return comparador.compare(elementos[i], elementos[k]) < 0;
        }
    }

    public void resizeArr(int capacity)
    {
        assert capacity > size;
        T[] copia = (T[])new Comparable[capacity];
        for(int i = 1; i <= size; i++)
        {
            copia[i] = elementos[i];
        }
        elementos = copia;
    }

    /**
     *
     */
    public T sacarMax()
    {
        if(esVacia())
            throw new NoSuchElementException();
        T max = elementos[1];
        swap(1, size--);
        sink(1);
        elementos[size+1] = null;
        if((size > 0) && (size == (elementos.length -1)/4))
            resizeArr(elementos.length/2);
        assert isMaxHeap();
        return max;
    }

    public void sink(int j)
    {
        while(2*j <= size)
        {
            int i = 2*j;
            if(i < size && less(i, i+1))
                j++;
            if(!less(j, i))
                break;
            swap(j, i);
            j = i;
        }
    }

    /**
     *
     * @return .
     */
    public T darMax()
    {
        if(esVacia())
            throw new NoSuchElementException();
        return elementos[1];
    }

    /**
     *
     * @return .
     */
    public boolean esVacia()
    {
        return size == 0;
    }
    private boolean isMaxHeap() {
        for (int i = 1; i <= size; i++) {
            if (elementos[i] == null) return false;
        }
        for (int i = size+1; i < elementos.length; i++) {
            if (elementos[i] != null) return false;
        }
        if (elementos[0] != null) return false;
        return isMaxHeapOrdered(1);
    }
    private boolean isMaxHeapOrdered(int k) {
        if (k > size) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= size && less(k, left))  return false;
        if (right <= size && less(k, right)) return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}