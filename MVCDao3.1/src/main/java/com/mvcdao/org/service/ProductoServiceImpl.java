package com.mvcdao.org.service;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcdao.org.dao.IProductoDao;
import com.mvcdao.org.models.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	@Autowired
	private IProductoDao productoDao;

	@Override
	public void save(com.mvcdao.org.models.Producto producto) {
		productoDao.save(producto);
	}

	@Override
	@Transactional(readOnly=true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}
}
