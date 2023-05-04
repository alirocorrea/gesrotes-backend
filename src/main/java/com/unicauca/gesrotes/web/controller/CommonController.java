package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.PingResponse;
import com.unicauca.gesrotes.service.CommonService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Configuración global de Swagger, no replique este código en otros controladores
@OpenAPIDefinition(info = @Info(
        title = Constants.SWAGGER_TITLE,
        description = Constants.SWAGGER_DESCRIPTION,
        version = Constants.SWAGGER_VERSION),
        servers = { @Server(url = Constants.SWAGGER_SERVER_URL, description = Constants.SWAGGER_SERVER_DESCRIPTION) })

@AllArgsConstructor
@RestController
@RequestMapping("/api/common")
@Tag(name = "Common Controller", description = "Servicios comunes y de utilidad")
public class CommonController {

    private CommonService commonService;

    @GetMapping("/ping")
    @Operation(summary = "Comprueba la conexión con el servidor y la base de datos")
    public ResponseEntity<PingResponse> getPing() {
        return ResponseEntity.ok(commonService.getPing());
    }
}
