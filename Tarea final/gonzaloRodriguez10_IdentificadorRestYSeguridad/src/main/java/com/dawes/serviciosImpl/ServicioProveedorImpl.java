package com.dawes.serviciosImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ProveedorVO;
import com.dawes.repositorio.ProveedorRepository;
import com.dawes.servicios.ServicioProveedor;

@Service
public class ServicioProveedorImpl implements ServicioProveedor {
	
	@Autowired
	private ProveedorRepository pr;

	@Override
	public ProveedorVO findProveedorByNif(String nif) {
		return pr.findProveedorByNif(nif);
	}

	@Override
	public <S extends ProveedorVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public Optional<ProveedorVO> findById(Integer id) {
		return pr.findById(id);
	}

	@Override
	public Iterable<ProveedorVO> findAll() {
		return pr.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		pr.deleteById(id);
	}

	@Override
	public void delete(ProveedorVO entity) {
		pr.delete(entity);
	}
	
	

}
