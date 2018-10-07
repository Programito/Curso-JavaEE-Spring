package com.practica6.game.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practica6.game.controllers.Dungeon;
import com.practica6.game.controllers.GameGrid;
import com.practica6.game.utils.Position;


@Controller
public class IndexController {
	GameGrid gameGrid;
	
	@GetMapping("/")
	public String hola(Model model) {
		gameGrid=new GameGrid(10,15);
		gameGrid.start(10);
		model.addAttribute("mensaje", "adios");
		model.addAttribute("gameGrid",gameGrid);
		return "game";
	}
	
	
	@RequestMapping(value="/game",method=RequestMethod.GET)
	public String editar( Model model) {
		if(gameGrid==null) {
			gameGrid=new GameGrid(10,15);
//			gameGrid.addPlayer(4, 4);
//			gameGrid.addVampire(1, 1);
//			gameGrid.addVampire(2, 1);
			gameGrid.start(10);
		}
		model.addAttribute("mensaje", "hola");
		model.addAttribute("gameGrid",gameGrid);
		return "game";
	}
	
	// PathVariable inyecta el valor del parametro de la ruta
	@RequestMapping(value="/game/{id}",method=RequestMethod.GET)
	public String editar(@PathVariable(value="id") int id, Model model) {
		if(gameGrid==null) {
			gameGrid=new GameGrid(10,15);
			gameGrid.start(10);
			return "game";
		}
		if(id>=0) {
			if(id==0) {
				gameGrid.movePlayer("w");
			}
			else if(id==1) {
				gameGrid.movePlayer("d");
			}
			else if(id==2) {
				gameGrid.movePlayer("s");
			}
			else if(id==3) {
				gameGrid.movePlayer("a");
			}
			gameGrid.moveVampire();
		}
		model.addAttribute("mensaje", "hola");
		model.addAttribute("gameGrid",gameGrid);
		return "game";
	}
}
