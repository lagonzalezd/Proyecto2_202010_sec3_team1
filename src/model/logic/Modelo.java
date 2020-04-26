package model.logic;

import com.google.gson.Gson;
import controller.Controller;
import model.data_structures.*;
import view.View;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;



public class Modelo {

	private Controller controller;

	private static View view;

	//Valor inicial para el n�mero de datos a cargar
	public int N;

	/*
	 * Grande = ./data/Comparendos_DEI_2018_Bogot�_D.C.geojson
	 * Mediano Ordenado = ./data/Comparendos_DEI_2018_Bogot�_D.C_small_50000_sorted.geojson
	 * Mediano = ./data/Comparendos_DEI_2018_Bogot�_D.C_50000_.geojson
	 * pequenio = ./data/Comparendos_DEI_2018_Bogot�_D.C_small.geojson
	 */
	private static final String GRANDE = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";
	private static final String MEDIANOORDENADO = "./data/Comparendos_DEI_2018_Bogot�_D.C_small_50000_sorted.geojson";
	private static final String MEDIANO = "./data/Comparendos_DEI_2018_Bogot�_D.C_50000_.geojson";
	private static final String PEQUENIO = "./data/Comparendos_DEI_2018_Bogot�_D.C_small.geojson";


	public static int mayorOID;

	@SuppressWarnings("rawtypes")
	private static ArbolRojoNegro arbol;
	private static String archivoActual;
	private static MaxCola colaPQ;


	public Modelo(){
		N = 20;
		view = new View();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void cargar(){

		arbol = new ArbolRojoNegro();

		//cambiar esto para cambiar de tamanio de archivos.
		archivoActual = MEDIANO;
		try
		{
			FileInputStream inputStream;
			inputStream = new FileInputStream(archivoActual);
			InputStreamReader inputStreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamreader);

			Json cargar =  new Gson().fromJson(bufferedReader, Json.class);


			for (int i=0; i<cargar.features.length;i++){
				Comparendo comp = new Comparendo(cargar.features[i].properties.OBJECTID, cargar.features[i].properties.FECHA_HORA,
						cargar.features[i].properties.MEDIO_DETECCION,cargar.features[i].properties.CLASE_VEHICULO,
						cargar.features[i].properties.TIPO_SERVICIO,cargar.features[i].properties.INFRACCION,
						cargar.features[i].properties.DES_INFRACCION,cargar.features[i].properties.LOCALIDAD,
						cargar.features[i].properties.MUNICIPIO,cargar.features[i].geometry.coordinates[0],
						cargar.features[i].geometry.coordinates[1],"OBJECTID");

				arbol.put(comp.darLlave(), comp);

			}

		}
		catch (Exception e)
		{
			e.getStackTrace();
		}

	}

	public void auxiliarReq1B(){

	}


	@SuppressWarnings("unchecked")
	public static void requerimientosCargar(){
		Comparendo maximo = (Comparendo) arbol.get(arbol.max());
		view.mensajeDeCarga(arbol.size() +"", maximo.toString());
	}

	 //****************************************** PARTE A - Alejando G *************************************************

    public void requerimiento1A(int m) {

        colaPQ = new MaxCola(N);
        Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

        while (it.hasNext()) {
            llaveC y = (llaveC) it.next();
            Comparendo next = (Comparendo) arbol.get(y);
            next.cambiarIndicador("INFRACCION");
            colaPQ.insert(next);
        }

        for (int i = 0; i < m; i++) {
            view.imprimirComparendo1A((Comparendo) colaPQ.delMax());
        }

    }

    public void requerimiento2A(int mes, String dia) throws ParseException {

        int diaInt = 0;
        if (dia.equalsIgnoreCase("L")) diaInt = 1;
        else if (dia.equalsIgnoreCase("M")) diaInt = 2;
        else if (dia.equalsIgnoreCase("I")) diaInt = 3;
        else if (dia.equalsIgnoreCase("J")) diaInt = 4;
        else if (dia.equalsIgnoreCase("V")) diaInt = 5;
        else if (dia.equalsIgnoreCase("S")) diaInt = 6;
        else if (dia.equalsIgnoreCase("D")) diaInt = 7;

        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        colaPQ = new MaxCola(N);
        Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

        while (it.hasNext()) {
            llaveC y = (llaveC) it.next();
            Comparendo next = (Comparendo) arbol.get(y);

            Date date = formato.parse(next.FECHA_HORA);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int mesActual = calendar.get(Calendar.MONTH);
            int diaActual = calendar.get(Calendar.DAY_OF_WEEK);

            if (diaInt == diaActual && mes == mesActual) {
                colaPQ.insert(next);
            }

        }

        for (int i = 0; i < colaPQ.size(); i++) {
            view.imprimirComparendo1A((Comparendo) colaPQ.delMax());
        }


    }

