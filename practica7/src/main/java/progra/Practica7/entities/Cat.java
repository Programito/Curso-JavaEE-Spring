package progra.Practica7.entities;

public class Cat extends Animal {
	
	private int numberLives;
	
	public Cat(int numPatas, int numberLives) {
		super(numPatas);
		this.numberLives=numberLives;
	}

	public int getNumberLives() {
		return numberLives;
	}

	public void setNumberLives(int numberLives) {
		this.numberLives = numberLives;
	}

	@Override
	public String toString() {
		return "Cat [numberLives=" + numberLives + ", getNumberLives=" + getNumberLives() + "]";
	}

//	@Override
//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Cat ) {
//			tipo=true;
//		}
//		return tipo;
//	}
	
	
}
