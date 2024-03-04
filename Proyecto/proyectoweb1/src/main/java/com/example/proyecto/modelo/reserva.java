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

	
	
	
	

}
