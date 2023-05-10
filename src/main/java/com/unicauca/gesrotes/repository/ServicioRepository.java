package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.domain.Escenario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    List<Servicio> findByEscenario (Escenario escenario);
}