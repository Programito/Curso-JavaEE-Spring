package com.mvcdao.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcdao.org.models.Producto;
import com.mvcdao.org.service.IProductoService;
import com.mvcdao.org.service.ProductoServiceImpl;

@Controller
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	@RequestMapping(value = "/producto", method = RequestMethod.GET)
	public String vacio(Model model) {
		Producto producto= new Producto();
		producto.setNombre("hola");
		producto.setPrecio(30.2);
		productoService.saveProducto(producto);
		return "index";
	}
}
