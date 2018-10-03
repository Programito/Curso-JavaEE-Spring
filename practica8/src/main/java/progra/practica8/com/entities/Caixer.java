package progra.practica8.com.entities;

import progra.practica8.com.utils.Utils;

public class Caixer implements Runnable {

	private int persones;
	private int temps;

	public Caixer() {
		persones = Utils.generaNumeroAleatorio(10, 15);
		temps = 0;
	}

	public void run() {
		for (int i = 0; i < persones; i++) {
			temps += Utils.generaNumeroAleatorio(10, 15);
			try {
				Thread.sleep(temps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public int getPersones() {
		return persones;
	}

	public int getTemps() {
		return temps;
	}

	@Override
	public String toString() {
		return "Caixer [persones=" + persones + ", temps=" + temps + "]";
	}

}