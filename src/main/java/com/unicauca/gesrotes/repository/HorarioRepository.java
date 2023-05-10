package com.unicauca.gesrotes.repository;

import com.unicauca.gesrotes.domain.HorarioModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<HorarioModulo, Long> {

    @Query("SELECT h FROM HorarioModulo h WHERE h.modulo.id = ?1")
    List<HorarioModulo> getHorariosByIdModulo(final Long idModulo);


}
