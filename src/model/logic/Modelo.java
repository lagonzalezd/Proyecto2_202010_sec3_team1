package model.logic;

import java.util.Iterator;
import java.io.FileReader;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.stream.JsonReader;
import model.data_structures.HashTLinearProbing;
import model.data_structures.HashTableSeparateChaining;
import model.data_structures.LinkedListImp;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	LinkedListImp<Multa> lista;
	HashTLinearProbing<String, String> hashTL;
	HashTableSeparateChaining<String, String> hashTSC;
	private Multa[] multasArr;
	private static Comparable[] aux;

	public Modelo() {
		lista = new LinkedListImp<>();
		hashTL = new HashTLinearProbing<>();
		hashTSC = new HashTableSeparateChaining<>();
	}


	public LinkedListImp<Multa> ModeloJSON() throws FileNotFoundException {

//		String path = "./data/comparendos_dei_2018_small.geojson";
		//	String path = "./data/comparendos_dei_2018.geojson";
		String path = "./data/comparendos_dei_2018.geojson";


		JsonReader reader;

		try {

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for (JsonElement e : features) {
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRACCION").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();
				String medioDet = properties.getAsJsonObject().get("MEDIO_DETECCION").getAsString();


				List<Double> geo = new ArrayList<>();
				if (e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull()) {
					for (JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()) {
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id, medioDet);

				lista.insertarAlFinal(m);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public HashTLinearProbing<String, String> modeloHashLinear() {
		//String path = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";
		String path = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";
		String path1 = "./data/test.geojson";
		JsonReader reader;
		String valores = null;

		try {

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for (JsonElement e : features) {
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRACCION").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();
				String medioDet = properties.getAsJsonObject().get("MEDIO_DETECCION").getAsString();


				List<Double> geo = new ArrayList<>();
				if (e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull()) {
					for (JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()) {
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id, medioDet);

				String llave = m.darFechaHora() + m.darClase() + m.darInfraccion();
				valores = m.darId() + "\t" + m.darFechaHora() + "\t" + m.darClase() + "\t" + m.darTipoServicio() + "\t" + m.darInfraccion() + "\t" + m.darDescInfr() + "\t" + m.darLocalidad() + "\t" + m.darMedioDeteccion();


				hashTL.put(llave, valores);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		return hashTL;
	}


	public HashTableSeparateChaining<String, String> modeloHashSeparateC() {
		//String path = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";
		String path = "./data/Comparendos_DEI_2018_Bogot�_D.C.geojson";
//		String path = "./data/test.geojson";
		JsonReader reader;
		String valores = null;

		try {

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray features = elem.getAsJsonObject().get("features").getAsJsonArray();
			for (JsonElement e : features) {
				JsonElement properties = e.getAsJsonObject().get("properties");

				String id = properties.getAsJsonObject().get("OBJECTID").getAsString();
				String fechaHora = properties.getAsJsonObject().get("FECHA_HORA").getAsString();
				String clase = properties.getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String tipo = properties.getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String infrac = properties.getAsJsonObject().get("INFRACCION").getAsString();
				String descr = properties.getAsJsonObject().get("DES_INFRACCION").getAsString();
				String localidad = properties.getAsJsonObject().get("LOCALIDAD").getAsString();
				String medioDet = properties.getAsJsonObject().get("MEDIO_DETECCION").getAsString();


				List<Double> geo = new ArrayList<>();
				if (e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull()) {
					for (JsonElement geoElem : e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()) {
						geo.add(geoElem.getAsDouble());
					}
				}

				Multa m = new Multa(clase, tipo, infrac, descr, localidad, fechaHora, geo, id, medioDet);

				String llave = m.darFechaHora() + m.darClase() + m.darInfraccion();
				valores = m.darId() + "\t" + m.darFechaHora() + "\t" + m.darClase() + "\t" + m.darTipoServicio() + "\t" + m.darInfraccion() + "\t" + m.darDescInfr() + "\t" + m.darLocalidad() + "\t" + m.darMedioDeteccion();

				hashTSC.put(llave, valores);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		return hashTSC;
	}


	public Comparable<Multa>[] copiarComparendos() {
		multasArr = new Multa[lista.size()];
		for (int i = 0; i < lista.size(); i++) {
			Multa multa = lista.darActual(i).darValor();
			multasArr[i] = multa;


		}

		return multasArr;
	}

	public Multa buscar(String id) {
		for (Multa m : lista) {
			if (id == null) {
				return null;
			} else if (m.darId() == id) {
				return m;
			}
		}

		return null;
	}


//	public void Shellsort(Comparable<T>[] datos) {
//		int n = datos.length;
//		int h = 1;
//		while (h < n/3) h = 3*h + 1;
//
//		while (h >= 1) {
//			for (int i = h; i < n; i++) {
//				for (int j = i; j >= h && (datos[j].compareTo(  (T) datos[j-h])<0); j -= h) {
//					Comparable<T> t = datos[j];
//					datos[j] = datos[j-h];
//					datos[j-h] = t;
//				}
//			}
//			h /= 3;
//		}
//	}

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];    // Allocate space just once.      
		sort(a, 0, a.length - 1);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				{
					a[k] = aux[i++];
				}
			} else if ((aux[j].compareTo(aux[i]) < 0)) {
				{
					a[k] = aux[j++];
				}
			} else {
				a[k] = aux[i++];
			}
		}
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	//	public void sortQ(Comparable<T>[] datos)
//	{
//		quickSort(datos, 0, datos.length-1);
//	}
//
//	public void quickSort(Comparable<T>[] datos, int principio, int fin) {
//		if (principio <= fin) {
//			int indiceParticion = partition(datos, principio, fin);
//			quickSort(datos, principio, indiceParticion - 1);
//			quickSort(datos, indiceParticion + 1 , fin);
////		}
//	}
	private static int partition(Comparable[] datos, int principio, int fin) {
		int i = principio;
		int j = fin + 1;
		Comparable pivote = datos[principio];

		while (true) {
			while (datos[++i].compareTo(pivote) < 0)
				if (i == fin)
					break;
			while (pivote.compareTo(datos[--j]) < 0)
				if (j == principio)
					break;
			if (i >= j)
				break;
			exch(datos, i, j);
		}
		exch(datos, principio, j);
		return j;
	}


	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}


	public static boolean isSorted(Comparable<Multa>[] datos) {
		for (int i = 1; i < datos.length; i++)
			if (datos[i].compareTo((Multa) datos[i - 1]) < 0) {
				return false;
			}
		return true;
	}

	private static boolean isHsorted(Comparable[] a, int h) {
		for (int i = h; i < a.length; i++)
			if (less(a[i], a[i - h])) return false;
		return true;
	}

	public LinkedListImp<String> buscarTiemposdeViajeSeparateChaining(String pFecha, String pClaseV, String pInfraccion) {

		LinkedListImp<String> llaves = new LinkedListImp<>();
		String key = pFecha + pClaseV + pInfraccion;
		//		String m = hashTSC.get(key);
		//		System.out.println(m);
		//		return m;

		Iterator<String> iter2 = hashTSC.keys().iterator();
		if (iter2.hasNext()) {
			String m = hashTSC.get(iter2.next());
			//view.displayOp0PrimeroData(m);
		}
		while (iter2.hasNext()) {
			if (iter2.next().equals(key)) {
				String m = hashTSC.get(key);
				llaves.insertarAlFinal(m);
				//				System.out.println(m);
			}
		}

		return llaves;
	}

	public LinkedListImp<String> buscarTiemposdeViajeLinearProb(String pFecha, String pClaseV, String pInfraccion) {
		LinkedListImp<String> valores = new LinkedListImp<>();
		String llave = pFecha + pClaseV + pInfraccion;
		Iterator<String> iter = hashTL.keys().iterator();
		if (iter.hasNext()) {
			String multa = hashTL.get(iter.next());
		}
		while (iter.hasNext()) {
			if (iter.next().equalsIgnoreCase(llave)) {
				String multa = hashTL.get(llave);
				valores.insertarAlFinal(multa);
			}
		}
		return valores;

//			LinkedListImp<Multa> mult = hashTL.get(llaves);

//		Comparable<String>[] llaves = new Comparable[hashTL.getKeysSize()];
//		String key = pFecha+pClaseV+pInfraccion;
//		//		String m = hashTSC.get(key);
//		//		System.out.println(m);
//		//		return m;
//
//		Iterator<String> iter = hashTL.keys().iterator();
//		if(iter.hasNext())
//		{
//			String m = hashTSC.get(iter.next());
//			//view.displayOp0PrimeroData(m);
//		}
//		while(iter.hasNext())
//		{
//			if(iter.next().equals(key))
//			{
//				String m = hashTSC.get(key);
//				llaves
//				//				System.out.println(m);
//			}
//		}


	}
	public void getsAleatoriosSeparate()
	{
		Iterator<String> iter2 = hashTSC.keys().iterator();
		//String key = pFecha+pClaseV+pInfraccion;
		boolean valor = true;
		int actual = 0;
		int numeroRandom = 0;
		int iterable = hashTSC.size();
		for(int i=0; i<8000;i++)
		{
			numeroRandom = (int) (Math.random()*hashTSC.size());


			while(iter2.hasNext()&&valor)
			{
				actual++;
				if(actual==numeroRandom)
				{
					valor=false;
				}

			}
			if(iter2.hasNext())
			{
				String m = hashTSC.get(iter2.next());
//				System.out.println(m);
			}
		}
		for(int j = 0; j<2000; j++)
		{
			String llave = "2019-08-28T07:20:00.000ZBICICLETAH54";
			String L = hashTSC.get(llave);

		}
	}
	public void getsAleatoriosLinearProb() {
		Iterator<String> iter = hashTL.keys().iterator();
		//String key = pFecha+pClaseV+pInfraccion;
		boolean valor = true;
		int actual = 0;
		int numeroRandom = 0;
		int iterable = hashTL.getKeysSize();
		for(int i=0; i<8000;i++)
		{
			numeroRandom = (int) (Math.random()*hashTL.getKeysSize());


			while(iter.hasNext()&&valor)
			{
				actual++;
				if(actual==numeroRandom)
				{
					valor=false;
				}

			}
			if(iter.hasNext())
			{
				String m = hashTL.get(iter.next());
//				System.out.println(m);
			}
		}
		for(int j = 0; j<2000; j++)
		{
			String llave = "2019-08-28T07:20:00.000ZBICICLETAH54";
			String L = hashTL.get(llave);

		}

	}


}






