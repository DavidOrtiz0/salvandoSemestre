package com.example.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto.modelo.Bus;

@Repository
public interface RepositorioBus extends JpaRepository<Bus, String> {

}
