package com.example.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.example.proyecto.repositorio.RepositorioAdministador;
import com.example.proyecto.repositorio.RepositorioReserva;
import com.example.proyecto.modelo.*;
@RestController
@RequestMapping("/adm")
@CrossOrigin(origins={"http://localhost:4200/"})

public class ControladorAdministrador {
	
	@Autowired
	private RepositorioAdministador repositorioAdm;
	@Autowired
	private RepositorioReserva repositorioReserva;
	
	@GetMapping("/mostraradm")
	public List<Administrador> verAdm(){
		return repositorioAdm.findAll();
	}
	
	@PostMapping("/inicioSesion")
	public boolean iniciarSesion(@RequestBody Administrador admin) {
		AtomicBoolean permiso = new AtomicBoolean(false);
		List<Administrador> verificar = repositorioAdm.findAll();
		verificar.forEach(elemento ->{
			if(elemento.getUsuario().equals( admin.getUsuario() ) && elemento.getContrasena().equals( admin.getContrasena() ) ) 
			{
				permiso.set(true);
			}
		});
		System.out.print(admin.getUsuario() + " " + admin.getContrasena());
		return permiso.get();
	}
	
	/*@GetMapping("/ListarPorDia")
	public List<reserva>listarReservaDia() {
		LocalDate fecha_de_reserva = LocalDate.now();
		return repositorioReserva.ListarPorDia(fecha_de_reserva);
		}*/
	
	
	@GetMapping("/BuscarPorBus")
	public List<Object> MostrarPorBus(){
		String bus= "BUS001";
		return repositorioReserva.Mostrar_Por_Bus(bus);
	}
	

}
