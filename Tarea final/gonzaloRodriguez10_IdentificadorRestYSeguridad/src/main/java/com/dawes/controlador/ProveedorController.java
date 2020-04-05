package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.dawes.dto.ProveedorDTO;
import com.dawes.modelo.ProveedorVO;
import com.dawes.servicios.ServicioProveedor;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	ServicioProveedor sp;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url_API_Back="http://localhost:8080/proveedores";
	
	/*
	 * Buscar Todos
	 */
	@RequestMapping("/listarProveedores")
	public String listarProveedores(Model modelo) {
		ProveedorDTO[] proveedores= restTemplate.getForObject(url_API_Back+"/ver", ProveedorDTO[].class);
		modelo.addAttribute("listarProveedores", proveedores);
		return "/proveedores/listarProveedores";
	}
	
	@RequestMapping("/formBuscar")
	public String formBuscar(Model modelo) {
		modelo.addAttribute("proveedor", new ProveedorVO());
		return "/proveedores/formBuscar";
	}
	
	/*
	 * Buscar Uno
	 */
	@RequestMapping("/buscar")
	public String buscar(Model modelo, @RequestParam String nif) {
		ProveedorDTO proveedor= restTemplate.getForObject(url_API_Back+"/buscar/"+nif, ProveedorDTO.class);
		modelo.addAttribute("proveedor", proveedor);
		return "/proveedores/buscar";
	}
	
	/*
	 * Crear
	 */
	
	@RequestMapping("/formCrear")
	public String formCrear(Model modelo) {
		modelo.addAttribute("proveedor", new ProveedorVO());
		return "/proveedores/formCrear";
	}
	
	@RequestMapping("/crear")
	public String crear(Model modelo, @ModelAttribute ProveedorVO proveedor, @RequestParam String ruta) {
		ProveedorDTO proveedordto= restTemplate.postForObject(url_API_Back+"/crear", proveedor, ProveedorDTO.class);
		modelo.addAttribute("proveedor", proveedordto);
		modelo.addAttribute("ruta", ruta);
		return "/proveedores/crear";
	}

	/*
	 * Eliminar
	 */
	
	@RequestMapping("/eliminar")
	public String eliminar(Model modelo, @RequestParam String nif) {
		ProveedorDTO proveedor= restTemplate.getForObject(url_API_Back+"/buscar/"+nif, ProveedorDTO.class);
		modelo.addAttribute("proveedor", proveedor);
		restTemplate.delete(url_API_Back+"/eliminar/"+ nif);
		return "/proveedores/eliminar";
	}
	
	/*
	 * Actualizar
	 */
	
	@RequestMapping("/formActualizar")
	public String formActualizar(Model modelo, @RequestParam String nif, String ruta) {
		modelo.addAttribute("proveedor", sp.findProveedorByNif(nif));
		modelo.addAttribute("ruta", ruta);
		return "/proveedores/formActualizar";
	}

}
