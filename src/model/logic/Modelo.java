package model.logic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import controller.Controller;
import model.data_structures.ArbolRojoNegro;
import model.data_structures.Comparendo;
import view.View;



public class Modelo {

	private Controller controller;

	private static View view;

	//Valor inicial para el n�mero de datos a cargar
	public int N;

	private static final String PATH = "./data/Comparendos_DEI_2018_Bogot�_D.C_small.geojson";
	public static double tiempoCarga;
	public static double tiempoInicio;
	public static double tiempoFin;

	public static int mayorOID;

	@SuppressWarnings("rawtypes")
	private static ArbolRojoNegro arbol;

	public Modelo(){
		tiempoCarga=0;
		tiempoInicio=0;
		tiempoFin=0;
		N = 20;
		view = new View();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void cargar(){

		arbol = new ArbolRojoNegro();

		try {
			FileInputStream inputStream;
			inputStream = new FileInputStream(PATH);
			InputStreamReader inputStreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamreader);

			Json cargar =  new Gson().fromJson(bufferedReader, Json.class);

			tiempoInicio = System.currentTimeMillis();

			for (int i=0; i<cargar.features.length;i++){
				Comparendo comp = new Comparendo(cargar.features[i].properties.OBJECTID, cargar.features[i].properties.FECHA_HORA, 
						cargar.features[i].properties.MEDIO_DETECCION,cargar.features[i].properties.CLASE_VEHICULO,
						cargar.features[i].properties.TIPO_SERVICIO,cargar.features[i].properties.INFRACCION, 
						cargar.features[i].properties.DES_INFRACCION,cargar.features[i].properties.LOCALIDAD, 
						cargar.features[i].properties.MUNICIPIO,cargar.features[i].geometry.coordinates[0], 
						cargar.features[i].geometry.coordinates[1]);

				arbol.put(comp.darLlave(), comp);

			}


			tiempoFin = System.currentTimeMillis();
			tiempoCarga = (tiempoFin-tiempoInicio)/1000;


		}t -m
		catch (Exception e)
		{
			e.getStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public static void requerimientosCargar(){
		Comparendo maximo = (Comparendo) arbol.get(arbol.max());
		view.mensajeDeCarga(arbol.size() +"", maximo.toString());
	}

	//****************************************** PARTE A *************************************************

	public void requerimiento1A(){

	}


	public void requerimiento2A(){


	}

	public void requerimiento3A(){

	}



	//****************************************** PARTE B *************************************************

	public void requerimiento1B(){
		
	}

	public void requerimiento2B(){

	}

	public void requerimiento3B(){

	}


	//****************************************** PARTE C *************************************************

	public void requerimiento1C(){

	}

	public void requerimiento2C(){

	}

	public void requerimiento3C(){

	}


	//clases del Json para cargar
	static class Json{
		String type;
		Features[] features;
	}

	static class Features{
		String type;
		Properties properties;
		Geometry geometry;
	}

	static class Properties{
		int OBJECTID;
		String FECHA_HORA;
		String MEDIO_DETECCION;
		String CLASE_VEHICULO;
		String TIPO_SERVICIO;
		String INFRACCION;
		String DES_INFRACCION;
		String LOCALIDAD;
		String MUNICIPIO;
	}

	static class Geometry{
		String type;
		double[] coordinates;
	}

}