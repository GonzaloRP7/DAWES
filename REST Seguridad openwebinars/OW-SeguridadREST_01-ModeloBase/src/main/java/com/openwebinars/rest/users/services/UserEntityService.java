package com.openwebinars.rest.users.services;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openwebinars.rest.services.base.BaseService;
import com.openwebinars.rest.users.model.UserEntity;
import com.openwebinars.rest.users.model.UserRole;
import com.openwebinars.rest.users.repos.UserEntityRepository;

@Service
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {
	
	@Autowired
	PasswordEncoder ps;

	public Optional<UserEntity> findByUsername(String username){
		return this.repositorio.findByUsername(username);
	}
	
	public UserEntity nuevoUsuario(UserEntity userEntity) {
		userEntity.setPassword(ps.encode(userEntity.getPassword()));
		userEntity.setRoles(Stream.of(UserRole.USER).collect(Collectors.toSet()));
		return save(userEntity);
	}
}
