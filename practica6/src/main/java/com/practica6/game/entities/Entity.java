package com.practica6.game.entities;


public interface Entity {
	int getX();
	int getY();
	void setPos(int y,int x);
	void move(int type);
}
