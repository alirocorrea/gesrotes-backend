package com.unicauca.gesrotes.service.impl;

import java.io.IOException;
import java.text.ParseException;

import com.unicauca.gesrotes.common.Check;
import com.unicauca.gesrotes.common.FileUtil;
import com.unicauca.gesrotes.common.Messages;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

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
    public byte[] getDocumento(final Long idDocumentoEscenario) {
        DocumentoEscenario documentoEscenario = documentoEscenarioRepository.getDocumentoEscenarioArchivo(idDocumentoEscenario);
        if (Check.isNull(documentoEscenario)) {
            throw new ApplicationException(Messages.ID_DOCUMENTO_NO_ENCONTRADO);
        }
        byte[] file = storageService.getFile(documentoEscenario.getArchivo().getUuid());
        if(FileUtil.emptyByteArray(file)) {
            throw new ApplicationException(Messages.UUID_NO_ENCONTRADO_STORAGE);
        }
        return file;
    }

    @Override
    public void eliminarArchivo(Long id_documento) {
        DocumentoEscenario documentoEscenario = documentoEscenarioRepository.getDocumentoEscenarioArchivo(id_documento);
        if(Check.isNotNull(documentoEscenario)){
            Long idArchivo = documentoEscenario.getArchivo().getId();
            documentoEscenarioRepository.deleteById(documentoEscenario.getId());
            archivoRepository.deleteById(idArchivo);
        } else {
            throw new NotFoundException("El documento con ID " + id_documento + " no existe");
        }
    }

}
