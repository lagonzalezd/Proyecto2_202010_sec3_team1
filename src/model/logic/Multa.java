package model.logic;

import java.util.List;

public class Multa implements Comparable<Multa>
{
	private String OBJECT_ID;
	
	private String CLASE_VEHICULO;
	
	private String TIPO_SERVICIO;
	
	private String INFRACCION;
	
	private String DES_INFRAC;
	
	private String LOCALIDAD;
	
	private String FECHA_HORA;
	
	private List<Double> GEO;

	private String MEDIO_DETECCION;
	
	public Multa(String pClase, String pTipoS, String pInfra, String pDesc, String pLocalidad, String pFechaHora, List<Double> pGeo, String pId, String pMedio)
	{
		CLASE_VEHICULO = pClase;
		TIPO_SERVICIO = pTipoS;
		INFRACCION = pInfra;
		DES_INFRAC = pDesc;
		LOCALIDAD = pLocalidad;
		FECHA_HORA = pFechaHora;
		GEO = pGeo;
		OBJECT_ID = pId;
		MEDIO_DETECCION = pMedio;
	}
	
	public String darClase()
	{
		return CLASE_VEHICULO;
	}
	public String darTipoServicio()
	{
		return TIPO_SERVICIO;
	}
	public String darInfraccion() {
		return INFRACCION;
	}
	public String darDescInfr()
	{
		return DES_INFRAC;
	}
	public String darLocalidad()
	{
		return LOCALIDAD;
	}
	public String darFechaHora(){ return FECHA_HORA; }
	public String darMedioDeteccion(){ return MEDIO_DETECCION; }
	//ToString() mismo formato de view.
	public String toString()
	{
		return OBJECT_ID+"\t"+FECHA_HORA+"\t"+MEDIO_DETECCION+"\t"+CLASE_VEHICULO+"\t"+TIPO_SERVICIO+"\t"+INFRACCION+"\t"+DES_INFRAC+"\t"+LOCALIDAD+"\t"+GEO;

	}
	
	public String darId()
	{
		return OBJECT_ID;
	}
	
	public List<Double>darGeo()
	{
		return GEO;
	}

	@Override
	public int compareTo(Multa pMulta)
	{
		int hora = Integer.parseInt(pMulta.darFechaHora().replaceAll("/",""));
		
		int hora2 = Integer.parseInt(darFechaHora().replaceAll("/", ""));
		int objId = Integer.parseInt(pMulta.darId());
		int objId2 = Integer.parseInt(darId());
	//	System.out.println(hora);

		if(hora == hora2)
			return Integer.compare(objId, objId2);
		else if(hora > hora2)
			return -1;
		else
			return 1;
		
		
	}
}
