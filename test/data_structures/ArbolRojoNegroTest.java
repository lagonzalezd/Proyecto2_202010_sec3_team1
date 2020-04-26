package data_structures;

import model.data_structures.ArbolRojoNegro;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArbolRojoNegroTest {

    private ArbolRojoNegro arbol;
    private static int TAMANO = 50;

    public void setUp1() {
        arbol = new ArbolRojoNegro();
        for (int i = 0; i < TAMANO; i++) {
            arbol.put(i, i);
        }
    }

    @Test
    public void testsize() {
        setUp1();

        assertEquals(50, arbol.size());

    }

    @Test
    public void testisEmpty() {
        assertTrue(arbol.isEmpty());

    }

    @Test
    public void testGet() {

    }

    @Test
    public void testContains() {
    }

    @Test
    public void testPut() {
    }

    @Test
    public void testDeleteMin() {
    }

    @Test
    public void testDeleteMax() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testHeight() {
    }

    @Test
    public void testMin() {
    }

    @Test
    public void testMax() {
    }

    @Test
    public void testFloor() {
    }

    @Test
    public void testCeiling() {
    }

    @Test
    public void testSelect() {
    }

    @Test
    public void testRank() {
    }

    @Test
    public void testKeys() {
    }

}