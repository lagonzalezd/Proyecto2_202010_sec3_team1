package data_structures;

import model.data_structures.Queue;

import static org.junit.Assert.*;

import org.junit.Test;

class QueueTest {

    private Queue cola;

    private static int TAMANO = 30;

    public void setUp1() {
        cola = new Queue();
        for (int i = 0; i < TAMANO; i++) {
            cola.enqueue(i);
        }
    }


    @Test
    public void isEmpty() {
        assertTrue(cola.isEmpty());
    }

    @Test
    public void size() {
        setUp1();

        assertEquals(50, cola.size());
    }

    @Test
    public void peek() {
        cola.enqueue(5);
        cola.enqueue(6);
        assertEquals(6,cola.peek());
    }

    @Test
    public void enqueue() {
        cola.enqueue(6);
        assertEquals(6, cola.peek());
    }

    @Test
    public void dequeue() {
        cola.enqueue(5);
        cola.enqueue(6);
        cola.enqueue(7);
        assertEquals(5, cola.dequeue());
    }
}