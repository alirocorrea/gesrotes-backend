package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface CicloRepository extends JpaRepository<Ciclo, Long>{
    
    public List<Ciclo> findByAsignatura(Asignatura asignatura);

}