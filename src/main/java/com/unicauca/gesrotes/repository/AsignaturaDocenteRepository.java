package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.AsignaturaDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaDocenteRepository extends JpaRepository<AsignaturaDocente, Long> {

}
