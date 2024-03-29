package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Long> {

}
