package com.example.proyecto.repositorio;

import org.springframework.stereotype.Repository;
import com.example.proyecto.modelo.Cliente;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
@Transactional
public interface RepositorioCliente extends JpaRepository< Cliente , Integer >{
	@Modifying
	@Query(value="delete from proyecto.cliente where cliente.cedula = :numero_cedula ", nativeQuery = true)
	public void EliminarCliente(@Param("numero_cedula") Integer numero_cedula);
}

