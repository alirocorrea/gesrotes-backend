package com.unicauca.gesrotes.service;


import com.unicauca.gesrotes.dto.HorarioModuloDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;

import java.util.List;

import org.webjars.NotFoundException;

public interface HorarioService {

    void eliminarHorarioporId(long id_horariosmodulos) throws NotFoundException;

    CreateHorarioResponse createHorario(Long idModulo, CreateHorarioRequest request);

    List<HorarioModuloDTO> getHorariosModulos(Long id_docente, Long id_asignatura);
    
}
