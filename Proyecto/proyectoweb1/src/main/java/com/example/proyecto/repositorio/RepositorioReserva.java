package com.example.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.proyecto.modelo.reserva;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RepositorioReserva extends JpaRepository < reserva, Integer > {

	 @Query(value = "select distinct reserva.puesto_asignado, viaje.precio, reserva.cc_cliente "
	 		+ "from proyecto.reserva "
	 		+ "join proyecto.viaje on viaje.id_viaje = reserva.id_viaje and cc_cliente = :cedula ;", nativeQuery=true)
	public List<Object> MostrarReserva(@Param("cedula")Integer cedula);
	
	@Query(value = "Select viaje.destino,viaje.hora, viaje.precio, viaje.fecha "
			+ "from proyecto.viaje "
			+ "join proyecto.reserva on viaje.id_viaje = reserva.id_viaje and reserva.cc_cliente = :cedula", nativeQuery = true)
	public List <Object> ConsultarReserva(@Param("cedula") Integer cedula);
	
	@Query(value = "select viaje.id_bus, reserva.id_reserva, cliente.nombre, cliente.apellido "
			+ "from proyecto.reserva "
			+ "join proyecto.viaje on reserva.id_viaje = viaje.id_viaje "
			+ "join proyecto.cliente on reserva.cc_cliente = cliente.cedula "
			+ "where viaje.id_bus = :bus_buscar ", nativeQuery = true)
	public List<Object> Mostrar_Por_Bus(@Param("bus_buscar")String bus);
	
	
	@Modifying
	@Query(value="delete from proyecto.reserva where reserva.id_reserva = :numero_reserva ", nativeQuery = true)
	public void EliminarReserva(@Param("numero_reserva") Integer numero_reserva);
	
	
	
}
	