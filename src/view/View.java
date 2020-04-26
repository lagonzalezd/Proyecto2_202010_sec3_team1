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
	
	public void opcionInvalida(){
		System.out.println("============================== ¡¡Opción Inválida!! ======================");
	}

	public void printMenu()
	{
		System.out.println("--------Menu---------");
		System.out.println("0. Cargar los Datos.");
		System.out.println("======================");
		System.out.println("1. Requerimiento 1A.");
		System.out.println("2. Requerimiento 2A.");
		System.out.println("3. Requerimiento 3A.");
		System.out.println("======================");
		System.out.println("4. Requerimiento 1B.");
		System.out.println("5. Requerimiento 2B.");
		System.out.println("6. Requerimiento 3B");
		System.out.println("======================");
		System.out.println("7. Requerimiento 1C");
		System.out.println("8. Requerimiento 2C");
		System.out.println("9. Requerimiento 3C");
		
		System.out.println(">>>");

	}

	public void mensajeDeCarga(String numComps, String mayorCompID){
		System.out.println("El tamanio es: " + numComps);
		System.out.println("El comparendo con el mayor OBJECTID: " + mayorCompID);
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

	public void imprimirComparendo1A(Comparendo comparendo){
		String datos="ID="+comparendo.OBJECTID+" Tipo Servicio="+comparendo.TIPO_SERVICIO+" InfracciÃ³n="+comparendo.INFRACCION+
				" Fecha-Hora="+comparendo.FECHA_HORA+" Clase Vehiculo="+comparendo.CLASE_VEHICULO+"\n";
		System.out.println(datos);
	}
	
	public void preguntaRequerimiento1B(){
		System.out.println("¿½Cuantos datos desea buscar? \n");
	}

	public void preguntaReq2B(String aPreguntar){
		System.out.println("Introduzca el valor " + aPreguntar + ": ");
	}
	
	public void imprimirComparendoReq1(Comparendo c){
		String datos = "" + c.OBJECTID +", " + c.TIPO_SERVICIO +", " + c.INFRACCION +", " + c.FECHA_HORA +", " + c.CLASE_VEHICULO
				+", " + c.longitud +", " + c.latitud;
		System.out.println(datos);
	}
	public void imprimirComparendoReq2(Comparendo c){
		String datos = "" + c.OBJECTID +", " + c.TIPO_SERVICIO +", " + c.INFRACCION 
				+", " + c.FECHA_HORA +", " + c.CLASE_VEHICULO + ", " +
				 c.LOCALIDAD;
		System.out.println(datos);
	}
	
	public void imprimirPreguntaReq2(){
		System.out.println("Ingrese el medio, la clase, el tipo y la localidad por la que quiere buscar");
		System.out.println("Introduzca el medio de deteccion: ");
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
	
	//*************************************PARTE C**************************************
	
	//1C
	public void visualizarASCII1C(){
		System.out.println("       Rango de fechas       |       Comparendos durante el año  ");
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void rangoDeFechas1C(String date1, String date2, String asteriscos){
		System.out.println("   "+ date1 + " - " + date2 +"   |   " + asteriscos);
	}
	
	public void preguntaREQ1C(){
		System.out.println("Intruzca el tamanio del rango de dias por los que se van a dividir los comparendos: ");
	}
	
	//2C
	public void preguntarFechaReq2C(){
		System.out.println("Introduzca la fecha por la que desea comparar");
		System.out.println("Escribala en la forma yyyy/MM/dd ejemplo: 2019/04/25");

	}
	
	public void costoTotal(String costo){
		System.out.println("El costo total que generan las penalizaciones en 2018 es de: " + costo);
	}
	public void visualizarASCII2C(){
		System.out.println("       Fecha     |    ComparendoProcesados           ***        ");
		System.out.println("                 |    Comparendos que están en espera ###       ");
		System.out.println("-------------------------------------------------------------------");
	}
	public void rangoDeFechas2C(String date, String asteriscos, String numerales){
		System.out.println("   "+ date + "   |   " + asteriscos);
		System.out.println("                |   " + numerales);
	}


}
