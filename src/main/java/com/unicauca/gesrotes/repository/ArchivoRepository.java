package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoRepository extends JpaRepository<Archivo, Long> {

}
