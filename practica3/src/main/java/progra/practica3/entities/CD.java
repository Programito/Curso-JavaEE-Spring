package progra.practica3.entities;

public class CD implements toBeStored {
	
	private String artist;
	private String title;
	private int year;
	
	public CD(String artist, String title, int year) {
		this.artist = artist;
		this.title = title;
		this.year = year;
	}

	public double weight() {
		return 0.1;
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + ", title=" + title + ", year=" + year + ", weight=" + weight()+ "]";
	}
	
	
	
}
