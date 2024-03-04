package com.example.proyecto.modelo;

import java.time.LocalDate;

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
@Table (name = "reserva")
public class reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_reserva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cc_cliente", referencedColumnName="cedula")
	private Cliente cc_cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_viaje", referencedColumnName="id_viaje")
	private Viaje id_viaje;
	
	
	
	@Column(name = "puesto_asignado")
	private int puesto_asignado;
	
	@Column(name ="estado_de_pago")
	private boolean estado_de_pago;
	
	@Column(name ="fecha_de_reserva")
	private LocalDate fecha_de_reserva;
	

	public reserva() {
	}


	public reserva(Cliente cc_cliente, Viaje id_viaje, int puesto_asignado, boolean estado_de_pago,
			LocalDate fecha_de_reserva) {
		super();
		this.cc_cliente = cc_cliente;
		this.id_viaje = id_viaje;
		this.puesto_asignado = puesto_asignado;
		this.estado_de_pago = estado_de_pago;
		this.fecha_de_reserva = fecha_de_reserva;
	}


	public Integer getId_reserva() {
		return id_reserva;
	}


	public void setId_reserva(Integer id_reserva) {
		this.id_reserva = id_reserva;
	}


	public Cliente getCc_cliente() {
		return cc_cliente;
	}


	public void setCc_cliente(Cliente cc_cliente) {
		this.cc_cliente = cc_cliente;
	}


	public Viaje getId_viaje() {
		return id_viaje;
	}


	public void setId_viaje(Viaje id_viaje) {
		this.id_viaje = id_viaje;
	}


	public int getPuesto_asignado() {
		return puesto_asignado;
	}


	public void setPuesto_asignado(int puesto_asignado) {
		this.puesto_asignado = puesto_asignado;
	}


	public boolean isEstado_de_pago() {
		return estado_de_pago;
	}


	public void setEstado_de_pago(boolean estado_de_pago) {
		this.estado_de_pago = estado_de_pago;
	}


	public LocalDate getFecha_de_reserva() {
		return fecha_de_reserva;
	}


	public void setFecha_de_reserva(LocalDate fecha_de_reserva) {
		this.fecha_de_reserva = fecha_de_reserva;
	}

	


}
