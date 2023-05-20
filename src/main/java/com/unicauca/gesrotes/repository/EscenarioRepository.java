package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Escenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscenarioRepository extends JpaRepository<Escenario, Long> {
}
