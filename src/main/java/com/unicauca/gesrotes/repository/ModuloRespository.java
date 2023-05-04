package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuloRespository extends JpaRepository<Modulo, Long> {


}
