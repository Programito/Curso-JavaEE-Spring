package progra.practica8.com.utils;

import progra.practica8.com.entities.Fil;

public class Utils {
	public static int generaNumeroAleatorio(int minimo, int maximo) {

		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;
	}
	
	public static void getText(Fil fil, int pos) {
		System.out.println(fil.posInicial() + " ha finalitzat en la pos: " + pos);
		int valorFinal=fil.getNumero() + + pos;
		System.out.println("El valor final es :  " + valorFinal + " [numero:" + fil.getNumero() + ", " + "pos: " + pos + "]");
	}
}
