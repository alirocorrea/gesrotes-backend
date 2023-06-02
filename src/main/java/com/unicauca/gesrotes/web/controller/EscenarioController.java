package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.response.EscenariosDocumentosResponse;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import com.unicauca.gesrotes.service.EscenarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/escenarios")
@Tag(name = "Escenarios Controller", description = "Servicios relcionados con los escenarios")
public class EscenarioController {

    private EscenarioService escenarioService;
    
    @GetMapping("/listado")
    @Operation(summary = "Obtiene todos los escenarios")
    public ResponseEntity<List<EscenariosResponse>> getEscenarios() {
        return ResponseEntity.ok(escenarioService.getEscenarios());
    }

    @GetMapping("/estado_documentos")
    @Operation(summary = "estado de los documentos (Expirados)")
    public List<EscenariosDocumentosResponse> getEscenariosDocumentos() {
        return escenarioService.getEscenariosDocumentos();
    }
} 
