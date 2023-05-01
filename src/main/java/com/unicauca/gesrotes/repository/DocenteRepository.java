package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{
    
    public List<Docente> findByAsignaturas(Asignatura asignatura);

}