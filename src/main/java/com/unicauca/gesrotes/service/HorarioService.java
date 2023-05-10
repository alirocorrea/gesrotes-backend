package com.unicauca.gesrotes.service;


import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;

import java.util.List;

import org.webjars.NotFoundException;

public interface HorarioService {

    void eliminarHorarioporId(long id_horariosmodulos) throws NotFoundException;

    CreateHorarioResponse createHorario(Long idModulo, CreateHorarioRequest request);

    List<HorarioModulo> getHoariosModulos();
    
}
