package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponseList;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.service.GrupoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@Tag(name = "Grupo Controller" , description = "Servicios relacionados con los grupos")
@RestController
@RequestMapping("/grupos")
public class GrupoController {
    
    private GrupoService grupoService;

    @GetMapping("/listar/{id_asignatura}")
    @Operation(summary = "Listar grupos registrados en la Asignatura")
    public ResponseEntity<List<Grupo>> findByAsignatura(@PathVariable Long id_asignatura) {
        Asignatura asignatura = new Asignatura();
        asignatura.setId(id_asignatura);
        return ResponseEntity.ok(grupoService.findByAsignatura(asignatura));
    }

}