package com.example.proyecto.modelo;

public class Objres {
	
	private Cliente cliente;
	
	private Viaje viaje;
	
	public Objres(Cliente cliente, Viaje viaje) {
		this.cliente = cliente;
		this.viaje = viaje;
	}
	
	public Objres() {
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Viaje getViaje() {
		return viaje;
	}
	
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

}
