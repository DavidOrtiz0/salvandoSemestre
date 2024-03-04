package com.example.proyecto.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "cliente")
public class Cliente {
	@Id
	@Column(name = "cedula")
	private Integer cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name ="apellido")
	private String apellido;
	
	@Column(name = "telefono")
	private long telefono;
	
	@Column (name = "fecha_nacimiento")
	private LocalDate fecha_nacimiento;
	
	
	
	public Cliente() {
		
	}

	public Cliente(Integer cedula, String nombre, String apellido, long telefono, LocalDate fecha_nacimiento) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fecha_nacimiento = fecha_nacimiento;
		
	}

	public Integer getCedula() {
		return cedula;
	}

	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	
	
	

	

}
