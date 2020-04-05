package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="proveedores")
public class ProveedorVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproveedor;
	private String nombre;
	private String apellidos;
	@Column(unique=true)
	private String nif;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	public ProveedorVO(int idproveedor, String nombre, String apellidos, String nif, LocalDate fecha) {
		super();
		this.idproveedor = idproveedor;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha = fecha;
	}

	public ProveedorVO(String nombre, String apellidos, String nif, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.fecha = fecha;
	}

	public ProveedorVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idproveedor;
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProveedorVO other = (ProveedorVO) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idproveedor != other.idproveedor)
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProveedorVO [idproveedor=" + idproveedor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nif="
				+ nif + ", fecha=" + fecha + "]";
	}	
	
	
	
}
