package com.openwebinars.rest.dto;

public class CreateProductoDTO {
	private String nombre;
	private float precio;
	private long categoriaId;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(long categoriaid) {
		this.categoriaId = categoriaid;
	}
	
	

}
