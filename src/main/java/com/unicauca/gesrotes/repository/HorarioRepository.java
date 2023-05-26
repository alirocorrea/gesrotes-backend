package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.HorarioModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioModulo, Long> {

    @Query("SELECT h FROM HorarioModulo h WHERE h.modulo.id = ?1")
    List<HorarioModulo> getHorariosByIdModulo(final Long idModulo);

    @Query(
        value ="select * from Asignaturas asg inner join AsignaturaDocentes asdoc on asg.id_Asignaturas = asdoc.asignaturas_id_Asignaturas inner join Docentes doc on asdoc.docentes_id_docente = doc.id_docente inner join Modulos modu  on modu.fk_id_DocentesMod = doc.id_Docente  inner join HorariosModulos hm on hm.id_HorariosModulos = modu.id_modulos inner join Servicios ser  on hm.fk_id_ServiciosHM = ser.id_Servicios  inner join Escenarios esc on esc.id_Escenarios = hm.fk_id_EscenariosHM where doc.id_docente = :id_docente and asg.id_Asignaturas = :id_asignatura",
        nativeQuery = true
        )
    List<HorarioModulo> findAllByDocenteAsignatura( @Param("id_docente") Long id_docente, @Param("id_asignatura") Long id_asignatura);

}
