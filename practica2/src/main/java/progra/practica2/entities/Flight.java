package progra.practica2.entities;

public class Flight {
	private Long idFlight;
	private Airplane airplane;
	private Airport airportSortida, airportDestinacio;
	
	
	public Flight(Long idFlight, Airplane airplane, Airport airportSortida, Airport airportDestinacio) {
		this.idFlight = idFlight;
		this.airplane = airplane;
		this.airportSortida = airportSortida;
		this.airportDestinacio = airportDestinacio;
	}
	public Long getIdFlight() {
		return idFlight;
	}
	public void setIdFlight(Long idFlight) {
		this.idFlight = idFlight;
	}
	public Airplane getAirplane() {
		return airplane;
	}
	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}
	public Airport getAirportSortida() {
		return airportSortida;
	}
	public void setAirportSortida(Airport airportSortida) {
		this.airportSortida = airportSortida;
	}
	public Airport getAirportDestinacio() {
		return airportDestinacio;
	}
	public void setAirportDestinacio(Airport airportDestinacio) {
		this.airportDestinacio = airportDestinacio;
	}
	@Override
	public String toString() {
		return "Flight [idFlight=" + idFlight + ", airplane=" + airplane + ", airportSortida=" + airportSortida.getCiutat() +  ", airportDestinacio=" + airportDestinacio.getCiutat() + "]";
	}
	
	
}
