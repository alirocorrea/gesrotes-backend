package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;

public interface ModuloService {
    ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) ;
}