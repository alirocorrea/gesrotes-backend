package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.response.EliminarAsignacionResponse;
import com.unicauca.gesrotes.service.AsignacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Tag(name = "Asignacion Controller", description = "Servicios relacionados con asignacion")
@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    private AsignacionService asignacionService;

    @Operation(summary = "Eliminar asignaciones existentes para un ciclo y un grupo")
    @DeleteMapping("/eliminar_todas")
    public ResponseEntity<EliminarAsignacionResponse> eliminarAsignacionesPorIdGrupoIdCiclo(@RequestParam Long id_grupo, @RequestParam Long id_ciclo){
       return ResponseEntity.ok( asignacionService.eliminarAsignacionesPorIdGrupoIdCiclo(id_grupo,id_ciclo));
    }
}
