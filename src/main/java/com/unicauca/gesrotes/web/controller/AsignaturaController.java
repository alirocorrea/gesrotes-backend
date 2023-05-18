
package com.unicauca.gesrotes.web.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.dto.response.AsignaturasResponse;
import com.unicauca.gesrotes.mapper.AsignaturaMapper;
import com.unicauca.gesrotes.service.AsignaturaService;

import io.swagger.v3.core.util.Constants;
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
@Tag(name = "Asignatura Controller", description = "Servicios comunes")
@CrossOrigin(origins = "*")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    private final AsignaturaMapper asignaturaMapper;
    
    @GetMapping("/listado")
    @Operation(summary = "Obtiene el listado de las asignaturas segun el id del programa")
    public ResponseEntity<List<AsignaturasResponse>> getAsignaturas() {
        
        List<Asignatura> asignaturas = this.asignaturaService.getAsignaturas();
        List<AsignaturasResponse> asignaturasResponses = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            AsignaturasResponse asignaturasResponse = this.asignaturaMapper.domainToDTO(asignatura);
            asignaturasResponses.add(asignaturasResponse);
        }
        return ResponseEntity.ok(asignaturasResponses);
    }
}
