package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.domain.Servicio;

@Repository
@Service
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    public List<Servicio> findByEscenario (Escenario escenario);
}