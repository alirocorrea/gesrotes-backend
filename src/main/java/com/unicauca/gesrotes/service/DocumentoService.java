package com.unicauca.gesrotes.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.gesrotes.dto.request.DocumentoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;

public interface DocumentoService {

    DocumentoUUIDResponse guardarDocumento(MultipartFile file, DocumentoRequest documentoRequest, Long idEscenario) throws IOException;
    
}
