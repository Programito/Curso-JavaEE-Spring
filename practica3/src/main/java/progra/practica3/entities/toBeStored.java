package progra.practica3.entities;

public interface toBeStored {
	
	// no te sentit ja que es modificaria a les subclases
	//public static final double weight=0.1;
	
	double weight();
	@Override
	String toString();
	int size();
}
