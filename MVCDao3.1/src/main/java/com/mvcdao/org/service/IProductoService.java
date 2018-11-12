package com.mvcdao.org.service;

import java.util.List;

import com.mvcdao.org.models.Producto;

public interface IProductoService {
	public void save(Producto producto);
	public Producto findById(Long id);
	public List<Producto>  findAll();
}
