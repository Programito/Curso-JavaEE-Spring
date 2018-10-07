package com.practica6.game.controllers;

import java.util.ArrayList;

import com.practica6.game.entities.Characters;
import com.practica6.game.entities.Entity;
import com.practica6.game.utils.Constantes;
import com.practica6.game.utils.Utils;





public class GameGrid {
	int numX, numY;
	char[][] dungeon;
	private Characters characters;

	public GameGrid(int numY, int numX) {
		this.numX = numX;
		this.numY = numY;
		dungeon = new char[numY][numX];
		for (int i = 0; i < numY; i++) {
			for (int j = 0; j < numX; j++) {
				dungeon[i][j] = '.';
			}
		}
		characters = new Characters();
	}

	public void start(int numVampire) {
		int i = 0;
		while (i < numVampire) {
			int posY = Utils.numRandom(0, numY - 1);
			int posX = Utils.numRandom(0, numX-1);
			if (dungeon[posY][posX] == Constantes.getLetraVacia()) {
				dungeon[posY][posX] = Constantes.getLetraVampire();
				characters.addVampire(posY, posX);
				i++;
			}
		}
		i = 0;
		while (i == 0) {
			int posY = Utils.numRandom(0, numY - 1);
			int posX = Utils.numRandom(0, numX-1);
			if (dungeon[posY][posX] == Constantes.getLetraVacia()) {
				dungeon[posY][posX] = Constantes.getLetraPlayer();
				characters.addPlayer(posY, posX);
				i++;
			}
		}
	}

	public boolean addActor(int posY, int posX, char letra) {
		boolean afegit = false;
		if (dungeon[posY][posX] == Constantes.getLetraVacia()) {
			afegit = true;
			dungeon[posY][posX] = letra;
		}
		return afegit;
	}

	public boolean addPlayer(int posY, int posX) {
		boolean afegit = false;
		afegit = addActor(posY, posX, Constantes.getLetraPlayer());
		if (afegit) {
			characters.addPlayer(posY, posX);
		}
		return afegit;
	}

	public boolean addVampire(int posY, int posX) {
		boolean afegit = false;
		afegit = addActor(posY, posX, Constantes.getLetraVampire());
		if (afegit) {
			characters.addVampire(posY, posX);
		}
		return afegit;
	}

	public void movePlayer(String mov) {
		int desplX = 0;
		int desplY = 0;
		for (int i = 0; i < mov.length(); i++) {
			char a = mov.charAt(i);
			if ((int) a == 65 || (int) a == 97) {
				desplX -= 1;
			} else if ((int) a == 87 || (int) a == 119) {
				desplY -= 1;
			} else if ((int) a == 83 || (int) a == 115) {
				desplY += 1;
			} else if ((int) a == 68 || (int) a == 100) {
				desplX += 1;
			}
		}

		dungeon[characters.getPlayer().getY()][characters.getPlayer().getX()] = Constantes.getLetraVacia();
		characters.movePlayer(desplY, desplX, numY, numX);
		// Eliminar vampiro si esta en esa posicion
		if (dungeon[characters.getPlayer().getY()][characters.getPlayer().getX()] == Constantes.getLetraVampire()) {
			characters.deleteVampire(characters.getPlayer().getY(), characters.getPlayer().getX());
		}
		dungeon[characters.getPlayer().getY()][characters.getPlayer().getX()] = Constantes.getLetraPlayer();

	}
	
	public void moveVampire() {
		this.dungeon=characters.moveVampire(dungeon);
	}

	public boolean isWin() {
		return characters.isWin();
	}

	public void print() {
		for (int i = 0; i < numY; i++) {
			for (int j = 0; j < numX; j++) {
				System.out.print(dungeon[i][j]);
			}
			System.out.println();
		}
	}

	public void printCraracter() {
		characters.print();
	}
	
	public Entity getPlayer() {
		return characters.getPlayer();
	}
	
	public ArrayList<Entity> getVampires(){
		return characters.getVampires();
	}
}