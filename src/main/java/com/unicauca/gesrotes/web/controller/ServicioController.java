package com.unicauca.gesrotes.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.dto.response.ServicioFullResponse;
import com.unicauca.gesrotes.service.ServicioService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Servicios Controller", description = "Servicios relacionados con los servicios")
@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicio;
    
    @Operation(summary ="Filtro para listar los servicios relacionados a un escenario")
    @GetMapping("/listado/{id_escenario}")
    public ServicioFullResponse listarServicios(@PathVariable("id_escenario") String id_escenario) {
        
        Long L = Long.parseLong(id_escenario);
        return servicio.listarServiciosPorEscenario(L);
    }
}
