package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.dto.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.service.ModuloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Modulo Controller" , description = "Servicios relacionados con los modulos")
@RestController
@RequestMapping("/api/modulos")
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

    @GetMapping("/sin_horarios")
    @Operation(summary = "HU01 modulos a los que no se le han asignado horarios")
    public ResponseEntity<ModuloSinHorarioDTO> horarioSinAsignar(@RequestParam Long id_docente, @RequestParam Long id_asignatura){
        return ResponseEntity.ok(moduloService.listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(id_docente,id_asignatura));
    }

    

}