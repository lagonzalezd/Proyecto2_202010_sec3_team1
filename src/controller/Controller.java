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

			case 0:
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
			case 4:
				view.preguntaRequerimiento1();
				int comparendosAcargar = lector.nextInt();
				modelo.requerimiento1B(comparendosAcargar);
				break;
			case 5:
				view.imprimirPreguntaReq2();
				String datos = lector.next();
				modelo.requerimiento2B(datos);
				break;
			case 6:
				view.imprimirPreguntaReq3();
				String datos3 = lector.next();
				modelo.requerimiento3B(datos3);
				break;
			case 7:

				break;
			case 8:

				break;
			case 9:

				break;

			default: 
				view.printMessage("------------ Opcion invalida ---------- ");
				break;
			}
		}

	}	
}