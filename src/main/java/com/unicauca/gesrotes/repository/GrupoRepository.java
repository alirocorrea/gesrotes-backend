package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    
    List<Grupo> findByAsignatura(Asignatura asignatura);

    @Query("SELECT g FROM Grupo g WHERE g.asignatura.id = ?1")
    List<Grupo> getByIdAsignatura(final Long idAsignatura);

    void deleteByid(Long id_grupo);
    

}