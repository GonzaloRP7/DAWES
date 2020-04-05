package com.dawes.WS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dawes.dto.ProveedorDTO;
import com.dawes.dto.converter.ProveedorDTOConverter;
import com.dawes.modelo.ProveedorVO;
import com.dawes.servicios.ServicioProveedor;

@RestController
@RequestMapping("/proveedores")
public class ProveedorWS {
	
	@Autowired
	private ServicioProveedor sp;
	@Autowired
	private ProveedorDTOConverter pc;
	
	@GetMapping("/ver")
	public List<ProveedorDTO> listarProveedores(){
		List<ProveedorDTO> lista = new ArrayList<>();
		
		List<ProveedorVO> proveedores = (List<ProveedorVO>) sp.findAll();

		proveedores.forEach(x->{
			lista.add(pc.convertToDto(x));
		});
		
		return lista;
	}
	
	@GetMapping("/buscar/{nif}")
	public ProveedorDTO buscarProveedor(@PathVariable String nif){
		
		return pc.convertToDto(sp.findProveedorByNif(nif));
	}
	
	@PostMapping("/crear")
	public ProveedorDTO nuevoProducto(@RequestBody ProveedorVO nuevo) {

		sp.save(nuevo);
		return pc.convertToDto(nuevo);
	}
	
	@DeleteMapping("/eliminar/{nif}")
	public ResponseEntity<?> borrarProducto(@PathVariable String nif) {

		sp.deleteById(sp.findProveedorByNif(nif).getIdproveedor());
		
		return ResponseEntity.noContent().build();
	}

}
