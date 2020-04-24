  
package model.data_structures;

public class Value<K> {

	
	private Value<K> siguiente;
	private K info;

	
	public Value(K pDatos){
		info = pDatos;
		siguiente = null;
	}
	
	//Métodos, getters y setters
	public K darInfo(){
		return info;
	}
	
	public Value<K> getNext(){
		return siguiente;
	}
	
	public void cambiarSiguiente(Value<K> pValue){
		siguiente = pValue;
	}
	
}
