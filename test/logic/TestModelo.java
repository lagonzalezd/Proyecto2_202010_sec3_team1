package test.logic;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.logic.Modelo;
import org.junit.Test;

public class TestModelo<T> {




	private Modelo modelo;

	private Comparable[] datosDRandom;
	
	private Comparable[] datosIAscendentes;
	
	private Comparable[] datosIDescendentes;

	public TestModelo()
	{
		modelo= new Modelo();
	}

	public void setUp1() {
		datosDRandom = new Comparable[100];
		for(int i =0; i<100; i++){
			datosDRandom[i] = Math.random()*99;
		}
		System.out.println(datosDRandom .length+ "tamaño arreglo");
	}

	public void setUp2() {
		datosIAscendentes = new Comparable[100];
		for (int i = 0; i <100;i++)
		{
			datosIAscendentes[i]=i;
		}
			

	}

	public void setUp3(){
		datosIDescendentes = new Comparable[100];
		for(int i = 100; i>0;i--){
	System.out.println(i);
			datosIDescendentes[i-1]= i;
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
	}

	@Test
	public void testReq1ShellSort_Random()
	{
		setUp1();                          
		for (int i = 1; i < datosDRandom.length&& datosDRandom[i].compareTo(datosDRandom[i-1])<0; i++){        
			assertFalse(datosDRandom[i].compareTo(datosDRandom[i-1])>0);  } 
//		modelo.Shellsort(datosDRandom);
		for (int i = 1; i < datosDRandom.length; i++)  
			assertTrue(datosDRandom[i].compareTo( datosDRandom[i-1])>0);
	}
	@Test
	public  void testReq1ShellSort_OrdenadoAscendentemente()
	{
		setUp2();
		for (int i = 1; i < datosIAscendentes.length; i++)  
		assertTrue(datosIAscendentes[i].compareTo( datosIAscendentes[i-1])>0);
//		modelo.Shellsort(datosIAscendentes);
		for (int i = 0; i < datosIAscendentes.length; i++)  
			assertEquals(i, datosIAscendentes[i]);
	}
	@Test
	public  void testReq2ShellSort_OrdenadoDescendentemente()
	{
		setUp3();
		for (int i = 1; i < datosIDescendentes.length&& datosIDescendentes[i].compareTo(datosIDescendentes[i-1])<0; i++)  
		assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
//		modelo.Shellsort(datosIDescendentes);
		for (int i = 1; i < datosIDescendentes.length; i++)  
			assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
	}
	
	@Test
	public void testReq3MergeSort_Random()
	{
		setUp1();                          
		for (int i = 1; i < datosDRandom.length&& datosDRandom[i].compareTo(datosDRandom[i-1])<0; i++){        
			assertFalse(datosDRandom[i].compareTo(datosDRandom[i-1])>0);  } 
//		modelo.sort(datosDRandom);
		for (int i = 1; i < datosDRandom.length; i++)  
			assertTrue(datosDRandom[i].compareTo( datosDRandom[i-1])>0);
		
	}
	
	@Test
	public  void testReq3MergeSort_OrdenadoAscendentemente()
	{
		setUp2();
		for (int i = 1; i < datosIAscendentes.length; i++)  
		assertTrue(datosIAscendentes[i].compareTo( datosIAscendentes[i-1])>0);
		modelo.sort(datosIAscendentes);
		for (int i = 0; i < datosIAscendentes.length; i++)  
			assertEquals(i, datosIAscendentes[i]);
	}
	
	@Test
	public  void testReq3MergeSort_OrdenadoDescendentemente()
	{
		setUp3();
		for (int i = 1; i < datosIDescendentes.length&& datosIDescendentes[i].compareTo(datosIDescendentes[i-1])<0; i++)  
		assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
		modelo.sort(datosIDescendentes);
		for (int i = 1; i < datosIDescendentes.length; i++)  
			assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
	}
	


	
	@Test
	public void testReq4QuickSort_aRandom()
	{
		setUp1();                          
		for (int i = 1; i < datosDRandom.length&& datosDRandom[i].compareTo(datosDRandom[i-1])<0; i++){        
			assertFalse(datosDRandom[i].compareTo(datosDRandom[i-1])>0);  } 
//		modelo.sortQ(datosDRandom);
		for (int i = 1; i < datosDRandom.length; i++)  
			assertTrue(datosDRandom[i].compareTo( datosDRandom[i-1])>0);
		
	}
	
	@Test
	public  void testReq4QuickSort_OrdenadoAscendentemente()
	{
		setUp2();
		for (int i = 1; i < datosIAscendentes.length; i++)  
		assertTrue(datosIAscendentes[i].compareTo( datosIAscendentes[i-1])>0);
//		modelo.quickSort(datosIAscendentes, 0, datosIAscendentes.length-2);
		for (int i = 0; i < datosIAscendentes.length; i++)  
			assertEquals(i, datosIAscendentes[i]);
	}
	@Test
	public  void testReq4QuickSort_OrdenadoDescendentemente()
	{
		setUp3();
		for (int i = 1; i < datosIDescendentes.length&& datosIDescendentes[i].compareTo(datosIDescendentes[i-1])<0; i++)  
		assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
//		modelo.quickSort(datosIDescendentes, 0, datosIDescendentes.length-2);
		for (int i = 1; i < datosIDescendentes.length; i++)  
			assertTrue(datosIDescendentes[i].compareTo( datosIDescendentes[i-1])>0);
	}


}




