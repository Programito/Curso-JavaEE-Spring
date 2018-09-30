package com.practica1.uml.web.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.practica1.uml.entities.Position;


@Controller
@SessionScope
public class GameController {
	
	@Autowired
	Position position;
	
	
//	@GetMapping("/")
//	public String saludo(Model model) {
//		model.addAttribute("mensaje", "hola");
//		model.addAttribute("posicion",position);
//		return "game";
//	}
	

	@RequestMapping(value="/game",method=RequestMethod.GET)
	public String editar( Model model) {
		model.addAttribute("mensaje", "hola");
		model.addAttribute("posicion",position);
		return "game";
	}
	
	// PathVariable inyecta el valor del parametro de la ruta
	@RequestMapping(value="/game/{id}",method=RequestMethod.GET)
	public String editar(@PathVariable(value="id") int id, Model model) {
		if(id>=0) {
			position.avanzar();
		}
		model.addAttribute("mensaje", "hola");
		model.addAttribute("posicion",position);
		return "game";
	}
	
}

