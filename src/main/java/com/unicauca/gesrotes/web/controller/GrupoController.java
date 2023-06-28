package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.response.GrupoResponse;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.service.GrupoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@AllArgsConstructor
@Tag(name = "Grupo Controller" , description = "Servicios relacionados con los grupos")
@RestController
@RequestMapping("/api/grupos")
public class GrupoController {
    
    private GrupoService grupoService;

    @Operation(summary = "Registrar un nuevo Grupo Asociado a una Asignatura")
    @PostMapping("/crear")
    public GrupoResponse registrarNombreModulo(@RequestParam("id_asignatura") String id_asignatura) throws ParseException {
        Long L = Long.parseLong(id_asignatura);
        return grupoService.registrarGrupo(L);
    }

    @GetMapping("/listar/{id_asignatura}")
    @Operation(summary = "Listar grupos registrados en la Asignatura")
    public ResponseEntity<List<Grupo>> findByAsignatura(@PathVariable Long id_asignatura) {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(id_asignatura);
        return ResponseEntity.ok(grupoService.findByAsignatura(asignatura));
    }

    @Operation(summary = "Eliminar un grupo por id_grupo")
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarGrupo(@RequestParam Long id_grupo) {
        grupoService.eliminarGrupo(id_grupo);
        return ResponseEntity.ok("OK");
    }

    @Operation(summary = "Eliminar un estudiante de un grupo por id_grupo e id_estudiante")
    @DeleteMapping("/retirarEstudiante")
    public ResponseEntity<String> retirarEstudiante(@RequestParam Long id_estudiante, @RequestParam Long id_grupo) {
        grupoService.retirarEstudiante(id_estudiante, id_grupo);
        return ResponseEntity.ok("OK");
    }

}