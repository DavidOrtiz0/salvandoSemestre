package com.example.proyecto.controladores;


import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.modelo.Cliente;
import com.example.proyecto.modelo.Viaje;
import com.example.proyecto.modelo.reserva;
import com.example.proyecto.repositorio.RepositorioCliente;
import com.example.proyecto.repositorio.RepositorioReserva;
import com.example.proyecto.repositorio.RepositorioViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ver/cliente/")
@CrossOrigin(origins={"http://localhost:4200/"})
public class ControladorCliente {
	
	@Autowired
	private RepositorioCliente repositorioCliente;
	@Autowired 
	private RepositorioReserva repositorio_R;
	@Autowired 
	private RepositorioViaje repositorio_V;
	
		/*CASO DE USO 1: REALIZAR-RESERVA-USUARIO*/
	
	@PostMapping("/BuscarDestino")
	public List<Viaje>BuscarViaje(@RequestBody String destino){
		return this.repositorio_V.findByDestino(destino);
	} //listo

	@PostMapping("/GuardarInfoCliente")
	public Cliente GuardarCliente(@RequestBody Cliente cliente){
		repositorioCliente.save(cliente);
		Integer cedula = cliente.getCedula();
		System.out.print("marcador");
		return this.repositorioCliente.findById(cedula).get();
	} //listo
	
	@PostMapping("GuardarReserva")
	public List<Object> GuardarReserva(@RequestBody Object datosReserva){
		Object[] lista = (Object[]) datosReserva;
		
		Cliente cl = (Cliente) lista[0];
		Viaje v = (Viaje) lista[1];
		System.out.print(cl.getNombre() + v.getDestino());
		/*
		Cliente cliente;
		Viaje viaje;
		try {
			cliente = this.repositorioCliente.findById(333).get();
			viaje = this.repositorio_V.findById(1).get();
		}catch(Exception error){return null;}
		
		LocalDate fecha_reserva = LocalDate.now();
		
		reserva reserva = new reserva(cliente, viaje, 1, false, fecha_reserva);
		
		this.repositorio_R.save(reserva);*/
		return repositorio_R.MostrarReserva(1);
	}
	
	@GetMapping("/MostrarReserva")
	public List<Object> Mostrar_la_Reserva(Integer cedula){
		return this.repositorio_R.MostrarReserva(cedula);
	}
	
	/*FIN CASO DE USO 1*/
	
	/*CASO DE USO #2*/
	
	@GetMapping("/ConsultarReserva")
	public List<Object>Consultar(){
		return this.repositorio_R.ConsultarReserva(456789123);
	} //listo
	
	/*FIN CASO DE USO #2*/
	
	/*CASO DE USO #3*/
	
	@GetMapping("/cancelar")
	public String Cancelar_Reserva() {
		try {
		repositorio_R.EliminarReserva(17);
		repositorioCliente.EliminarCliente(333);
		return "Reserva cancelada";
		}catch(Exception error) {
			String e = error.toString(); 
			return e;
		}
	}
	
	/* FIN CASO DE USO 3*/
}

