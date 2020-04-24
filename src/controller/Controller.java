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

			case 0:
				modelo.cargar();

				modelo.requerimientosCargar();

				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

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