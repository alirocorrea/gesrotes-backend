package com.unicauca.gesrotes.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;

public interface DocumentoService {

    DocumentoUUIDResponse guardarDocumento(MultipartFile file, ObjetoArchivoRequest documentoRequest, Long idEscenario) throws IOException, ParseException;

    byte[] getDocumento(Long idArchivo);

    void eliminarArchivo(Long id_documnento);
}
