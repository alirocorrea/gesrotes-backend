package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HorarioRespository extends JpaRepository<Horario, Long> {
    @Query(nativeQuery = true, value = "select * from horario")
    List<Horario> listarHorarioNoOcupados(Long idDocente, Long idAsignatura);
}
