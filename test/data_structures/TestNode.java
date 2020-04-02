package test.data_structures;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;

import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.data_structures.Node;
import model.logic.Modelo;


public class TestNode<T extends Comparable<T>> 
{

	private Node<T> nodo1;

	private Node<T> nodo2;

	private Node<T> nodo3;

	private LinkedListImp<Multa> lista;

	private Modelo modelo;


	//@Before

	public void setUp1() throws FileNotFoundException
	{
		lista = modelo.ModeloJSON();

	}
	@Before
	public void setUp2()
	{
		lista = new LinkedListImp<Multa>();

		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345", "");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");

		nodo1 = new Node<T>((T) m1, null, null);

		lista.insertarAlInicio(m1);
	}


	@Test
	public void testNode()
	{
		assertTrue("la lista no debe estar vacia",lista!=null);		
	}
	@Test
	public void testCambiarSiguiente()
	{
		setUp2();
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345", "");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
		//nodo1 = new Node<T>((T) m1, null, null);
		nodo2 = new Node<T>((T) m2, null, null);
		assertTrue(lista.size()==1);
		assertNull(nodo1.darSiguiente());;
		nodo1.cambiarSiguiente(nodo2);

		assertEquals(nodo2, nodo1.darSiguiente());

	}
	@Test 
	public void testCambiarAnterior()
	{
		setUp2();

		assertNull(nodo1.darAnterior());
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");

		nodo2 = new Node<T>((T) m2, null, null);
		nodo1.cambiarAnterior(nodo2);
		assertEquals(nodo2, nodo1.darAnterior());
	}
	@Test
	public void testDarValor()
	{
		//setUp1();
		setUp2();

		assertNull(nodo1.darAnterior());
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");

		nodo2 = new Node<T>((T) m2, null, null);
		lista.insertarAlFinal(m2);
		assertTrue(lista.size()!=0);
		assertEquals(m2, nodo2.darValor());


	}

}

