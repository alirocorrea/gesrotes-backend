package com.unicauca.gesrotes.service;

import java.util.List;

import com.unicauca.gesrotes.dto.AsignaturaDTO;
import com.unicauca.gesrotes.dto.HorariosModulosDTO;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;

public interface AsignaturaService {

    AsignaturaDTO getAsignaturas(Long id_programa);
    
}
