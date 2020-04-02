package model.data_structures;

public class Node<T extends Comparable<T>> {
	
	private Node<T> anterior;
	private Node<T> siguiente;
	private T valor;
	
	public Node(T pValue, Node<T> pSiguiente, Node<T> pAnterior)
	{
		valor = pValue;
		anterior = pAnterior;
		siguiente = pSiguiente;
	}
	
	public Node<T> darSiguiente()
	{
		return siguiente;
	}
	
	public Node<T> darAnterior()
	{
		return anterior;
	}
	
	public T darValor()
	{
		return valor;
	}
	
	public void cambiarSiguiente(Node<T> pVal)
	{
		siguiente = pVal;
	}
	
	public void cambiarAnterior(Node<T> pValor)
	{
		anterior = pValor;
	}

}
