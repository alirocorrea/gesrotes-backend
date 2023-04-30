package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.HorarioModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface HorarioRepository extends JpaRepository<HorarioModulo, Long> {

}
