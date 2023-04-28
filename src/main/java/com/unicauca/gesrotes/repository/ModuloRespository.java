package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuloRespository extends JpaRepository<Modulo, Long> {

    @Query(nativeQuery = true, value = "select * modulos")
    List<Modulo> listaModulosSinHorarioAsignado(Long id_docente, Long id_Asignatura);
}
