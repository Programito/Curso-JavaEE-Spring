package com.practica6.game.utils;

public class Utils {
	public static int numRandom(int minimo, int maximo) {
		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
		return num;
	}
}
