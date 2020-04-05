package com.dawes.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.dawes.dto.ProveedorDTO;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url_API_Back="http://localhost:8080/proveedores";
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("menuUsuario")
	public String menuUsuario(Model modelo) {
		ProveedorDTO[] proveedores= restTemplate.getForObject(url_API_Back+"/ver", ProveedorDTO[].class);
		modelo.addAttribute("listarProveedores", proveedores);
		return "menuUsuario";
	}
	
	@RequestMapping("menuAdmin")
	public String menuAdmin(Model modelo) {
		ProveedorDTO[] proveedores= restTemplate.getForObject(url_API_Back+"/ver", ProveedorDTO[].class);
		modelo.addAttribute("listarProveedores", proveedores);
		return "menuAdmin";
	}

}
