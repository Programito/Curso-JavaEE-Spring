package progra.Practica7.entities;

public class Dog extends Animal {
	
	private boolean isVaccinated;
	
	public Dog(int numPatas,boolean isVaccinated) {
		super(numPatas);
		this.isVaccinated=isVaccinated;
	}

	public boolean isVaccinated() {
		return isVaccinated;
	}

	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}

	@Override
	public String toString() {
		return "Dog [isVaccinated=" + isVaccinated() + ", NumPatas=" + getNumPatas() + "]";
	}
	
//	
//	@Override
//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Dog ) {
//			tipo=true;
//		}
//		return tipo;
//	}
//	
	


 
}
