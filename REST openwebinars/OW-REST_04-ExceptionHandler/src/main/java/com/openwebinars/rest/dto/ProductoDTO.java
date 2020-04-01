package com.openwebinars.rest.dto;

public class ProductoDTO {
	
	private String nombre;
	private float precio;
	private String CategoriaNombre;
	
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
	public String getCategoriaNombre() {
		return CategoriaNombre;
	}
	public void setCategoriaNombre(String categoriaNombre) {
		CategoriaNombre = categoriaNombre;
	}
	
	

}
