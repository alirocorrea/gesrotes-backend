package com.unicauca.gesrotes.web.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;
import com.unicauca.gesrotes.service.DocumentoService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Documento Controller" , description = "Servicios relacionados con los documentos")
@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private DocumentoService documentoServicio;

    @Operation(summary = "Registrar un documento asociado a un escenario")
    @PostMapping("/guardar/")
    public DocumentoUUIDResponse registrarNombreModulo(@ModelAttribute ObjetoArchivoRequest objRequest, 
                                                @RequestParam("id_escenario") String id_escenario,
                                                @RequestParam("file") MultipartFile file) throws IOException, ParseException {
        ObjetoArchivoRequest nuevoObjeto = new ObjectMapper().readValue(objRequest.getNombre(), ObjetoArchivoRequest.class);
        Long L = Long.parseLong(id_escenario);
        return documentoServicio.guardarDocumento(file, nuevoObjeto, L);
    }
    
}
