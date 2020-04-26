package data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArbolRojoNegro;
import org.junit.Test;


public class ArbolRojoNegroTest {

    private ArbolRojoNegro arbol;
    private static int TAMANO = 50;

    @Before
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
        setUp1();
        assertTrue(!arbol.isEmpty());
    }

    @Test
    public void testGet() {
    	assertEquals(null, arbol.get(0));
    }

    public void testContainsDeleteAndPut() {
    	setUp1();
    	assertEquals(true, arbol.contains(30));
    	assertEquals(false, arbol.contains(120));
    	assertEquals(true, arbol.contains(1));
    	arbol.delete(21);
    	assertEquals(false, arbol.contains(21));
    	arbol.put(21, 21);
    	assertEquals(true, arbol.contains(21));
    }

    public void testDeleteMinAndMin() {
    	setUp1();
    	Comparable minimo = arbol.min();
    	arbol.deleteMin();
    	assertFalse(minimo != arbol.min());
    }

    public void testDeleteMaxAndMax() {
    	setUp1();
    	Comparable max = arbol.max();
    	arbol.deleteMax();
    	assertFalse(max != arbol.max());
    }
}