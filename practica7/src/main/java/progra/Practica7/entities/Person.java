package progra.Practica7.entities;

public class Person implements Action, HumanAction, TerrestreAction {
	
	private int edad;
	private boolean estaVivo;
	
	public Person(int edad,boolean estaVivo) {
		this.edad=edad;
		this.estaVivo=estaVivo;
	}

	public void talk() {
		// TODO Auto-generated method stub
		
	}

	public void createPrograms() {
		// TODO Auto-generated method stub
		
	}

	public void study() {
		// TODO Auto-generated method stub
		
	}

	public void playViolin() {
		// TODO Auto-generated method stub
		
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	

	public boolean isEstaVivo() {
		return estaVivo;
	}

	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	@Override
	public String toString() {
		return "Person [edad=" + edad + ", estaVivo=" + estaVivo + "]";
	}

//	public boolean equals(Action action) {
//		boolean tipo=false;
//		if(action instanceof Person ) {
//			tipo=true;
//		}
//		return tipo;
//	}
	
}
