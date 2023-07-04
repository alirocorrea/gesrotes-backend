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
        value ="select hm.* from HorariosModulos hm " + //
            "inner join Modulos m on hm.fk_id_Modulos = m.id_Modulos  " + //
            "inner join Docentes d on m.fk_id_DocentesMod = d.id_docente  " + //
            "inner join AsignaturaDocentes ad on ad.Docentes_id_docente = d.id_docente  " + //
            "where  " + //
            "d.id_docente = :id_docente " + //
            "and ad.Asignaturas_id_Asignaturas = :id_asignatura",
        nativeQuery = true
        )
    List<HorarioModulo> findAllByDocenteAsignatura( @Param("id_docente") Long id_docente, @Param("id_asignatura") Long id_asignatura);

}
