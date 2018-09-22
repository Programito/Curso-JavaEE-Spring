package progra.practica3.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Box implements toBeStored {
	private ArrayList<toBeStored> arrTobeStored;
	int max;
	
	public Box(int max) {
		arrTobeStored= new ArrayList<toBeStored>();
		this.max=max;
	}
	
	public void add(toBeStored tBS) {
		// si es inferior al total menos la caja
		if((totalElem()+tBS.size())<=max) {
			arrTobeStored.add(tBS);
		} else {
			System.out.println("No se anadir " + tBS );
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
		return "Box " +  totalElem() + " things, total weight : " +  df.format(weight()) + " kg";
	}

	public int size() {
		return arrTobeStored.size()+1;
	}
	
	public int totalElem() {
		 int total=0;
		 for(int i=0;i<arrTobeStored.size();i++) {
			 total+=arrTobeStored.get(i).size();
		 }
		 return total;
	}
	
}
