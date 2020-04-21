package model.data_structures;

public class Key {

	private int llave;
	
	public Key(int pllave){
		llave = pllave;
	}
	public int compareTo(Key key) {
		if(key.llave > this.llave)
			return 1;
		else if(key.llave < this.llave)
			return -1;
		else{
			return 0;
		}
	}
}
