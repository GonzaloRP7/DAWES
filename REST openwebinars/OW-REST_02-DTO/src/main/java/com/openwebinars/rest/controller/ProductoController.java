package com.openwebinars.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.rest.dto.CreateProductoDTO;
import com.openwebinars.rest.dto.ProductoDTO;
import com.openwebinars.rest.dto.converter.ProductoDTOConverter;
import com.openwebinars.rest.modelo.Producto;
import com.openwebinars.rest.modelo.ProductoRepositorio;
import com.openwebinars.rest.servicio.ProductoServico;


@RestController
public class ProductoController {

	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	ProductoDTOConverter productoDTOConverter;
	@Autowired
	ProductoServico ps;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o más
	 */
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();

		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			//Codigo de OpenWebinars
//			List<ProductoDTO> dtoList =
//					result.stream()
//						.map(productoDTOConverter::convertToDto)
//						.collect(Collectors.toList());
			
			//Mi codigo
			List<ProductoDTO> dtoList = new ArrayList<>();
			result.forEach(x->{
				dtoList.add(productoDTOConverter.convertToDto(x));
			});
			
			return ResponseEntity.ok(dtoList);
		}

	}

	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		
		ProductoDTO producto = productoDTOConverter 
				.convertToDto(ps.crearProducto(productoDTOConverter.convertToProducto(nuevo)));  
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	}

}
