package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponseList;
import com.unicauca.gesrotes.service.CicloService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Ciclo Controller" , description = "Servicios relacionados con los ciclos")
@RestController
@RequestMapping("/api/ciclos")
public class CicloController {
    
    private CicloService cicloServicio;

    @Operation(summary = "Registrar un ciclo para una asignatura")
    @PostMapping("/crear/")
    public CicloResponseList registrarNombreModulo(@RequestBody CicloRequest cicloRequest, 
                                                @RequestParam("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_asignatura);
        return cicloServicio.registrarCiclo(cicloRequest, L);
    }

    @Operation(summary = "Listar ciclos Relacionados a una Asignatura")
    @GetMapping("/listar/")
    public CicloResponseList listarciclosAsignatura(
                                                @RequestParam("id_asignatura") String id_asignatura) {
        Long L = Long.parseLong(id_asignatura);
        return cicloServicio.listarCiclosAsignatura(L);                                          
    }

    @Operation(summary = "HE09-HU05 Eliminar los cicos de una asignatura")
    @DeleteMapping("/{id_asignatura}/eliminarTodo")
    public ResponseEntity<String> eliminarCiclosPorIdAsignatura(@PathVariable Long id_asignatura){
        return new ResponseEntity<String>(cicloServicio.eliminarCiclosPorIdAsignatura(id_asignatura), HttpStatus.ACCEPTED);
    }
}