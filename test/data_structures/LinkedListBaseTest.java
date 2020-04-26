package data_structures;

import model.data_structures.LinkedListBase;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LinkedListBaseTest {

    private LinkedListBase lista;

    private static int TAMANO=50;

    @Before
    public void setUp1() {
        lista = new LinkedListBase();
        for (int i = 0; i < TAMANO; i++) {
            lista.add(i);
        }

    }

    @Test
    public void isEmpty() {
        lista = new LinkedListBase();

        assertTrue(lista.isEmpty());
    }



    @Test
    public void size() {
        setUp1();

        assertEquals(50, lista.size());
    }

    @Test
    public void add() {
        lista = new LinkedListBase();
        lista.add(5);

        assertEquals(5, lista.iterator().next());
    }

    @Test
    public void iterator() {
    }
}