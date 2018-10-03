package progra.Practica7.entities;

public class Animal implements Action {
	
	private int numPatas;
	
	
	
	
	public Animal(int numPatas) {
		this.numPatas = numPatas;
	}

	public void listen() {
		// TODO Auto-generated method stub
		
	}

	public void eat() {
		// TODO Auto-generated method stub
		
	}

	public void play() {
		// TODO Auto-generated method stub
		
	}

	public void sleep() {
		// TODO Auto-generated method stub
		
	}
	
	public int getNumPatas() {
		return numPatas;
	}
	
	public void setNumPatas(int numPatas) {
		this.numPatas=numPatas;
	}

//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Animal ) {
//			tipo=true;
//		}
//		return tipo;
//	}
//	
//    public int hashCode(Action action) {
//    	return numPatas;
//    }

}
