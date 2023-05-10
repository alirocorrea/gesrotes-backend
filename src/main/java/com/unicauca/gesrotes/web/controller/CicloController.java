package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponseList;
import com.unicauca.gesrotes.service.CicloService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Tag(name = "Ciclo Controller" , description = "Servicios relacionados con los ciclos")
@RestController
@RequestMapping("/api/ciclos")
public class CicloController {
    
    private CicloService cicloServicio;

    @Operation(summary = "Registrar un ciclo para una asignatura")
    @PostMapping("/crear/{id_asignatura}")
    public CicloResponseList registrarNombreModulo(@RequestBody CicloRequest cicloRequest, 
                                                @PathVariable("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_asignatura);
        return cicloServicio.registrarCiclo(cicloRequest, L);
    }

    @Operation(summary = "Listar ciclos Relacionados a una Asignatura")
    @GetMapping("/listar/{id_asignatura}")
    public CicloResponseList listarciclosAsignatura(
                                                @PathVariable("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_asignatura);
        return cicloServicio.listarCiclosAsignatura(L);                                          
    }
}