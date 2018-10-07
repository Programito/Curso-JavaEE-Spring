package com.practica6.game.entities;

import java.util.ArrayList;

import com.practica6.game.utils.Constantes;
import com.practica6.game.utils.Utils;




public class Characters {
	
	
	Entity player;
	ArrayList<Entity> vampires;

	

	public Characters() {
		player= new Player(0,0);
		vampires=new ArrayList<Entity>();
	}
	
	public void addVampire(int posY,int posX) {
		vampires.add(new Vampire(posY,posX));
	}
	
	public void addPlayer(int posY,int posX) {
		player.setPos(posY, posX);
	}
	
	public Entity getPlayer() {
		return player;
	}
	
	public void movePlayer(int desplY,int desplX,int maxY,int maxX) {
		int x=player.getX()+desplX;
		int y=player.getY()+desplY;
		if(x<0) {
			x=0;
		}
		else if(x>maxX-1) {
			x=maxX-1;
		}
		if(y<0) {
			y=0;
		}
		else if(y>maxY-1) {
			y=maxY-1;
		}
		player.setPos(y, x);
		
	}
		
	public char[][] moveVampire(char[][] dungeon){
		for(int i=0;i<vampires.size();i++) {
			ArrayList<Integer> posicionesValidas=new ArrayList<Integer>();
			// Agujas del reoj: 0 arriba, 1 derecha, 2 abajo , 3 izquierda
			if(vampires.get(i).getY()-1>=0 && dungeon[vampires.get(i).getY()-1][vampires.get(i).getX()]==Constantes.getLetraVacia()) {
				posicionesValidas.add(0);
			}
			if(vampires.get(i).getX()+1<dungeon[0].length && dungeon[vampires.get(i).getY()][vampires.get(i).getX()+1]==Constantes.getLetraVacia()) {
				posicionesValidas.add(1);
			}
			if(vampires.get(i).getY()+1<dungeon.length && dungeon[vampires.get(i).getY()+1][vampires.get(i).getX()]==Constantes.getLetraVacia()) {
				posicionesValidas.add(2);
			}
			if(vampires.get(i).getX()-1>=0 && dungeon[vampires.get(i).getY()][vampires.get(i).getX()-1]==Constantes.getLetraVacia()) {
				posicionesValidas.add(3);
			}
			
			System.out.println(posicionesValidas);
			if(posicionesValidas.size()>0) {
				int mov=posicionesValidas.get(Utils.numRandom(0, posicionesValidas.size()-1));
				dungeon[vampires.get(i).getY()][vampires.get(i).getX()]=Constantes.getLetraVacia();
				vampires.get(i).move(mov);
				dungeon[vampires.get(i).getY()][vampires.get(i).getX()]=Constantes.getLetraVampire();
			}
		}
		
		
		return dungeon;
	}
	
	public void deleteVampire(int y, int x) {
		boolean encontrado=false;
		for(int i=0;i<vampires.size() && !encontrado;i++) {
			if(vampires.get(i).getY()==y && vampires.get(i).getX()==x) {
				vampires.remove(i);
				encontrado=true;
				System.out.println("Eliminado el vampiro pos" + x +" ," + y);
			}
		}
	}
	
	public boolean isWin() {
		return vampires.size()==0;
	}

	public void print() {
		System.out.println(player);
		for(int i=0;i<vampires.size();i++) {
			System.out.print(vampires.get(i));
			if(i<vampires.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println("");
	}
	
	public ArrayList<Entity> getVampires() {
		return vampires;
	}
	
}
