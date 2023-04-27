package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.service.ModuloService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Tag(name = "Modulo Controller" , description = "Servicios relacionados con los modulos")
@RestController
@RequestMapping("/modulos")
public class ModuloController {
    
    private ModuloService moduloService;

    @Operation(summary = "Registrar un nombre para un nuevo horario")
    @PostMapping("/crear/{id_docente}/{id_asignatura}")
    public ModuloResponse registrarNombreModulo(@RequestBody ModuloRequest moduloRequest, 
                                                @PathVariable("id_docente") String id_docente,
                                                @PathVariable("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_docente);
        return moduloService.registrarNombreModulo(moduloRequest, L);
    }
}