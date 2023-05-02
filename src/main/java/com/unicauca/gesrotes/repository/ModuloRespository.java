package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuloRespository extends JpaRepository<Modulo, Long> {

    @Query(nativeQuery = true, value = "SELECT DISTINCT m.* " +
            "FROM asignaturas AS a INNER JOIN asignaturadocentes AS ad ON a.id_asignaturas = ad.asignaturas_id_asignaturas  " +
            "INNER JOIN docentes AS d ON ad.docentes_id_docente = d.id_docente INNER JOIN modulos AS m ON d.id_docente = m.fk_id_docentes_mod " +
            "LEFT JOIN horariosmodulos AS h ON m.id_modulos = h.fk_id_modulos " +
            "WHERE d.id_docente = ?1 AND a.id_asignaturas = ?2 AND h.fk_id_modulos IS NULL ")
    List<Modulo> listaModulosSinHorarioAsignado(Long id_docente, Long id_Asignatura);
}
