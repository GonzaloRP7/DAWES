package com.dawes.dto.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dawes.dto.ProveedorDTO;
import com.dawes.modelo.ProveedorVO;

@Component
public class ProveedorDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProveedorDTO convertToDto(ProveedorVO proveedor) {
		return modelMapper.map(proveedor, ProveedorDTO.class);
	}
}
