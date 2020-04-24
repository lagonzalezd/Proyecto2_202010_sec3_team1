package model.logic;

import model.data_structures.llaveC;

public class Comparendo implements Comparable<Comparendo> {
	
	public String INFRACCION;
	public String DES_INFRACCION;
	public String LOCALIDAD;
	public String MUNICIPIO;
	public String FECHA_HORA;
	public String MEDIO_DETECCION;
	public String CLASE_VEHICULO;
	public String TIPO_SERVICIO;
	public int OBJECTID;

	public llaveC key;
	
	public double longitud;
	public double latitud;
	
	public Comparendo(int objectID, String fechaHora, String medioDeteccion, String claseVehiculo, String tipoServicio, String infraccion, String desInfraccion, String localidad, String municipio, double latitud, double longitud){
		this.OBJECTID = objectID;
		this.FECHA_HORA = fechaHora;
		this.MEDIO_DETECCION = medioDeteccion;
		this.CLASE_VEHICULO = claseVehiculo;
		this.TIPO_SERVICIO = tipoServicio;
		this.INFRACCION = infraccion;
		this.DES_INFRACCION = desInfraccion;
		this.LOCALIDAD = localidad;
		this.MUNICIPIO = municipio;
	
		this.longitud = longitud;
		this.latitud = latitud;
		
		this.key = new llaveC(OBJECTID);
	}
	
	public llaveC darLlave(){
		return key;
	}
	
	@Override
	public int compareTo(Comparendo ob) {
		return OBJECTID>ob.OBJECTID ? 1 : OBJECTID<ob.OBJECTID ? -1 : 0;
	}
	
	
	public String toString(){
		return OBJECTID + ", " + FECHA_HORA + ", " + INFRACCION + ", "
				+ ", " + CLASE_VEHICULO + ", " + TIPO_SERVICIO + ", "
				+ ", " + LOCALIDAD;
	}
	

}