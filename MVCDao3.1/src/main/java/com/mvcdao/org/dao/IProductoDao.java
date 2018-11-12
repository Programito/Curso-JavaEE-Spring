package com.mvcdao.org.dao;


import org.springframework.data.repository.CrudRepository;

import com.mvcdao.org.models.Producto;


public interface IProductoDao extends CrudRepository<Producto, Long>{

}