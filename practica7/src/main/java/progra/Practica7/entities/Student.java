package progra.Practica7.entities;

public class Student extends Person {

	private int curs;
	
	public Student(int edad, boolean estaVivo, int curs) {
		super(edad, estaVivo);
		this.curs=curs;
	}
	
	

	public int getCurs() {
		return curs;
	}



	public void setCurs(int curs) {
		this.curs = curs;
	}



	@Override
	public String toString() {
		return "Stundent: [ " + super.toString() + ", Curs:" + getCurs();
	}


//	@Override
//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Student ) {
//			tipo=true;
//		}
//		return tipo;
//	}



	

	
}
