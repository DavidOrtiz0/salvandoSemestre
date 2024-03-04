package com.example.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "bus")
public class Bus {

	@Id
	@Column(name = "matricula")
	private String matricula;
	
	@Column (name = "numero_de_puestos")
	private int numero_de_puestos;

	public Bus() {
		
	}

	public Bus(String matricula, int numero_de_puestos) {
		this.matricula = matricula;
		this.numero_de_puestos = numero_de_puestos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumero_de_puestos() {
		return numero_de_puestos;
	}

	public void setNumero_de_puestos(int numero_de_puestos) {
		this.numero_de_puestos = numero_de_puestos;
	}
	
	
	
}
