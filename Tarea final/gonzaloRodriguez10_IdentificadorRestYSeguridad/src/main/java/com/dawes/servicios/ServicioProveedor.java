package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.ProveedorVO;

public interface ServicioProveedor {

	ProveedorVO findProveedorByNif(String nif);

	<S extends ProveedorVO> S save(S entity);

	Optional<ProveedorVO> findById(Integer id);

	Iterable<ProveedorVO> findAll();

	void deleteById(Integer id);

	void delete(ProveedorVO entity);

}