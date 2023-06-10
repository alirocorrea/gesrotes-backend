package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long>{
    
    List<Grupo> findByAsignatura(Asignatura asignatura);

    @Query("SELECT g FROM Grupo g WHERE g.asignatura.id = ?1")
    List<Grupo> getByIdAsignatura(final Long idAsignatura);

    void deleteByid(Long id_grupo);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE Grupos " +
            "FROM Grupos " +
            "INNER JOIN Asignaturas ON Grupos.fk_id_AsignaturasGru = Asignaturas.id_Asignaturas " +
            "WHERE Asignaturas.id_Asignaturas = ?1")
    int eliminarGruposPorIdAsignatura(Long idAsignatura);

}