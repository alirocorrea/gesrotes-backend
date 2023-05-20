package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, Long>{

    public List<Ciclo> findByAsignatura(Asignatura asignatura);

    @Query("SELECT c FROM Ciclo c WHERE c.asignatura.id = ?1")
    List<Ciclo> getByAsignatura(final Long asignatura);
}