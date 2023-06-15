package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponseList;

public interface CicloService {
    CicloResponseList listarCiclosAsignatura(long id_asignatura);
    CicloResponseList registrarCiclo(CicloRequest cicloRequest, long id_asignatura);

    Boolean eliminarCicloDTO(final Long id_ciclos);
}