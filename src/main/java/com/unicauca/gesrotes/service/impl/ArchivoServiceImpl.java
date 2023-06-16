package com.unicauca.gesrotes.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.gesrotes.domain.Archivo;
import com.unicauca.gesrotes.domain.DocumentoEscenario;
import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.repository.ArchivoRepository;
import com.unicauca.gesrotes.repository.DocumentoEscenarioRepository;
import com.unicauca.gesrotes.service.ArchivoService;
import com.unicauca.gesrotes.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private DocumentoEscenarioRepository documentoEscenarioRepository;

    @Override
    public String editarArchivo(Long id_archivo , MultipartFile file, ObjetoArchivoRequest objRequest) {
        try{
            //obtener el documentoescenario para poder comparar mediante el id_archivo asociado a este
            DocumentoEscenario documentoEscenario = documentoEscenarioRepository.buscarPorIdArchivo(id_archivo);
            //obtenemos los datos enviados desde front
            ObjetoArchivoRequest obj = objRequest;
//falta empezar a comparar y subir los cambios.
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaVigen = formatter.parse(obj.getFechaVigencia());
            if(!documentoEscenario.getArchivo().getNombre().equals(obj.getNombre()) || !documentoEscenario.getArchivo().getExtension().equals(obj.getTipoArchivo())
                    || !documentoEscenario.getVigencia().equals(fechaVigen) || !documentoEscenario.getTipoDocumento().equals(obj.getTipoArchivo())){
                documentoEscenario.getArchivo().setNombre(obj.getNombre());
                documentoEscenario.getArchivo().setExtension(obj.getTipoArchivo());
                documentoEscenario.setVigencia(fechaVigen);
                documentoEscenario.setTipoDocumento(obj.getTipoDeDocumento());
                documentoEscenario.setFechaSubida(new Date());
                documentoEscenario.setTamano(file.getSize() / 1024);
                documentoEscenarioRepository.save(documentoEscenario);
            }
            //cargo el archivo a bytes el que estan enviando desde el front
            byte [] archivoEditado = file.getBytes();
            if(documentoEscenario.getArchivo() != null){
                //obtengo el archivo por uuid el archivo que esta en el storage
                byte[] archivoOriginal = storageService.getFile(documentoEscenario.getArchivo().getUuid());
                if(!Arrays.equals(archivoOriginal, archivoEditado)){ //evaluo si son diferentes
                    //si es diferente sobre escribo los bytes con el mismo uuid
                    storageService.updateFile(documentoEscenario.getArchivo().getUuid(),archivoEditado );
                }
            }
        }catch (Exception e){
            return  "error al montar el archivo";
        }
        return "editado correctamente";
    }

    public static Object jsonAObjeto(String jsonString){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, ObjetoArchivoRequest.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void eliminarArchivo(Long id_documento) throws NotFoundException {
        Optional<Archivo> archivo = archivoRepository.findById(id_documento);
        if(archivo.isPresent()){
            archivoRepository.deleteById(id_documento);
        }else {
            throw new NotFoundException();
        }
    }
}
