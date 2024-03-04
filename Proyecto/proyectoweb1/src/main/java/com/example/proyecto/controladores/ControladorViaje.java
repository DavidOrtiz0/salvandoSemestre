package com.example.proyecto.controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto.modelo.Bus;
import com.example.proyecto.modelo.Viaje;
import com.example.proyecto.repositorio.RepositorioBus;
import com.example.proyecto.repositorio.RepositorioViaje;


@RestController
@RequestMapping("/ver/viaje/")
public class ControladorViaje {

	@Autowired private RepositorioBus repositorioBus;
	@Autowired private RepositorioViaje repositorioViaje;
	
		@GetMapping("/GuardarViaje")
		public Viaje GuardarViaje() {
			
			String id_bus = "BUS001";
			Bus bus = repositorioBus.findById(id_bus).get();
			
			LocalDate fecha_viaje = LocalDate.of(2024,10,12);
			
			LocalTime hora_viaje = LocalTime.of(10,20,00);
			
			long precio = 50000;
			
			boolean estado = false;
			
			String destino = "medellin";
			Viaje viaje = new Viaje(bus, destino, fecha_viaje, hora_viaje, precio, estado);
			
			boolean[] arreglo;
			arreglo = viaje.getDisponible();
			System.out.println(arreglo.length);
			viaje.setDisponible(10);
			arreglo = viaje.getDisponible();
			System.out.println(arreglo.length);
			return viaje;
		}
		
		@GetMapping("/EliminarViaje")
		public void EliminarViaje() {
			repositorioViaje.deleteAllById(null);
		}
	}
	

