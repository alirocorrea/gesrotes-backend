package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.service.ModuloService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Global Swagger configuration, do not replicate this code in other controllers
@OpenAPIDefinition(info = @Info(
        title = Constants.SWAGGER_TITLE,
        description = Constants.SWAGGER_DESCRIPTION,
        version = Constants.SWAGGER_VERSION),
        servers = { @Server(url = Constants.SWAGGER_SERVER_URL, description = Constants.SWAGGER_SERVER_DESCRIPTION) })

@AllArgsConstructor
@RestController
@RequestMapping("/api/modulos")
@Tag(name = "Modulo Controller", description = "Servicios Modulo")
public class ModuloController {

    private ModuloService moduloService;

    @GetMapping("/sin_horarios")
    @Operation(summary = "HU01 modulos a los que no se le han asignado horarios")
    public ResponseEntity<ModuloSinHorarioDTO> horarioSinAsignar(@RequestParam Long id_docente, @RequestParam Long id_asignatura){
        return ResponseEntity.ok(moduloService.listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(id_docente,id_asignatura));
    }
}
