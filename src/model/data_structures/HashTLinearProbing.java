package model.data_structures;

import java.security.Key;
import java.util.Iterator;

public class HashTLinearProbing<K extends Comparable<K>, Value> {


    private float keysSize;
    private float linearProbSize;
    private K[] keys;
    private Value[] values;
    private static final int INIT_CAPACITY = 4;
    private int nRehashes;

    public HashTLinearProbing() {
        this(INIT_CAPACITY);
    }

    /**
     * Inicializa una tabla de simbolos vacia con una capacidad inicial.
     *
     * @param capacity posiciones
     */
    public HashTLinearProbing(int capacity) {
        linearProbSize = capacity;
        keysSize = 0;
        keys = (K[]) new Comparable[(int) linearProbSize];
        values = (Value[]) new Comparable[(int) linearProbSize];
    }


    public Value get(K key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (int) ((i + 1) % linearProbSize))
            if (keys[i].equals(key))
                return values[i];
        return null;
    }

    public int getKeysSize() {
        return (int) keysSize;
    }

    public boolean isEmpty() {
        return getKeysSize() == 0;
    }

    public boolean contains(K key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    private void resize(int capacity) {
        HashTLinearProbing<K, Value> temp = new HashTLinearProbing<>(capacity);
        for (int i = 0; i < linearProbSize; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        linearProbSize = temp.linearProbSize;

        nRehashes++;
    }

    private int hash(K key) {
        return (int) ((key.hashCode() & 0x7fffffff) % linearProbSize);
    }

    public void put(K key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }
//        // double table size if 50% full
//        if (keysSize >= linearProbSize/2) resize((int) (2*linearProbSize));
        if((1.0 * keysSize)/(linearProbSize) >= 0.75) resize((int) (2 * linearProbSize));

        int i;
        for (i = hash(key); keys[i] != null; i = (int) ((i + 1) % linearProbSize)) {
            if (keys[i].equals(key)) {
                values[i] = val;
                return;
            }
        }
        keys[i] = key;
        values[i] = val;
        keysSize++;
    }

    public void delete(K key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (int) ((i + 1) % linearProbSize);
        }

        // delete key and associated value
        keys[i] = null;
        values[i] = null;

        // rehash all keys in same cluster
        i = (int) ((i + 1) % linearProbSize);
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            K keyToRehash = keys[i];
            Value valToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            keysSize--;
            put(keyToRehash, valToRehash);
            i = (int) ((i + 1) % linearProbSize);
        }

        keysSize--;

        // halves size of array if it's 12.5% full or less
        if (keysSize > 0 && keysSize <= linearProbSize / 8) resize((int) (linearProbSize / 2));
    }

    public Iterable<K> keys() {
        Queue<K> queue = new Queue<>();
        for (int i = 0; i < linearProbSize; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    public int tamanoInicial() {
        return INIT_CAPACITY;
    }

    public int tamanoFinal() {
        return (int) linearProbSize;
    }

    public float factorDeCargaFinal()
    {
        return keysSize / linearProbSize;
    }

    public double numeroRehashes()
    {
        return nRehashes;
    }




}
