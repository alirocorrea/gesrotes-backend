package com.unicauca.gesrotes.web.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/horarios")
@Tag(name ="Horario Controller", description = "Servicios de Horario")
public class HorarioController {

    @GetMapping("/sin_configurar")
    @Operation(summary = "horario no configurado")
    public ResponseEntity<String> getHorarios(){
        return null;
    }
}
