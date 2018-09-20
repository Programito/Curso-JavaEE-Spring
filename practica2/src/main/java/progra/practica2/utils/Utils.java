package progra.practica2.utils;

import java.util.ArrayList;

import progra.practica2.entities.Airplane;
import progra.practica2.entities.Airport;

public class Utils {
	
	public static String mostrarAviones(ArrayList<Airplane> arrAirplanes) {
		String aviones="";
    	for(int i=0; i<arrAirplanes.size();i++) {
    		aviones += "[" + i + "] " + arrAirplanes.get(i).getName() + ", " + arrAirplanes.get(i).getCapacitat() + "\n";
    	}
    	return aviones;
	}
	
	  public static String mostrarAeropuertos(ArrayList<Airport> arrAirports) {
	    	String aeropuertos="";
	    	for(int i=0; i<arrAirports.size();i++) {
	    		aeropuertos += "[" + i + "]" + arrAirports.get(i).getCiutat() + "\n";
	    	}
	    	return aeropuertos;
	    }
	    
}
