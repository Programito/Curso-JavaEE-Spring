package progra.practica2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import progra.practica2.entities.Airplane;
import progra.practica2.entities.Airport;
import progra.practica2.entities.Flight;

public class PrincipalController {

	private ArrayList<Airplane> arrAirplanes;
	private ArrayList<Flight> arrFlights;
	private ArrayList<Airport> arrAirports;

	private Long idAirplane;
	private Long idFlight;
	private Long idAirport;

	private AirplaneController airplaneController;
	private Airport airportActual;
	
	private String[] nomOpcio;
	
	public PrincipalController() {
		arrAirplanes = new ArrayList<Airplane>();
		arrFlights = new ArrayList<Flight>();
		arrAirports = new ArrayList<Airport>();
		idAirplane = idFlight = idAirport = 0L;

		addAirports();
		addAirplanes();
		
		nomOpcio=new String[14];
		nomOpcio[0]="Controlador de tots els aeroports";
		nomOpcio[1]="Seleccionar un aeroport";
		nomOpcio[2]="Mostrar tots els avions de TOTS els aeroports";
		nomOpcio[3]="Mostrar tots els vols de TOTS els aeroports";
		nomOpcio[4]="Menu per afegir o mostrar d UN aeroport";
		nomOpcio[5]="Menu afegir d UN aeroport";
		nomOpcio[6]="Menu mostrar d UN aeroport";
		nomOpcio[7]="Menu afegir avio a UN aeroport";
		nomOpcio[8]="Menu afegir vol a UN aeroport";
		nomOpcio[9]="Mostrar avions per UN aeroport";
		nomOpcio[10]="Mostrar vols per UN aeroport";
		nomOpcio[11]="Afegir un avio a TOTS el aeroports";
		nomOpcio[12]="Afegir un aeroport";
		nomOpcio[13]="Opcio NO valida";
		start();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		airportActual = null;
		airplaneController = null;

		while (true) {
			
			System.out.println("----------------------------------------------------------------------");
			if(option>=0 && option<=12 ) {
				System.out.println(nomOpcio[option]);
			}
			else {
				System.out.println(nomOpcio[13]);
			}
			
			// Opcio de tots el aeroports
			if (option == 0) {
				option = mostrarOpcions1(sc);
				if(option==4) {
					option=11;
				}
				else if(option==5) {
					option=12;
				}
				else if(option<0 || option > 5) {
					option=0;
				}
			}

			// Seleccionar aeroport
			else if (option == 1) {
				if (airportActual == null) {
					airportActual = seleccionarAeroport(sc);
				} else if (airportActual != null) {
					System.out.println("Seleccionat " + airportActual.getCiutat());
					airplaneController = new AirplaneController(sc, airportActual);
					option = 4;
				}
			}

			// mostrar tots el avions
			else if (option == 2) {
				mostrarAirplanes();
				option = 0;
			}

			// mostrar tots el vols
			else if (option == 3) {
				mostrarFlights();
				option = 0;
			}

			// menu afegir o mostrar de l aeroport
			else if (option == 4) {
				option = airplaneController.start();
			}
			
			// menu afegir de l aeroport
			else if (option == 5) {
				option = airplaneController.menu1();

			} 
			// menu mostrar d l aeroport
			else if (option == 6) {
				option=airplaneController.menu2();
			}
			
			// menu afegir avio
			else if (option == 7) {
				option=airplaneController.afegirAvio(arrAirplanes);
			}
			
			//menu afegir vol
			else if (option == 8) {
				option=airplaneController.afegirVol(arrAirplanes, arrFlights, arrAirports, idFlight);
			}
			
			//mostrar avions d 1 aeroport
			else if (option == 9) {
				airplaneController.mostrarAvions();
				option=4;
			}
			
			//mostrar vols d 1 aeroport
			else if (option == 10) {
				airplaneController.mostrarVols();
				option=4;
			}
			
			// afegir un avio a tots el aeroports
			else if(option == 11) {
				afegirAvio(sc);
				option=0;
			}
			
			// afegir un aeroport
			else if(option== 12) {
				afegirAeroport(sc);
				option=0;
			}

			//opcio no valida
			else {
				option = 0;
				airportActual = null;
				airplaneController = null;
			}
		}
	}

	//Inicialitzar aeroports
	public void addAirports() {
		// afegir aeroports
		arrAirports.add(new Airport(idAirport, "Barcelona"));
		idAirport++;
		arrAirports.add(new Airport(idAirport, "Paris"));
		idAirport++;
		arrAirports.add(new Airport(idAirport, "New York"));
		idAirport++;
		arrAirports.add(new Airport(idAirport, "Londres"));
		idAirport++;
	}

	//Inicialitzar avions
	public void addAirplanes() {
		arrAirplanes.add(new Airplane(idAirplane, "HA-LOL", 42));
		idAirplane++;
		arrAirplanes.add(new Airplane(idAirplane, "G-OWAC", 101));
		idAirplane++;
		arrAirplanes.add(new Airplane(idAirplane, "Fly:03", 80));
		idAirplane++;
	}

	public void mostrarAirports() {
		String text = "";
		for (int i = 0; i < arrAirports.size(); i++) {
			text += "[" + i + "]" + arrAirports.get(i).getCiutat() + "\n";
		}
		System.out.println(text);
	}

	public void mostrarAirplanes() {
		String text = "";
		for (int i = 0; i < arrAirplanes.size(); i++) {
			text += "[" + i + "]" + arrAirplanes.get(i).toString() + "\n";
		}
		System.out.println(text);
	}

	public void mostrarFlights() {
		String text = "";
		for (int i = 0; i < arrFlights.size(); i++) {
			text += "[" + i + "]" + arrFlights.get(i).toString() + "\n";
		}
		System.out.println(text);
	}

	public Airport seleccionarAeroport(Scanner sc) {
		System.out.println("Tria un airport:");
		mostrarAirports();
		int option = sc.nextInt();
		Airport airport;
		if (option >= 0 && option < arrAirports.size()) {
			airport = arrAirports.get(option);
		} else {
			System.out.println("La seleccion no es valida");
			airport = null;
		}

		return airport;
	}

	public int mostrarOpcions1(Scanner sc) {
		System.out.println("Aeroports: ");
		System.out.println("[1] Seleccionar aeroport");
		System.out.println("[2] Mostrar avions");
		System.out.println("[3] Mostrar vols");
		System.out.println("[4] Afegir un Avio");
		System.out.println("[5] Afegir un Aeroport");
		int option = sc.nextInt();
		return option;
	}
	
	public void afegirAvio(Scanner sc) {
		System.out.println("Introduir nou avio");
		System.out.println("Introdudeix Nom:");
		String nom=sc.next();
		System.out.println("Introdudeix Capacitat:");
		int capacitat = sc.nextInt();
		arrAirplanes.add(new Airplane(idAirplane, nom, capacitat));
		idAirplane++;
	}
	
	public void afegirAeroport(Scanner sc) {
		System.out.println("Introduir nou aeroport");
		System.out.println("Introdudeix Ciuat:");
		String ciutat=sc.next();
		arrAirports.add(new Airport(idAirport, ciutat));
		idAirport++;
	}
}
