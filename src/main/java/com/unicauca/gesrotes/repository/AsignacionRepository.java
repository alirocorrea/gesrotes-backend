package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE a FROM Ciclos AS c INNER JOIN Asignaciones AS a ON c.id_Ciclos = a.fk_id_Ciclos INNER JOIN Grupos AS g ON g.id_Grupos = a.fk_id_Grupos WHERE g.id_Grupos = ?1 AND c.id_Ciclos = ?2 ")
    int eliminarAsignacionesPorIdGrupoIdCiclo(Long id_grupo, Long id_ciclo);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE a FROM Ciclos AS c INNER JOIN Asignaciones AS a ON c.id_Ciclos = a.fk_id_Ciclos INNER JOIN Grupos AS g ON g.id_Grupos = a.fk_id_Grupos INNER JOIN HorariosModulos AS hm ON a.fk_id_HorariosModulos = hm.id_HorariosModulos WHERE g.id_Grupos = ?1 AND c.id_Ciclos = ?2 AND hm.id_HorariosModulos = ?3 ")
    int eliminarAsignacionesPorIdGrupoIdCicloIdHorario(Long id_grupo, Long id_ciclo, Long id_Horario);

    @Query("SELECT a FROM Asignacion a " +
            "JOIN FETCH a.ciclo ci " +
            "JOIN FETCH a.grupo gr " +
            "JOIN FETCH a.horarioModulo hm " +
            "JOIN FETCH hm.modulo mo " +
            "JOIN FETCH mo.docente do " +
            "JOIN FETCH do.persona pe " +
            "WHERE ci.asignatura.id = ?1 " +
            "AND gr.asignatura.id = ?1 ")
    List<Asignacion> getAsignacionesByIdAsignatura(final Long idAsignatura);


    @Query("SELECT a FROM Asignacion a " +
            "JOIN FETCH a.ciclo ci " +
            "JOIN FETCH a.grupo gr " +
            "JOIN FETCH a.horarioModulo hm " +
            "JOIN FETCH hm.modulo mo " +
            "JOIN FETCH mo.docente do " +
            "JOIN FETCH do.persona pe " +
            "WHERE a.id = ?1")
    Asignacion getAsignacion(final Long idAsignacion);
}
