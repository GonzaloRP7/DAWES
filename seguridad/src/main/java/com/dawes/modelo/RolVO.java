package com.dawes.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rolid;
	
	@Column(length = 30, unique = true)
	private String rolename;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UsuarioRolVO> usuarios;

	public Long getRolid() {
		return rolid;
	}

	public void setRolid(Long rolid) {
		this.rolid = rolid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public List<UsuarioRolVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioRolVO> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
