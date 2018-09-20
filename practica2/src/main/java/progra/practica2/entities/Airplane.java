package progra.practica2.entities;

public class Airplane {
	private Long idAirplane;
	private String name;
	private int capacitat;
	
	
	public Airplane() {
		
	}
	
	public Airplane(Long idAirplane, String name, int capacitat) {
		this.idAirplane = idAirplane;
		this.capacitat = capacitat;
		this.name= name;
	}
	
	public Long getIdAirplane() {
		return idAirplane;
	}
	public void setIdAirplane(Long idAirplane) {
		this.idAirplane = idAirplane;
	}
	public int getCapacitat() {
		return capacitat;
	}
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Airplane [idAirplane=" + idAirplane + ", name= " + name + ", capacitat=" + capacitat + "]";
	}
	
	
	
}
