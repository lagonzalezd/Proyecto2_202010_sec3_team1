package data_structures;

import model.data_structures.ArbolRojoNegro;

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


    public void testsize() {
        setUp1();

        assertEquals(50, arbol.size());

    }

    public void testisEmpty() {
        assertTrue(arbol.isEmpty());

    }

    public void testGet() {

    }

    public void testContains() {
        arbol.contains()
    }

    public void testPut() {
    }

    public void testDeleteMin() {
    }

    public void testDeleteMax() {
    }

    public void testDelete() {
    }

    public void testHeight() {
    }

    public void testMin() {
    }

    public void testMax() {
    }

    public void testFloor() {
    }

    public void testCeiling() {
    }

    public void testSelect() {
    }

    public void testRank() {
    }

    public void testKeys() {
    }

}