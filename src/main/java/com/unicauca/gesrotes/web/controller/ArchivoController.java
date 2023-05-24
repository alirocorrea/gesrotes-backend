package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.service.ArchivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Tag(name = "Archivo controller", description = "Servicios relacionados con los archivos")
@RestController
@RequestMapping("/api/documentos")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @Operation(summary = "HE05-HU02 editar un archivo")
    @PutMapping("/editar")
    public ResponseEntity<String> actualizarArchivo(@RequestParam Long id_documento, @RequestParam("file") MultipartFile file,@ModelAttribute(name = "datosEditar") String datosEditar){
        return new ResponseEntity<>(archivoService.editarArchivo(id_documento,file,datosEditar), HttpStatus.ACCEPTED);
    }
}
