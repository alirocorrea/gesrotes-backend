package com.unicauca.gesrotes.service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {

    String editarArchivo(Long id_archivo, MultipartFile file, String datosEditar);

    void eliminarArchivo(Long id_documnento) throws NotFoundException;
}
