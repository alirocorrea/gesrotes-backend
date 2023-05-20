package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.AsignacionDTO;
import com.unicauca.gesrotes.dto.request.CreateRoteRequest;

public interface RoteService {
    AsignacionDTO createRote(CreateRoteRequest request);
}
