package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {

    String editarArchivo(Long id_archivo, MultipartFile file, ObjetoArchivoRequest objRequest);

    void eliminarArchivo(Long id_documnento) throws NotFoundException;
}
