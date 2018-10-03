package progra.Practica7.main;

import java.util.ArrayList;
import java.util.HashMap;

import progra.Practica7.controller.Controller;
import progra.Practica7.entities.Action;
import progra.Practica7.entities.Cat;
import progra.Practica7.entities.Dog;
import progra.Practica7.entities.ET;
import progra.Practica7.entities.Student;
import progra.Practica7.entities.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Controller controller= new Controller();
    	controller.addStudent(12, true, 29);
    	controller.addStudent(14, true, 3);
    	ArrayList<Action> actions=controller.getStudents();
    	//ArrayList<Action> actions=controller.getTipus("Student");
    	if(actions==null) {
    		System.out.println("Student null");
    	}
    	else if(actions.size()>1) {
    		Student student=(Student) actions.get(0);
    		System.out.println(student);
    		 student=(Student) actions.get(1);
     		System.out.println(student);
    	}
    	
    	controller.addTeacher(50, true, "Ciencia");
    	controller.addTeacher(45, true, "Tecnologia");
    	actions=controller.getTipus("Teacher");
    	if(actions==null) {
    		System.out.println("Teacher null");
    	}
    	else if(actions.size()>1) {
    		Teacher teacher=(Teacher) actions.get(0);
    		System.out.println(teacher);
    		 teacher=(Teacher) actions.get(1);
     		System.out.println(teacher);
    	}
    	
    	controller.addCat(4, 7);
    	controller.addCat(4, 6);
    	actions=controller.getTipus("Cat");
     	if(actions==null) {
    		System.out.println("Cat null");
    	}
    	else if(actions.size()>1) {
    		Cat cat=(Cat) actions.get(0);
    		System.out.println(cat);
    		cat =(Cat) actions.get(1);
     		System.out.println(cat);
    	}
     	
     	controller.addDog(4, false);
     	controller.addDog(4, true);
     	actions=controller.getTipus("Dog");
    	if(actions==null) {
    		System.out.println("Dog null");
    	}
    	else if(actions.size()>1) {
    		Dog dog=(Dog) actions.get(0);
    		System.out.println(dog);
    		dog =(Dog) actions.get(1);
     		System.out.println(dog);
    	}
    	
    	controller.addET(true);
    	controller.addET(false);
      	actions=controller.getTipus("ET");
    	if(actions==null) {
    		System.out.println("ET null");
    	}
    	else if(actions.size()>1) {
    		ET et=(ET) actions.get(0);
    		System.out.println(et);
    		et =(ET) actions.get(1);
     		System.out.println(et);
    	}
    }
}
