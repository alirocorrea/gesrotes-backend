package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.GrupoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface GrupoEstudianteRepository extends JpaRepository<GrupoEstudiante, Long> {

    @Query("SELECT ge FROM GrupoEstudiante ge JOIN FETCH ge.grupo gr JOIN FETCH ge.estudiante es")
    List<GrupoEstudiante> getAll();

    @Modifying
    @Transactional
    void deleteBygrupoId(Long id_grupo);

    @Modifying
    @Transactional
    void deleteByestudianteIdAndgrupoId(Long id_estudiante, Long id_grupo);
}
