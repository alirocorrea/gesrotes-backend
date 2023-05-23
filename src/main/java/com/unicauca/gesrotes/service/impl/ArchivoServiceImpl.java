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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Autowired
    private StorageService storageService;

    @Autowired
    private DocumentoEscenarioRepository documentoEscenarioRepository;

    @Override
    public String editarArchivo(Long id_archivo , MultipartFile file, String datosEditar) {
        /*
        {
          "nombre": "nombre del archivo",
          "tipoArchivo": "pdf",
          "fechaVigencia": "2023-06-30",
          "tipoDeDocumento": "Plan de prácticas"
        }
        * */
        try{
            //obtener el documentoescenario para poder comparar mediante el id_archivo asociado a este
            DocumentoEscenario documentoEscenario = documentoEscenarioRepository.buscarPorIdArchivo(id_archivo);

            //obtenemos los datos enviados desde front
            ObjetoArchivoRequest obj = (ObjetoArchivoRequest) jsonAObjeto(datosEditar);
//falta empezar a comparar y subir los cambios.
            documentoEscenario.getArchivo().getNombre();
            documentoEscenario.getArchivo().getExtension(); //tipo de archivo
            documentoEscenario.getVigencia();
            documentoEscenario.getTipoDocumento();

            //cargo el archivo a bytes el que estan enviando desde el front
            byte [] archivoEditado = file.getBytes();
            if(documentoEscenario.getArchivo() != null){
                //obtengo el archivo por uuid el archivo que esta en el storage
                byte[] archivoOriginal = storageService.getFile(documentoEscenario.getArchivo().getUuid());
                if(!Arrays.equals(archivoOriginal, archivoEditado)){ //evaluo si son diferentes
                    //si es diferente sobre escribo los bytes con el mismo uuid
                    //metodo por hacer
                }
            }
        }catch (Exception e){
            return  "error al montar el archivo";
        }

        return null;
    }

    public static Object jsonAObjeto(String jsonString){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, ObjetoArchivoRequest.class);
        }catch (Exception e){
            return null;
        }
    }
}