package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.response.HorarioResponse;
import com.unicauca.gesrotes.service.HorarioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/horarios")
@Tag(name ="Horario Controller", description = "Servicios de Horario")
public class HorarioController {

    private HorarioService horarioService;

    @GetMapping("/sin_configurar")
    @Operation(summary = "horario no configurado")
    public ResponseEntity<List<HorarioResponse>> listaHorarioNoConfigurado(@RequestParam Long id_docente, @RequestParam Long id_asignatura){
        return ResponseEntity.ok(horarioService.listaHorarioNoConfigurado(id_docente,id_asignatura));
    }
}
