package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.response.DocenteFullResponse;
import com.unicauca.gesrotes.service.DocenteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Tag(name = "Docente Controller" , description = "Servicios relacionados con los docentes")
@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
    
    private DocenteService docenteServicio;

    @Operation(summary = "Listar docentes Relacionados a una Asignatura")
    @GetMapping("/listado/")
    public DocenteFullResponse listardocentesAsignatura(
                                                @RequestParam("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_asignatura);
        return docenteServicio.listarDocentesAsignatura(L);                                          
    }
}