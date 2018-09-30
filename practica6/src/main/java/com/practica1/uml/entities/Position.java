package com.practica1.uml.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;


@Component
@Scope("prototype")
@Stateful
@LocalBean
public class Position {
	
	//@Autowired
	private int posX;
	//@Autowired
	private int posY;
	
	public Position() {
		posX=0;
		posY=0;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void avanzar() {
		posX++;
	}
}
