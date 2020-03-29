package com.openwebinars.rest.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openwebinars.rest.modelo.Producto;
import com.openwebinars.rest.modelo.ProductoRepositorio;
import com.openwebinars.rest.servicio.ProductoServico;

@Service
public class ProductoServicioImpl implements ProductoServico {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	 
	public Producto crearProducto(Producto p) {
	    return productoRepositorio.save(p);
	}
}
