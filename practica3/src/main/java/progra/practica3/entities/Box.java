package progra.practica3.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Box {
	private ArrayList<toBeStored> arrTobeStored;
	int max;
	
	public Box(int max) {
		arrTobeStored= new ArrayList<toBeStored>();
		this.max=max;
	}
	
	public void add(toBeStored tBS) {
		if(arrTobeStored.size()<=max) {
			arrTobeStored.add(tBS);
		} else {
			System.out.println("No se puede anadir mas");
		}
	}
	
	public double weight() {
		double total=0;
		for(int i=0;i<arrTobeStored.size();i++) {
			total+=arrTobeStored.get(i).weight();
		}
		return total;
	}

	@Override
	public String toString() {
		 DecimalFormat df = new DecimalFormat("#.00");
		return "Box " + arrTobeStored.size() + " things, total weight : " +  df.format(weight()) + " kg";
	}
	
	
}
