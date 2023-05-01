package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Modulo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{
    
    List<Modulo> findByNombre(String nombre);

}