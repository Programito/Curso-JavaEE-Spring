package com.practica6.game.entities;

public class Player implements Entity {
	
	private int x;
	private int y;

	public Player(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setPos(int y, int x) {
		this.x=x;
		this.y=y;
	}
	
	public void move(int type) {
		if(type==0) {
			y-=1;
		}
		else if(type==1) {
			x+=1;
		}
		else if(type==2) {
			y+=1;
		}
		else if(type==3) {
			x-=1;
		}
	}
	

	@Override
	public String toString() {
		return "Player [y=" + y + ", x=" + x + "]";
	}

	public int getWebX() {
		return x*50;
	}
	
	public int getWebY() {
		return y*50;
	}
	
	
	
	
	
}
