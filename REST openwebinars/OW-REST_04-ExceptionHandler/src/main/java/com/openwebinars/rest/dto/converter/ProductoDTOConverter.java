package com.openwebinars.rest.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.openwebinars.rest.dto.CreateProductoDTO;
import com.openwebinars.rest.dto.ProductoDTO;
import com.openwebinars.rest.modelo.Producto;

@Component
public class ProductoDTOConverter {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductoDTO convertToDto(Producto producto) {
		return modelMapper.map(producto, ProductoDTO.class);
	}
	
	public Producto convertToProducto(CreateProductoDTO producto) {
	     return modelMapper.map(producto, Producto.class);
	 }

}
