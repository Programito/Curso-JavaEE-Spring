package com.mvcdao.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcdao.org.dao.IProductoDao;
import com.mvcdao.org.models.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	public void saveProducto(Producto product) {
		productoDao.save(product);
	}

}
