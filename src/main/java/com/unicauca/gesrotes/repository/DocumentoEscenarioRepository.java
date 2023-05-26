package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.DocumentoEscenario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoEscenarioRepository extends JpaRepository<DocumentoEscenario, Long> {

    @Query(nativeQuery = true, value = "SELECT de.* FROM Archivo AS a INNER JOIN DocumentosEscenarios AS de ON a.id_Archivo = de.fk_id_Archivo WHERE a.id_Archivo = ?1")
    DocumentoEscenario buscarPorIdArchivo(Long id);

    @Query("SELECT d FROM DocumentoEscenario d WHERE d.escenario.id = ?1")
    List<DocumentoEscenario> findByEscenarioIdEscenarios(Long idEscenario);

}
