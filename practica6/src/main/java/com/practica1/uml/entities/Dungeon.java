package com.practica1.uml.entities;

public class Dungeon {
	int numX, numY;
	char[][] dungeon;
	int numVampire;

	public Dungeon(int numY, int numX) {
		this.numX = numX;
		this.numY = numY;
		dungeon = new char[numY][numX];
		numVampire = 0;
		for (int i = 0; i < numY; i++) {
			for (int j = 0; j < numX; j++) {
				dungeon[i][j] = '.';
			}
		}
	}

	public Actor addActor(int posY, int posX, char letra) {
		Actor actor=null;
		if(dungeon[posY][posX]=='.') {
			if(letra=='@') {
				dungeon[posY][posX]='@';
				actor=new Player(posY,posX);
			}
			else if(letra=='V') {
				dungeon[posY][posX]='V';
				actor=new Vampire(posY,posX);
				numVampire++;
			}
		}
		return actor;
	}

	public void print() {
		for (int i = 0; i < numY; i++) {
			for (int j = 0; j < numX; j++) {
				System.out.print(dungeon[i][j]);
			}
			System.out.println();
		}

	}
}