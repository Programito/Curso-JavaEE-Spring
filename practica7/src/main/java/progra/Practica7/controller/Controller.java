package progra.Practica7.controller;

import java.util.ArrayList;
import java.util.HashMap;

import progra.Practica7.entities.Action;
import progra.Practica7.entities.Cat;
import progra.Practica7.entities.Dog;
import progra.Practica7.entities.ET;
import progra.Practica7.entities.Student;
import progra.Practica7.entities.Teacher;

public class Controller {
	private HashMap<String, ArrayList<Action>> seres;
	// aquesta solucion no la utilitzo perque en aquest exercici hashCode no
	// permitiria ficar objectes del mateix tipus amb els mateixus atributs ja que no tenim id
	// private HashMap<Action,ArrayList<Action>> seres2;

	public Controller() {
		seres = new HashMap<String, ArrayList<Action>>();
	}

	public void addStudent(int edad, boolean estaVivo, int curs) {
		Action student = new Student(edad, estaVivo, curs);
		
		if (!seres.containsKey("Student")) {
			ArrayList<Action> arStudents=new ArrayList<Action>();
			arStudents.add(student);
			seres.put("Student",arStudents);	
		}
		else {
			seres.get("Student").add(student);
		}
	}
	
	public ArrayList<Action> getStudents(){
		return getTipus("Student");
	}

	public void addTeacher(int edad, boolean estaVivo, String grau) {
		Action teacher= new Teacher(edad,estaVivo,grau);
		String tipusKey="Teacher";
		if (!seres.containsKey(tipusKey)) {
			ArrayList<Action> arStudents=new ArrayList<Action>();
			arStudents.add(teacher);
			seres.put(tipusKey,arStudents);
		}
		else {
			seres.get(tipusKey).add(teacher);
		}
	}
	
	public void addDog(int numPatas,boolean isVaccinated) {
		Action dog= new Dog(numPatas,isVaccinated);
		String tipusKey="Dog";
		if (!seres.containsKey(tipusKey)) {
			ArrayList<Action> arStudents=new ArrayList<Action>();
			arStudents.add(dog);
			seres.put(tipusKey,arStudents);
		}
		else {
			seres.get(tipusKey).add(dog);
		}
	}
	
	public void addCat(int numPatas, int numberLives) {
		Action cat= new Cat(numPatas,numberLives);
		String tipusKey="Cat";
		if (!seres.containsKey(tipusKey)) {
			ArrayList<Action> arStudents=new ArrayList<Action>();
			arStudents.add(cat);
			seres.put(tipusKey,arStudents);
		}
		else {
			seres.get(tipusKey).add(cat);
		}
	}
	
	public void addET(boolean isMortal) {
		Action et= new ET(isMortal);
		String tipusKey="ET";
		if (!seres.containsKey(tipusKey)) {
			ArrayList<Action> arStudents=new ArrayList<Action>();
			arStudents.add(et);
			seres.put(tipusKey,arStudents);
		}
		else {
			seres.get(tipusKey).add(et);
		}
	}

	
	public ArrayList<Action> getTipus(String tipusKey){
		ArrayList<Action> arTipus=null;
		if (seres.containsKey(tipusKey)) {
			arTipus=seres.get(tipusKey);
		}
		return arTipus;
	}




}
