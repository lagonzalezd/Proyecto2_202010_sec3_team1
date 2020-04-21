package controller;

import model.data_structures.ArbolRojoNegro;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Controller {


	private Modelo modelo;

	private View view;

	private Scanner reader;

	private ArbolRojoNegro<String, String> arbolRN;
	
	private Comparendo m;

	
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws InputMismatchException 
	{
		reader = new Scanner(System.in);
		try
		{
			boolean fin = false;
			while( !fin ){
				view.printMenu();
				int option = reader.nextInt();
				switch(option){
					case 0:
						modelo.cargarDatos();
						arbolRN = modelo.darArbol();
						view.printMessage(arbolRN.max().toString() + "");
						break;
					case 1:
						

					case 2:
						
						break;
					case 3:
						
					case 4:
						
					default:
						view.badOption();
						fin = true;

				}
			}
		}
		catch(InputMismatchException e){
			run();
		}
	}
}
