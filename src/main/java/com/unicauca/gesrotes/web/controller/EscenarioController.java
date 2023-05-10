package com.unicauca.gesrotes.web.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.dto.response.EscenariosResponse;
import com.unicauca.gesrotes.service.impl.EscenariosService;
import com.unicauca.gesrotes.mapper.EscenariosMapper;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

@OpenAPIDefinition(info = @Info(
        title = Constants.SWAGGER_TITLE,
        description = Constants.SWAGGER_DESCRIPTION,
        version = Constants.SWAGGER_VERSION),
        servers = { @Server(url = Constants.SWAGGER_SERVER_URL, description = Constants.SWAGGER_SERVER_DESCRIPTION) })

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/servicios")
@Tag(name = "Escenarios Controller", description = "Servicios comunes")
@CrossOrigin(origins = "*")
public class EscenarioController {

    private final EscenariosService escenariosService;

    private final EscenariosMapper escenarioMapper;
    
    @GetMapping("/listado")
    @Operation(summary = "Obtiene todos los escenarios")
    public ResponseEntity<List<EscenariosResponse>> getEscenarios() {
        
        List<Escenario> escenarios = this.escenariosService.getEscenarios();
        List<EscenariosResponse> escenariosResponses = new ArrayList<>();
        for (Escenario escenario : escenarios) {
            EscenariosResponse escenariosResponse = this.escenarioMapper.domainToDTO(escenario);
            escenariosResponses.add(escenariosResponse);
        }
        return ResponseEntity.ok(escenariosResponses);
    }
}
