package com.example.proyecto.modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "viaje")
public class Viaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_viaje;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_bus", referencedColumnName="matricula")
	private Bus id_bus;
	
	@Column(name = "destino")
	private String destino;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column( name ="hora" )
	private LocalTime hora;
	
	@Column (name = "precio")
	private long precio;
	
	@Column (name = "disponibilidad")
	private boolean disponibilidad;

	private boolean puestos[];

	public Viaje() {
		
	}


	public Viaje(Bus id_bus, String destino, LocalDate fecha, LocalTime hora, long precio, boolean disponibilidad) {
		this.id_bus = id_bus;
		this.destino = destino;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		//this.puestos = new boolean[1];
		
	}

	

	public Integer getId_viaje() {
		return id_viaje;
	}


	public void setId_viaje(Integer id_viaje) {
		this.id_viaje = id_viaje;
	}


	public boolean[] getPuestos() {
		return puestos;
	}


	public void setPuestos(boolean[] puestos) {
		this.puestos = puestos;
	}


	public Bus getId_bus() {
		return id_bus;
	}


	public void setId_bus(Bus id_bus) {
		this.id_bus = id_bus;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalTime getHora() {
		return hora;
	}


	public void setHora(LocalTime hora) {
		this.hora = hora;
	}


	public long getPrecio() {
		return precio;
	}


	public void setPrecio(long precio) {
		this.precio = precio;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	

	public boolean[] getDisponible() {return this.puestos;}
	
	public void setDisponible(int NumeroPuestos) {
		boolean[] puestosNew = new boolean [NumeroPuestos];
		this.puestos = puestosNew;
	}
	
	public int AsignarPuesto(boolean[] puestos){
		int PuestoAsignado = 1;
		for(boolean puesto: puestos){
			if(puesto == true){
				return PuestoAsignado;
			}else {PuestoAsignado++;}
		 }
			return PuestoAsignado-1;
		}
	
	public void EliminarPuesto(boolean[] puestos, int puestoAsignado) {
		puestos[puestoAsignado-1] = true;
		}
	
	public boolean VerificarEstado(boolean[] puestos){
		for(boolean puesto: puestos){
			if(puesto == true){return true;}
			}
		return false;
	}

}