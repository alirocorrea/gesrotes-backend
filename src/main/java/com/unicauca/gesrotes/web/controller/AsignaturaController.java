package com.unicauca.gesrotes.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.response.AsignaturasResponse;
import com.unicauca.gesrotes.service.AsignaturaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/asignaturas")
@Tag(name = "Asignatura Controller", description = "Servicios relacionados con las asignaturas")
public class AsignaturaController {
    
    private final AsignaturaService asignaturaService;
    
    @GetMapping("/listar")
    @Operation(summary = "Obtiene el listado de las asignaturas segun el id del programa")
    public ResponseEntity<List<AsignaturasResponse>> getAsignaturas(@RequestParam("id_programa")Long id_programa) {
        
        List<AsignaturasResponse> asignaturasResponses =  this.asignaturaService.getAsignaturas(id_programa);
        
        return ResponseEntity.ok(asignaturasResponses);
    }
    
}
