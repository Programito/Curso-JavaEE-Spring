package progra.Practica7.entities;

public class Teacher extends Person{
	
	private String grau;
	
	public Teacher(int edad, boolean estaVivo, String grau) {
		super(edad, estaVivo);
		this.grau= grau;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	@Override
	public String toString() {
		return "Teacher: [ " + super.toString() + ", Grau:" + getGrau() + "]";
	}
 	
//	@Override
//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Teacher ) {
//			tipo=true;
//		}
//		return tipo;
//	}
//	
	
}
