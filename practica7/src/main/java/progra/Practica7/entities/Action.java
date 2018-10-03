package progra.Practica7.entities;

public interface Action {
	public static final boolean HANVIVIDO=true;
	
	void listen();
	void eat();
	void play();
	void sleep();
//    boolean equals(Action action);
//	int hashCode();
}
