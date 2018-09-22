package progra.practica2.entities;

import java.util.ArrayList;

public class Airport {
	private Long idAirPort;
	private String ciutat;
	private ArrayList<Airplane> arrAirPlanes;
	private ArrayList<Flight> arrflights;
	
	
	public Airport(Long idAirPort, String ciutat) {
		this.idAirPort = idAirPort;
		this.ciutat = ciutat;
		arrAirPlanes= new ArrayList<Airplane>();
		arrflights= new ArrayList<Flight>();
	}


	public Long getIdAirPort() {
		return idAirPort;
	}


	public void setIdAirPort(Long idAirPort) {
		this.idAirPort = idAirPort;
	}


	public String getCiutat() {
		return ciutat;
	}


	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}


	public ArrayList<Airplane> getArrAirPlanes() {
		return arrAirPlanes;
	}


	public void setArrAirPlanes(ArrayList<Airplane> arrAirPlanes) {
		this.arrAirPlanes = arrAirPlanes;
	}
	
	public ArrayList<Flight> getVols(){
		return arrflights;
	}
	
	
	public String addAirPlane(Airplane airplane) {
		String salida= "El avion ya existe";
		if(!existAirplane(airplane)) {
			arrAirPlanes.add(airplane);
			salida="Afegit " + airplane.toString();
		}
		
		return salida;
	}
	
	
	public String addFlight(Flight flight) {
		String salida= "El vuelo ya existe";
		if(!existirFlight(flight)) {
			arrflights.add(flight);
			salida="S ha afegit el " + flight.toString();
		}
		
		return salida;
	}
	
	public boolean existAirplane(Airplane airplane) {
		return arrAirPlanes.contains(airplane);
	}
	
	public boolean existirFlight(Flight flight) {
		return arrflights.contains(flight);
	}


	@Override
	public String toString() {
		
		String arrAirPlanesText= "";
		for (int i=0; i<arrAirPlanes.size();i++) {
			arrAirPlanesText += "\nAirPlane " + i + ": " + arrAirPlanes.get(i).toString();
		}
		String arrflightsText= "";
		for (int i=0; i<arrflights.size();i++) {
			arrflightsText += "\nAirFlight " + i + ": " + arrflights.get(i).toString();
		}
		
		return "Airport [idAirPort=" + idAirPort + ", ciutat=" + ciutat + ",\narrAirPlanes=" + arrAirPlanesText + "\narrFlight=" + arrflightsText + "]";
	}
	
}
