package test.data_structures;
import org.junit.Test;
import main.Main;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Before;
import model.data_structures.LinkedListImp;
import model.data_structures.Multa;
import model.data_structures.Node;
import model.logic.Modelo;

public class TestLinkedListImp<T extends Comparable<T>> {

	private LinkedListImp<Multa> lista;
	private Modelo modelo;
	private Main mundo;
	//	@Before
	public void setUp1() {
		try {
			
			lista = new LinkedListImp<Multa>();

			lista = modelo.ModeloJSON();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}
//@Before
	public void setUp2()
	{
		lista = new LinkedListImp<Multa>();

		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345", "");
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
		Node<T> n1 = new Node<T>((T) m1, null, null);
		Node<T> n2 = new Node<T>((T) m2, null, n1);
		lista.insertarAlInicio(m1);
		//lista.insertarAlFinal(m2);
	}

	public void testLinkedListImp()
	{
		setUp2();
		assertTrue(lista!=null);
		assertEquals(0, lista.size());
	}

	@Test
	public void testDarPrimero() {
		// TODO
		setUp2();
		Multa m1 = new Multa("AUTOMÓVIL", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "BARRIOS UNIDOS", "2018/12/10", null, "12345", "");
		String m5 = lista.darPrimero().darValor().darClase();
		assertTrue(lista!=null);
		assertEquals("La clase deberia ser la misma",m1.darClase(), m5);
	}
	@Test
	public void testDarUltimo()
	{
		setUp2();
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
		lista.insertarAlFinal(m2);
		String clase = lista.darUltimo().darValor().darClase();
		
		assertTrue(lista!=null);
		assertEquals("La clase debe ser la misma",m2.darClase(), clase);
	}
	@Test
	public void testSize()
	{
		//setUp1();
		setUp2();
		assertTrue(lista!=null);
		Multa m2 = new Multa("CAMIONETA", "Particular", "C35", "NO REALIZAR LA REVISIÓN TECNICOMECÁNICA EN EL PLAZO LEGAL ESTABLECIDO O CUANDO EL VEHÍCULO  NO SE ENCUENTRE EN ADECUADAS CONDICIONES TECNICOMECÁNICAS O DE EMISIONES CONTAMINANTES, AÚN CUANDO PORTE LOS CERTIFICADOS CORRESPONDIENTES, ADEMÁS EL VEHÍC", "TUNJUELITO", "2018/01/17", null, "509329", "");
		lista.insertarAlFinal(m2);
		lista.insertarAlFinal(m2);
		assertEquals(3, lista.size());
	}
	@Test
	public void testInsertarAlInicio()
	{
		setUp2();
		Multa m3 = new Multa("MOTOCICLETA", "Particular", "C02", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "TEUSAQUILLO", "2018/09/12", null, "56789", "");
		lista.insertarAlInicio(m3);
		assertTrue(lista!=null);
		assertEquals(m3, lista.darPrimero().darValor());
	}
	@Test
	public void testINsertarAlFinal()
	{
		setUp2();
		Multa m3 = new Multa("MOTOCICLETA", "Particular", "C90", "ESTACIONAR UN VEHÍCULO EN SITIOS PROHIBIDOS.", "TEUSAQUILLO", "2018/09/12", null, "69420", "");
		lista.insertarAlFinal(m3);
		assertTrue(lista!=null);
		assertEquals(m3, lista.darUltimo().darValor());
	}
}
