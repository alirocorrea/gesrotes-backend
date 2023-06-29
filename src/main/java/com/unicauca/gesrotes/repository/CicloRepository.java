package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Ciclo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, Long>{

    public List<Ciclo> findByAsignatura(Asignatura asignatura);

    @Query("SELECT c FROM Ciclo c WHERE c.asignatura.id = ?1")
    List<Ciclo> getByAsignatura(final Long asignatura);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE Ciclos " +
            "FROM Ciclos " +
            "INNER JOIN Asignaturas ON Ciclos.fk_id_AsignaturasCic = Asignaturas.id_Asignaturas " +
            "WHERE Asignaturas.id_Asignaturas = ?1 ")
    int eliminarCiclosPorIdAsignatura(Long idAsignatura);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE GruposEstudiantes " +
            "FROM GruposEstudiantes " +
            "INNER JOIN Grupos ON GruposEstudiantes.Grupos_id_Grupos = Grupos.id_Grupos " +
            "INNER JOIN Asignaturas ON Grupos.fk_id_AsignaturasGru = Asignaturas.id_Asignaturas " +
            "WHERE Asignaturas.id_Asignaturas = ?1 ")
    int eliminarGruposEstudiantesPorIdAsignatura(Long idAsignatura);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM Ciclos c WHERE c.id_Ciclos = ?1 ")
    public void deleteByCicloId(Long l);

}