package progra.practica2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import progra.practica2.entities.Airplane;
import progra.practica2.entities.Airport;
import progra.practica2.entities.Flight;
import progra.practica2.utils.Utils;

public class AirplaneController {
	
	private Airport airport;
	private Scanner sc;
	
	public AirplaneController(Scanner sc, Airport airport) {
		this.sc=sc;
		this.airport=airport;
	}
	
	public int start() {
		int option=4;
		writeTextOption1();
		char a = sc.next().charAt(0); 
		
		// menu afegir 
		if(a=='1') {
			option=5;
		}
		
		// menu mostrar
		else if(a=='2') {
			option=6;
		}
		else if(a=='x') {
			option=0;
		}else {
			System.out.println("No es una opcion valida en el aeropuerto");
		}
		return option;
	}
	
	public int menu1() {
		int option=5;
		writeAfegirOption();
		char a = sc.next().charAt(0);
		
		//afegir avio
		if(a=='1') {
			option=7;
		}
		
		// afegir vol
		else if(a=='2') {
			option=8;
			
		// sortir
		}else if(a=='x') {
			option=4;
		}
		return option;
		
	}
	
	public void writeTextOption1() {
		System.out.println("Tria la operacio:");
    	System.out.println("[1] Afegir vols o avions");
    	System.out.println("[2] Mostrar vols o avions");
    	System.out.println("[x] Sortida"); 
	}
	
	public void writeAfegirOption() {
		System.out.println("Tria la operacio:");
    	System.out.println("[1] Afegeix un avio");
    	System.out.println("[2] Afegeix un vol ");
    	System.out.println("[x] Sortida"); 
	}
	
	public int afegirAvio(ArrayList<Airplane> arrAirplanes) {
		int option=7;
		System.out.println("Doneu un avio:");
    	System.out.println(Utils.mostrarAviones(arrAirplanes));
    	int posAvio = sc.nextInt(); 
    	if(posAvio>=0 && posAvio < arrAirplanes.size()) {
    		airport.addAirPlane(arrAirplanes.get(posAvio));	
    		System.out.println("Afegit " + arrAirplanes.get(posAvio));
    		option=4;
    	}
    	else {
    		System.out.println("La seleccion no es valida");
    	}
    	return option;
	}
	
	public int afegirVol(ArrayList<Airplane> arrAirplanes, ArrayList<Flight> arrFlights, ArrayList<Airport> arrAirports, Long idFlight) {
		int option=8;
    	System.out.println("Doneu un avio:");
    	System.out.println(Utils.mostrarAviones(arrAirplanes));
    	String text="";
    	int posicio = sc.nextInt();
    	if(! (posicio>=0) || ! (posicio < arrAirplanes.size())) {
    		System.out.println("La seleccion no es valida");
    	}
    	else {
        	System.out.println("Doneu el codi de l'aeroport de sortida:");
        	System.out.println(Utils.mostrarAeropuertos(arrAirports));
        	int sortida = sc.nextInt();
        	if(arrAirports.get(sortida).equals(airport)){
        	 	System.out.println("Doneu el codi de l'aeroport de destinació:");
        	 	System.out.println(Utils.mostrarAeropuertos(arrAirports));
        	 	int destinacio = sc.nextInt();
        	 	Flight flight= new Flight(idFlight, arrAirplanes.get(posicio),airport,arrAirports.get(destinacio));
        	 	text=airport.addFlight(flight);
        	 	arrFlights.add(flight);
        	 	option=4;
        	}
        	// el desti es el aiport actual
        	else {
        		//Long idFlight, Airplane airplane, Airport airportSortida, Airport airportDestinacio
        		Flight flight= new Flight(idFlight, arrAirplanes.get(posicio),arrAirports.get(sortida),airport);
        		text=airport.addFlight(flight);
        		arrFlights.add(flight);
        		option=4;
        	}
    	}
    	System.out.println(text);
    	return option;
	}
}
