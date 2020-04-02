package controller;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class Controller {


	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private Scanner reader;
	
	private Comparable[] copia_ComparendosOriginal;

	private Comparendo m;

	private HashTLinearProbing<String, String> copiaLinearProb;

	private HashTableSeparateChaining<String, String> copiaSeparateC;
	/**
	 * Crear la vista y el modelo del proyecto
	 *
	 */
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
						copiaLinearProb = modelo.modeloHashLinear();
						Iterator<String> iter = copiaLinearProb.keys().iterator();
						view.displayOp1DataSize(copiaLinearProb.getKeysSize());
						if(iter.hasNext())
						{
							String m = copiaLinearProb.get(iter.next());
							view.displayOp0PrimeroData(m);
						}

						for(int i = copiaLinearProb.getKeysSize()-1; i < copiaLinearProb.getKeysSize(); i++)
						{
							String m = copiaLinearProb.get(iter.next());
							view.displayOp0UltimoData(m);
						}
						view.printMessage("Numero de duplas Linear Probing: "+ copiaLinearProb.getKeysSize() );
						view.printMessage("Tama�o inicial del arreglo HTLP: "+ copiaLinearProb.tamanoInicial());
						view.printMessage("Tama�o final del arreglo HTLP (m): "+ copiaLinearProb.tamanoFinal());
						view.printMessage("Factor de carga final: "+ copiaLinearProb.factorDeCargaFinal() );
						view.printMessage("Numero de rehashes:"+ copiaLinearProb.numeroRehashes());
						

						copiaSeparateC = modelo.modeloHashSeparateC();
						Iterator<String> iter2 = copiaSeparateC.keys().iterator();
						view.displayOp1DataSize(copiaSeparateC.size());
						if(iter2.hasNext())
						{
							String m = copiaSeparateC.get(iter2.next());
							view.displayOp0PrimeroData(m);
						}

						for(int i = copiaSeparateC.size()-1; i < copiaSeparateC.size(); i++)
						{
							String m = copiaSeparateC.get(iter2.next());
							view.displayOp0UltimoData(m);
						}
						view.printMessage("Numero de duplas SeparateChaining: "+ copiaSeparateC.size() );
						view.printMessage("Tama�o inicial del arreglo HTSC: "+ copiaSeparateC.tamanoInicial());
						view.printMessage("Tama�o final del arreglo HTSC (m): "+ copiaSeparateC.tamanoFinal());
						view.printMessage("Factor de carga final: "+ copiaSeparateC.factorDeCargaFinal() );
						view.printMessage("Numero de rehashes:"+ copiaSeparateC.numeroRehashes());

						break;
					case 1:
						view.displayInputFecha();
						String in = reader.next();
						view.displayInputClaseVehiculo();
						String in2 = reader.next();
						view.displayInputInfraccion();
						String in3 = reader.next();
						LinkedListImp<String> pInfo = modelo.buscarTiemposdeViajeLinearProb(in, in2, in3);
//						LinkedListImp<String> pInfo = modelo.buscarTiemposdeViajeLinearProb(in, in2, in3);
						for(int i = 0; i < pInfo.size(); i++) {
							String multa = pInfo.darActual(i).darValor();
							view.displayOp0PrimeroData(multa);

						}



						break;

					case 2:
						view.printMessage("Ingrese una fecha/hora\n");
						String pFecha = reader.next();
						view.printMessage("INGRESE LA CLASE DE VEHICULO");
						String pClaseV = reader.next();
						view.printMessage("INGRSE UNA INFRACCION");
						String pInfraccion = reader.next();
						LinkedListImp<String> pInfo1 = modelo.buscarTiemposdeViajeSeparateChaining(pFecha, pClaseV, pInfraccion);
						for(int i = 0; i < pInfo1.size();i++)
						{
							String m = pInfo1.darActual(i).darValor();
							view.displayOp0PrimeroData(m);
						}
						//	view.displayOp0PrimeroData(pInfo1);;


						//2018-11-01T10:29:42.000Z
						//CAMIONETA
						//C02
						break;
					case 3:
						long startTime = System.currentTimeMillis();
						modelo.getsAleatoriosLinearProb();
						long endTime = System.currentTimeMillis();
						long duration = endTime - startTime;
						view.printMessage("Tiempo que tardo : " + duration +" milisegundos\n");
						break;

					case 4:
						long start = System.currentTimeMillis();
						modelo.getsAleatoriosSeparate();
						long end = System.currentTimeMillis();
						long dur = end - start;
						view.printMessage("Tiempo que tardo : " + dur + " milisegundos\n");
						break;
//					//Opcion No valida.//
					default:
						view.badOption();
						fin = true;

				}
			}
		}
		catch(InputMismatchException e){
			run();
		}
		//
	}
}
