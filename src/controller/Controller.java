package controller;

import java.text.ParseException;
import java.util.Scanner;

import model.data_structures.ArbolRojoNegro;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;

	private View view;

	private ArbolRojoNegro arbolRN;

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run()
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin ){

			view.printMenu();

			int option = lector.nextInt();
			switch(option){

			case 0: //carga
				modelo.cargar();
				modelo.requerimientosCargar();
				break;
			case 1:
				view.preguntaRequerimiento1A();
				int comparendos = lector.nextInt();
				modelo.requerimiento1A(comparendos);
				break;
			case 2:
				view.preguntaRequerimieto2A();
				int mes = lector.nextInt();
				String dia = lector.next();
				try {
					modelo.requerimiento2A(mes, dia);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				view.preguntaRequerimiento3A();
				String min = lector.next();
				String max = lector.next();
				String loc = lector.next();
				try {
					modelo.requerimiento3A(min, max, loc);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case 4: //1B
				view.preguntaRequerimiento1B();
				int comparendosAcargar = lector.nextInt();
				modelo.requerimiento1B(comparendosAcargar);
				break;
			case 5: //2B
				view.imprimirPreguntaReq2();
				String medio = lector.next();
				view.preguntaReq2B("de la clase");
				String clase = lector.next();
				view.preguntaReq2B("del tipo");
				String tipo = lector.next();
				view.preguntaReq2B("de la localidad");
				String localidad = lector.next();
				modelo.requerimiento2B(medio,clase,tipo,localidad);
				break;
			case 6: //3B
				view.imprimirPreguntaReq3();
				String datos3 = lector.next();
				modelo.requerimiento3B(datos3);
				break;
			case 7: //1C
				view.preguntaREQ1C();
				int req1C = lector.nextInt();
				view.visualizarASCII1C();
				modelo.requerimiento1C(req1C);
				break;
			case 8: //2C
				view.preguntarFechaReq2C();
				String fecha = lector.next();
				view.visualizarASCII2C();
				modelo.darCostoTotalPenalizacion();
				modelo.requerimiento2C(fecha);
				break;
			case 9: //3C
				view.preguntarFechaReq2C();
				String fecha2 = lector.next();
				view.visualizarASCII2C();
				modelo.darCostoTotalPenalizacion();
				modelo.requerimiento2C(fecha2);
				break;
			default: 
				view.opcionInvalida();
				break;
			}
		}

	}	
}