package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.ServicioFullResponse;


public interface ServicioService {
    ServicioFullResponse listarServiciosPorEscenario(long id);
}
