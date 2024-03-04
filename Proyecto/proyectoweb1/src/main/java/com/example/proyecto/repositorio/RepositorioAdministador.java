package com.example.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto.modelo.Administrador;

@Repository
public interface RepositorioAdministador extends JpaRepository< Administrador, String >{

}
