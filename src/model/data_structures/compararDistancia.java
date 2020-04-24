package model.data_structures;

import model.logic.Comparendo;

import java.util.Comparator;

public class compararDistancia implements Comparator<Comparendo>{

	private Haversine claseDis;
	
	private final static double lat = 4.647586;
	private final static double lon = -74.078122;
	
	@Override
	public int compare(Comparendo o1, Comparendo o2) {
		double distanciaComp1 = claseDis.distance(o1.latitud, o1.longitud, lat, lon);
		double distanciaComp2 = claseDis.distance(o2.latitud, o2.longitud, lat, lon);
		if (distanciaComp1 < distanciaComp2)
			return 1;
		else if (distanciaComp1 > distanciaComp2)
			return -1;
		return 0;
	}

}
