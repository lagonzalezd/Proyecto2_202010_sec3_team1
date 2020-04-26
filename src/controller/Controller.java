package controller;

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
			case 1: //1A
				break;
			case 2: //2A

				break;
			case 3: //3A

				break;
			case 4: //1B
				view.preguntaRequerimiento1();
				int comparendosAcargar = lector.nextInt();
				modelo.requerimiento1B(comparendosAcargar);
				break;
			case 5: //2B
				view.imprimirPreguntaReq2();
				String medio = lector.next();
				view.preguntaReq2("de la clase");
				String clase = lector.next();
				view.preguntaReq2("del tipo");
				String tipo = lector.next();
				view.preguntaReq2("de la localidad");
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
				modelo.requerimiento2C(fecha);
				break;
			case 9: //3C
				
				break;

			default: 
				view.printMessage("------------ Opcion invalida ---------- ");
				break;
			}
		}

	}	
}