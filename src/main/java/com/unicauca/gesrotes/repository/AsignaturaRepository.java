package com.unicauca.gesrotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.gesrotes.domain.Asignatura;

@Repository
public interface AsignaturaRepository  extends JpaRepository<Asignatura, Long>{

    List<Asignatura> findAllByProgramaId(Long id_programa);

}
