package progra.practica8.com.entities;

import progra.practica8.com.utils.Utils;

public class Fil implements Runnable, Comparable<Fil> {
	private int numero;
	private int posInicial;

	public Fil(int posInicial) {
		numero = 0;
		this.posInicial=posInicial;
	}

	public void run() {
		numero = Utils.generaNumeroAleatorio(0, 10);
	}

	public int getNumero() {
		return numero;
	}
	
	public int posInicial() {
		return posInicial;
	}

	public int compareTo(Fil fil) {
//		return getNumero().compareTo(fil.getNumero());
		return  getNumero()-fil.getNumero();
	}

}
