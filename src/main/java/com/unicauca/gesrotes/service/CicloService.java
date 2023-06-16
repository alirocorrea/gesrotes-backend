package com.unicauca.gesrotes.service;

import java.util.UUID;

import com.unicauca.gesrotes.dto.UpdateCicloDTO;
import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponse;
import com.unicauca.gesrotes.dto.response.CicloResponseList;

public interface CicloService {
    CicloResponseList listarCiclosAsignatura(long id_asignatura);
    CicloResponseList registrarCiclo(CicloRequest cicloRequest, long id_asignatura);
    CicloResponse editarCiclo(CicloRequest cicloRequest, Long idCiclo);
    //CicloResponse editarCiclo(Long l, UpdateCicloDTO updateCicloDTO);
}