package com.unicauca.gesrotes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;

@Repository
@Service
public interface AsignaturaRepository  extends JpaRepository<Asignatura, Long>{
    
}
