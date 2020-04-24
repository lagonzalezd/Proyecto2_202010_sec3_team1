package model.data_structures;


public class llaveC implements Comparable<llaveC>{

	private int id;


	public llaveC(int pObjId){
		id = pObjId;
	}


	public int darId(){
		return id;
	}


	public int compareTo(llaveC arg0) {
		
		if (id>arg0.darId())
			return 1;
		else if (id<arg0.darId())
			return -1;
		return 0;
	}


}