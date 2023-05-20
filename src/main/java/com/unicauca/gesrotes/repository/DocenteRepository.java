package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Docente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>{
    
    public List<Docente> findByAsignaturas(Asignatura asignatura);
    
    @Query("SELECT d FROM Docente d JOIN d.asignaturas a WHERE a.id = :id_Asignatura")
    List<Docente> findByIdAsignatura(Long id_Asignatura);
}