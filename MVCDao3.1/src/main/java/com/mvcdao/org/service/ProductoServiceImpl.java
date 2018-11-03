package com.mvcdao.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcdao.org.dao.IProductoDao;

@Service
public class ProductoServiceImpl implements IProductoService {
	@Autowired
	private IProductoDao productoDao;

	@Override
	public void save(com.mvcdao.org.models.Producto producto) {
		productoDao.save(producto);
	}
}
