package com.dawes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ProveedorVO;

@Repository
public interface ProveedorRepository extends CrudRepository<ProveedorVO, Integer> {
	
	ProveedorVO findProveedorByNif(String nif);

}
