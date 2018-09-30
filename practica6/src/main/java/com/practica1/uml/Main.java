package com.practica1.uml;

import com.practica1.uml.entities.Dungeon;

public class Main {

	public static void main(String[] args) {
		Dungeon dungeon= new Dungeon(8,7);
		dungeon.addActor(1, 2, '@');
		dungeon.addActor(0, 1, 'V');
		dungeon.addActor(3, 6, 'V');
		dungeon.print();
	}

}
