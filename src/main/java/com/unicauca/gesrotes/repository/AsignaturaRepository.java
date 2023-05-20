package com.unicauca.gesrotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.gesrotes.domain.Asignatura;

@Repository
public interface AsignaturaRepository  extends JpaRepository<Asignatura, Long>{
    
}
