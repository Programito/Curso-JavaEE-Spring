package progra.practica2;

import java.util.ArrayList;
import java.util.Scanner;

import progra.practica2.controller.PrincipalController;
import progra.practica2.entities.Airplane;
import progra.practica2.entities.Airport;
import progra.practica2.entities.Flight;

public class App 
{
    public static void main( String[] args )
    {

//    	ArrayList<Airplane> arrAirplanes= new ArrayList<Airplane>();
//    	ArrayList<Flight> arrFlights= new ArrayList<Flight>();
//    	ArrayList<Airport> arrAirports= new ArrayList<Airport>();
//    	Long idAirplane=0L;
//    	Long idFlight=0L;
//    	Long idAirport=0L;
//    	
//    	// afegir avions
//    	arrAirplanes.add(new Airplane(idAirplane,"HA-LOL",42));
//    	idAirplane++;
//    	arrAirplanes.add(new Airplane(idAirplane,"G-OWAC",101));
//    	idAirplane++;
//    	
//    	
//    	// afegir aeroports
//    	Airport airport= new Airport(idAirport,"Barcelona");
//    	arrAirports.add(airport);
//    	idAirplane++;
//    	airport= new Airport(idAirport,"Paris");
//    	arrAirports.add(airport);
//    	
//    	airport=arrAirports.get(0);
//    	
//    	
//    	System.out.println("Tria la operacio:");
//    	System.out.println("[1] Afegeix un avio");
//    	System.out.println("[2] Afegeix un vol ");
//    	System.out.println("[x] Sortida"); 
//    	Scanner sc = new Scanner(System.in); 
//    	char option = sc.next().charAt(0); 
//    	System.out.println(option);
//    	
//    	if(option=='1') {
//    		menu1(sc,airport,arrAirplanes);
//    	}
//    	else if(option=='2') {
//    		menu2(sc,idFlight,airport, arrAirplanes,arrAirports);
//    	}
//    	
//    	System.out.println(airport.toString());
//    	System.out.println("------------------------------");
//    	System.out.println(arrAirports.get(0).toString());
    	
    	
    	PrincipalController principalController=new PrincipalController();
    	
        
    }
    
    
    public static void menu1(Scanner sc, Airport airport, ArrayList<Airplane> arrAirplanes) {
    	System.out.println("Doneu un avio:");
    	System.out.println(mostrarAviones(arrAirplanes));
    	int option = sc.nextInt(); 
    	if(option>=0 && option < arrAirplanes.size()) {
    		System.out.println(airport.addAirPlane(arrAirplanes.get(option)));
    	}
    	else {
    		System.out.println("La seleccion no es valida");
    	}
    }
    
    public static void menu2(Scanner sc, Long idFlight, Airport airport, ArrayList<Airplane> arrAirplanes, ArrayList<Airport> arrAirports) {
    	System.out.println("Doneu un avio:");
    	System.out.println(mostrarAviones(arrAirplanes));
    	int option = sc.nextInt();
    	if(! (option>=0) || ! (option < arrAirplanes.size())) {
    		System.out.println("La seleccion no es valida");
    	}
    	else {
        	System.out.println("Doneu el codi de l'aeroport de sortida:");
        	System.out.println(mostrarAeropuertos(arrAirports));
        	int sortida = sc.nextInt();
        	System.out.println("sortida");
        	if(arrAirports.get(sortida).equals(airport)){
        	 	System.out.println("Doneu el codi de l'aeroport de destinació:");
        	 	System.out.println(mostrarAeropuertos(arrAirports));
        	 	int destinacio = sc.nextInt();
        	 	Flight flight= new Flight(idFlight, arrAirplanes.get(option),airport,arrAirports.get(destinacio));
        	 	airport.addFlight(flight);
        	}
        	// el desti es el aiport actual
        	else {
        		//Long idFlight, Airplane airplane, Airport airportSortida, Airport airportDestinacio
        		Flight flight= new Flight(idFlight, arrAirplanes.get(option),arrAirports.get(sortida),airport);
        		airport.addFlight(flight);
        	}
    	}
 
    }
    
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