    public void requerimiento3A(String fechaMin, String fechaMax, String pLocalidad) throws ParseException {

        colaPQ = new MaxCola(N);
        Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date minima = formato.parse(fechaMin);
        Date maxima = formato.parse(fechaMax);

        while(it.hasNext()){
            llaveC y = (llaveC) it.next();
            Comparendo next = (Comparendo) arbol.get(y);

            if(next.convertirFechaStringADate().compareTo(minima)>=0&&next.convertirFechaStringADate().compareTo(maxima)<=0&&next.LOCALIDAD.equalsIgnoreCase(pLocalidad))
            {
                colaPQ.insert(next);
            }

            for (int i = 0; i < colaPQ.size(); i++) {
                view.imprimirComparendo1A((Comparendo) colaPQ.delMax());
            }

        }


    }

	//****************************************** PARTE B - Geisson P *************************************************

	public void requerimiento1B(int numeroComparendos){
		colaPQ = new MaxCola(N);
		Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

		while(it.hasNext()){
			llaveC k = (llaveC) it.next();
			Comparendo actual = (Comparendo) arbol.get(k);
			actual.cambiarIndicador("DISTANCIA");
			colaPQ.insert(actual);
		}

		for (int i = 0; i<numeroComparendos; i++){
			view.imprimirComparendoReq1((Comparendo) colaPQ.delMax());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void requerimiento2B(String medio, String clase, String tipoS, String localidad){
		colaPQ = new MaxCola(N);

		Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

		while(it.hasNext()){
			llaveC k = (llaveC) it.next();
			Comparendo actual = (Comparendo) arbol.get(k);
			if(actual.MEDIO_DETECCION.equalsIgnoreCase(medio) &&
					actual.CLASE_VEHICULO.equalsIgnoreCase(clase) &&
					actual.TIPO_SERVICIO.equalsIgnoreCase(tipoS) &&
					actual.LOCALIDAD.equalsIgnoreCase(localidad))
			{
				actual.cambiarIndicador("FECHA");
				colaPQ.insert(actual);
			}
		}

		for (int i = 0; i<colaPQ.size(); i++){
			view.imprimirComparendoReq2((Comparendo) colaPQ.delMax());
		}
	}

	public void requerimiento3B(String cadena){
		colaPQ = new MaxCola(N);
		Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

		String division1[] = cadena.split(";");

		String division2[] = division1[0].split(",");
		double li = Double.parseDouble(division2[0].trim());
		double ls = Double.parseDouble(division2[1].trim());

		String clase = division1[1].trim();

		while(it.hasNext()){
			llaveC k = (llaveC) it.next();
			Comparendo actual = (Comparendo) arbol.get(k);
			boolean enIntervalo = actual.latitud >= li && actual.latitud <= ls;
			if( enIntervalo && actual.CLASE_VEHICULO.equalsIgnoreCase(clase)){
				colaPQ.insert(actual);
			}
		}
		for (int i = 0; i<colaPQ.size(); i++){
			view.imprimirComparendoReq3((Comparendo) colaPQ.delMax());
		}
	}


	//****************************************** PARTE C *************************************************

	//metodos parte 1C

	public Date sumarRestarDiasFecha(Date fecha, int dias){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

	public String convertirNumAAsteriscos1C(int n){
		String as = "";
		for(int i = 0; i<n;i++){
			as+= "*";
		}
		return as;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void requerimiento1C(int D){
		int totalDatosPorArchivo = archivoActual.equalsIgnoreCase(GRANDE) ? D*100 : archivoActual.equalsIgnoreCase(MEDIANO) ||
				archivoActual.equalsIgnoreCase(MEDIANOORDENADO)? D*10 : 1;
		//mover los datos a una cola de prioridad con nuevo indicador de comparacion
		colaPQ = new MaxCola(N);
		Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

		while(it.hasNext()){
			llaveC k = (llaveC) it.next();
			Comparendo actual = (Comparendo) arbol.get(k);
			actual.cambiarIndicador("FECHAMIN");
			colaPQ.insert(actual);
		}

		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date primerDia = formater.parse("2018/01/01");
			Date ultimoDia = formater.parse("2018/12/31");

			Comparendo actual = (Comparendo) colaPQ.delMax();

			Date fechaActual = primerDia;
			Date fechaSiguiente = sumarRestarDiasFecha(fechaActual, D-1);

			Date fechaComp = actual.convertirFechaStringADate();

			while(fechaSiguiente.compareTo(ultimoDia) < 0){
				String fecha1 = formater.format(fechaActual);
				String fecha2 = formater.format(fechaSiguiente);
				int contador = 0;
				while(fechaComp.compareTo(fechaSiguiente) < 0 && !colaPQ.isEmpty()){
					contador++;
					actual = (Comparendo) colaPQ.delMax();
					fechaComp = actual.convertirFechaStringADate();
				}
				String asterisco = convertirNumAAsteriscos1C(contador/totalDatosPorArchivo);
				view.rangoDeFechas1C(fecha1, fecha2, asterisco);
				fechaActual = fechaSiguiente;
				fechaSiguiente = sumarRestarDiasFecha(fechaSiguiente, D-1);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

	//metodos parte 2C

	public int calcularDiasEntre2Fechas(Date fechaInicial, Date fechaFinal){
		return (int) ((fechaFinal.getTime()-fechaInicial.getTime())/86400000);
	}

	public int procesarComparendo(Comparendo c){
		String descripcion = c.DES_INFRACCION;

		if(descripcion.contains("SERA INMOVILIZADO") || descripcion.contains("SERA INMOVILIZADO"))
			return 400;
		else if (descripcion.contains("LICENCIA DE CONDUCC�N"))
			return 40;
		else
			return 4;
	}

	public void requerimiento2C(String fechaIngresada){

		int totalPenalizacion = 0;
		//muevo los datos del arbol rojo negro a una estructura de linear probing
		Queue procesados = new Queue();
		Queue espera = new Queue();

		LinkedListBase todosLosDatos = new LinkedListBase<>();

		Iterator it = arbol.keys(arbol.min(), arbol.max()).iterator();

		while(it.hasNext()){
			llaveC k = (llaveC) it.next();
			Comparendo actual = (Comparendo) arbol.get(k);
			todosLosDatos.add(actual);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Iterator itLin = todosLosDatos.iterator();
			Comparendo act = (Comparendo) itLin.next();

			Date input = formatter.parse(fechaIngresada);
			Date primerDia = formatter.parse("2018/01/01");
			Date ultimoDia = formatter.parse("2018/12/31");
			Date diaActual = primerDia;

			while(diaActual.compareTo(ultimoDia) != 0){
				String fechaActualString = formatter.format(diaActual);
				int cont = 0;
				String asteriscos = "";
				String numerales = "";

				while(cont != 1500 && act.convertirFechaStringADate().compareTo(diaActual) == 0){
					cont++;

					while(!espera.isEmpty() && cont != 1500){
						cont++;
						asteriscos += "*";
						procesados.enqueue(act);
					}
					asteriscos += "*";
					procesados.enqueue(act);
					act = (Comparendo) itLin.next();
				}

				if(procesados.size() == 1500 ){
					while(act.convertirFechaStringADate().compareTo(diaActual) == 0){
						numerales += "#";
						espera.enqueue(act);
						act = (Comparendo) itLin.next();
					}
				}
				view.rangoDeFechas2C(fechaActualString, asteriscos, numerales);
				diaActual = sumarRestarDiasFecha(diaActual, 1);
			}
			view.costoTotal(totalPenalizacion + "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}




	//clases del Json para cargar

	private static class Json{
		String type;
		Features[] features;
	}

	private static class Features{
		String type;
		Properties properties;
		Geometry geometry;
	}

	private static class Geometry{
		String type;
		double[] coordinates;
	}

	private static class Properties{
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


}