package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Modulo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{
    
    List<Modulo> findByNombre(String nombre);

    @Query(nativeQuery = true, value = "SELECT DISTINCT m.* FROM Asignaturas AS a INNER JOIN AsignaturaDocentes AS ad ON a.id_Asignaturas = ad.Asignaturas_id_Asignaturas INNER JOIN Docentes AS d ON ad.Docentes_id_docente = d.id_docente INNER JOIN Modulos AS m ON d.id_docente = m.fk_id_DocentesMod LEFT JOIN HorariosModulos AS h ON m.id_Modulos = h.fk_id_Modulos WHERE d.id_docente = ?1 AND a.id_Asignaturas = ?2 AND h.fk_id_Modulos IS NULL ")
    List<Modulo> listaModulosSinHorarioAsignado(Long id_docente, Long id_Asignatura);

    @Query("SELECT m FROM Modulo m JOIN FETCH m.docente doc WHERE doc.id = ?1 ")
    List<Modulo> findByDocenteId(Long id_docente);

}
