package progra.practica3.entities;

public class Book implements toBeStored {
	
	private String writer;
	private String name;
	private Double peso;
	
	public Book(String writer, String name, double peso) {
		this.writer = writer;
		this.name = name;
		this.peso = peso;
		
	}

	public double weight() {
		return peso;
	}

	@Override
	public String toString() {
		return "Book [writer=" + writer + ", name=" + name + ", peso=" + peso + "]";
	}

	public int size() {
		return 1;
	}
	
	


}
