package com.example.proyecto.controladores;


import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.modelo.Cliente;
import com.example.proyecto.modelo.Objres;
import com.example.proyecto.modelo.Viaje;
import com.example.proyecto.modelo.reserva;
import com.example.proyecto.repositorio.RepositorioCliente;
import com.example.proyecto.repositorio.RepositorioReserva;
import com.example.proyecto.repositorio.RepositorioViaje;

import org.apache.el.stream.Optional;
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
	}

	@PostMapping("/GuardarInfoCliente")
	public Cliente GuardarCliente(@RequestBody Cliente cliente){
		Integer cedula = cliente.getCedula();
		repositorioCliente.save(cliente);
		return this.repositorioCliente.findById(cedula).get();
	} 
	
	@PostMapping("GuardarReserva")
	public List<Object> GuardarReserva(@RequestBody Objres datosReserva){
		try {
		LocalDate fecha_reserva = LocalDate.now();
		
		reserva reserva = new reserva();
		reserva.setCc_cliente(datosReserva.getCliente());
			try {
			reserva.setId_viaje(datosReserva.getViaje());
			}catch(Exception error) {
				System.out.println("error al setear reserva: " + error);
			}
		reserva.setPuesto_asignado(1);
		reserva.setEstado_de_pago(false);
		reserva.setFecha_de_reserva(fecha_reserva);
		
		this.repositorio_R.save(reserva);
		
		System.out.println("marcador guardar reserva");
		return repositorio_R.MostrarReserva(datosReserva.getCliente().getCedula());
		
		}catch(Exception error) {
			System.out.print("error al ejecutar funcion: " + error);
			return null;
		}
		
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

