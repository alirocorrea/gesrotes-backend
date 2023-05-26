package com.unicauca.gesrotes.service;

import java.util.List;

import com.unicauca.gesrotes.dto.DocumentoDTO;

public interface DocumentoEscenarioService {
    List<DocumentoDTO> getDocumentosByEscenarioId(Long idEscenario);
}
