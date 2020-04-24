package model.data_structures;

public class Nodo<K extends Comparable <K> ,V> {

	private K llave;
	private int tamanio;
	private boolean color;
	private Value<V> valor;
	private Nodo<K,V> izq, der;

	
	public Nodo(K k, V v, boolean c){
		llave = k;
		color = c;
		izq = null;
		der = null;
		valor = new Value<V>(v);
	}
	
	public void agregarValor(V pValue){
		Value<V> temp = valor;
		valor = new Value<V>(pValue);
		valor.cambiarSiguiente(temp);
		tamanio++;
	}
	
	public void cambiarValor(V pValue){
		valor = new Value<V>(pValue);
		tamanio = 1;
	}
	
	public K darLlave(){
		return llave;
	}
	
	public Value<V> darValor(){
		return valor;
	}
	
	public Nodo<K,V> darDerecha(){
		return der;
	}
	
	public Nodo<K,V> darIzquierda(){
		return izq;
	}
	
	public int darTamanio(){
		return tamanio;
	}
	
	public boolean darColor(){
		return color;
	}
	

	
	public void cambiarIzq(Nodo<K,V> pLeft){
		izq = pLeft;
	}
	
	public void cambiarColor(boolean pColor){
		color = pColor;
	}
	
	
	public void setRight(Nodo<K,V> pRight){
		der= pRight;
	}
	

	
}
