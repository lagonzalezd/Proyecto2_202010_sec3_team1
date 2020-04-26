package view;

import model.data_structures.Comparendo;

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
	
	public void preguntaRequerimiento1(){
		System.out.println("�Cuantos datos desea buscar? \n");
	}

	public void mensajeDeCarga(String numComps, String mayorCompID){
		System.out.println("El tamanio es: " + numComps);
		System.out.println("El comparendo con el mayor OBJECTID: " + mayorCompID);
	}
	
	public void imprimirComparendoReq1(Comparendo c){
		String datos = "" + c.OBJECTID +", " + c.TIPO_SERVICIO +", " + c.INFRACCION +", " + c.FECHA_HORA +", " + c.CLASE_VEHICULO
				+", " + c.longitud +", " + c.latitud;
		System.out.println(datos);
	}
	
	public void imprimirPreguntaReq2(){
		System.out.println("Ingrese el medio, la clase, el tipo y la localidad por la que quiere buscar");
		System.out.println("en la forma 'medio, clase, tipo, localidad' (separados por una unica coma)");
	}
	
	public void imprimirPreguntaReq3(){
		System.out.println("Ingrese el Rango en que quiere buscar y la clase de la siguiente forma: ");
		System.out.println("limite_inferior,limite_superior;clase");
	}
	
	public void imprimirComparendoReq3(Comparendo c){
		String datos = "" + c.OBJECTID +", " + c.TIPO_SERVICIO +", " + c.INFRACCION +", " + c.FECHA_HORA +", " + c.CLASE_VEHICULO
				+", " + c.latitud;
		System.out.println(datos);
	}

	public void imprimirComparendo1A(Comparendo comparendo){
		String datos="ID="+comparendo.OBJECTID+" Tipo Servicio="+comparendo.TIPO_SERVICIO+" Infracción="+comparendo.INFRACCION+
				" Fecha-Hora="+comparendo.FECHA_HORA+" Clase Vehiculo="+comparendo.CLASE_VEHICULO+"\n";
		System.out.println(datos);
	}
	public void preguntaRequerimiento1A(){
		System.out.println("¿Cuantos comparendos desea obtener? \n");
	}
	public void preguntaRequerimieto2A(){
		System.out.println("Ingrese el mes y luego el dia (L,M,I,J,V,S,D) \n");
	}
	public void preguntaRequerimiento3A(){
		System.out.println("Ingrese la fecha minima, luego la maxima y por ultimo la localidad.");
	}

}
