package view;

public class View 
{

	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("--------Menu---------");
		System.out.println("0. Cargar los Datos.");
		System.out.println("======================");
		System.out.println("1. Requerimiento 1A.");
		System.out.println("2. Requerimiento 1A.");
		System.out.println("3. Requerimiento 1A.");
		System.out.println("======================");
		System.out.println("4. Requerimiento 1B.");
		System.out.println("5. Requerimiento 1B.");
		System.out.println("6. Requerimiento 1B");
		System.out.println("======================");
		System.out.println("7. Requerimiento 1C");
		System.out.println("8. Requerimiento 2C");
		System.out.println("9. Requerimiento 3C");
		
		System.out.println(">>>");

	}

	public void printMessage(String mensaje) {
		System.out.println(mensaje);
	}	

	public void mensajeDeCarga(String numComps, String mayorCompID){
		System.out.println("El tamanio es: " + numComps);
		System.out.println("El comparendo con el mayor OBJECTID: " + mayorCompID);
	}

}
