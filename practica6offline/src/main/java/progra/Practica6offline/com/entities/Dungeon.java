package progra.Practica6offline.com.entities;

import java.util.Scanner;

public class Dungeon {
	private int turnos;
	private int tamY;
	private int tamX;
	private int numVampire;
	private boolean moveVampire;
	private GameGrid gameGrid;
	private Scanner sc;

	public Dungeon() {
		boolean datosCorrectos = false;
		sc = new Scanner(System.in);
		while (!datosCorrectos) {
			System.out.println("Introduce el numero de turnos:");
			int numTeclado = sc.nextInt();
			this.turnos = numTeclado+1;
			System.out.println("Introduce el numero Y de casillas:");
			numTeclado = sc.nextInt();
			this.tamY = numTeclado;
			System.out.println("Introduce el numero X de casillas:");
			numTeclado = sc.nextInt();
			this.tamX = numTeclado;
			System.out.println("Introduce el numero  de vampiros");
			numTeclado = sc.nextInt();
			this.numVampire = numTeclado;
			System.out.println("Introduce 0 si los vampiros NO se mueven");
			System.out.println("Introduce 1 si los vampiros se MUEVEN");
			numTeclado = sc.nextInt();
			if (numTeclado == 1) {
				this.moveVampire = true;
			} else {
				this.moveVampire = false;
			}
			if(tamX*tamY>numVampire+1) {
				datosCorrectos=true;
				this.gameGrid = new GameGrid(tamY, tamX);
			}
			else {
				System.out.println("Datos incorrectos: Pocas casillas para tantos vampiros " );
			}
		}

	}

	public Dungeon(int turnos, int tamY, int tamX, int numVampire, boolean moveVampire) {
		this.turnos = turnos;
		this.tamY = tamY;
		this.tamX = tamX;
		this.numVampire = numVampire;
		this.moveVampire = moveVampire;
		this.gameGrid = new GameGrid(tamY, tamX);
		sc = new Scanner(System.in);
	}

	public void start() {

		gameGrid.start(numVampire);
		String despl;
		while (true) {
			//printMap();
			print();
			System.out.println("Introduce desplazamineto:");
			despl = sc.nextLine();
			if(moveVampire) {
				gameGrid.moveVampire();
			}
			gameGrid.movePlayer(despl);
			turnos--;
			if (gameGrid.isWin()) {
				System.out.println("Victory");
				return;
			} else if (turnos <= 0) {
				System.out.println("Game Over");
				return;
			}
		}
	}

	public void print() {
		System.out.println("Turnos: " + turnos);
		gameGrid.print();
		gameGrid.printCraracter();
	}

	public void printMap() {
		System.out.println("Turnos: " + turnos);
		gameGrid.print();
	}

}
