package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.DocumentoEscenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoEscenarioRepository extends JpaRepository<DocumentoEscenario, Long> {

}
