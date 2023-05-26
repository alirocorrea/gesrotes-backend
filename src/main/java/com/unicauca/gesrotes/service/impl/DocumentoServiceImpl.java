package com.unicauca.gesrotes.service.impl;

import java.io.IOException;
import java.text.ParseException;

import com.unicauca.gesrotes.common.FileUtil;
import com.unicauca.gesrotes.common.Messages;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.ArchivoMapper;
import com.unicauca.gesrotes.mapper.DocumentoEscenarioMapper;
import com.unicauca.gesrotes.repository.ArchivoRepository;
import com.unicauca.gesrotes.repository.DocumentoEscenarioRepository;
import com.unicauca.gesrotes.repository.EscenarioRepository;
import com.unicauca.gesrotes.service.DocumentoService;
import com.unicauca.gesrotes.service.StorageService;

import lombok.AllArgsConstructor;

import com.unicauca.gesrotes.domain.Archivo;
import com.unicauca.gesrotes.domain.DocumentoEscenario;
import com.unicauca.gesrotes.domain.Escenario;

@Service
@AllArgsConstructor
public class DocumentoServiceImpl implements DocumentoService{

    private ArchivoRepository archivoRepository;
    private DocumentoEscenarioRepository documentoEscenarioRepository;
    private EscenarioRepository escenarioRepository;

    private StorageService storageService;

    @Override
    public DocumentoUUIDResponse guardarDocumento(MultipartFile file, ObjetoArchivoRequest documentoRequest, Long idEscenario) throws IOException, ParseException {
        if(!escenarioExiste(idEscenario)){
            
            throw new ApplicationException("El Escenario no existe");
        }
        Escenario varEscenario=escenarioRepository.findById(idEscenario).orElse(null);
        // Guardar file y Archivo
        byte[] archivo = file.getBytes();
        String uiid = storageService.saveFile(archivo);
        Archivo archivoObj = ArchivoMapper.mapearEntidad(documentoRequest, uiid);
        //Guardar DocumentoEscenario
        DocumentoEscenario docEscenarioObj = DocumentoEscenarioMapper.mapearEntidad(documentoRequest, file.getSize());
         
        archivoObj.agregarDocumentosEscenarios(docEscenarioObj);
        docEscenarioObj.setEscenario(varEscenario);
        docEscenarioObj.setArchivo(archivoObj);
        


        archivoRepository.save(archivoObj);
        documentoEscenarioRepository.save(docEscenarioObj);


        return ArchivoMapper.mapearResponse(uiid);
    }

    private boolean escenarioExiste(long idEscenario){
        return escenarioRepository.existsById(idEscenario);
    }

    @Override
    public byte[] getDocumento(final Long idArchivo) {
        Archivo archivo = archivoRepository.findById(idArchivo)
                .orElseThrow(() -> new ApplicationException(Messages.ID_ARCHIVO_NO_ENCONTRADO));
        byte[] file = storageService.getFile(archivo.getUuid());
        if(FileUtil.emptyByteArray(file)) {
            throw new ApplicationException(Messages.UUID_NO_ENCONTRADO_STORAGE);
        }
        return file;
    }
}
