package com.openwebinars.rest.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.services.UserEntityService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserEntityService ues;
	
	@PostMapping("/")
	public ResponseEntity<UserEntity> nuevoUsuario(@RequestBody UserEntity newUser){
		
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(ues.nuevoUsuario(newUser));
		}catch(DataIntegrityViolationException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}
	

}
