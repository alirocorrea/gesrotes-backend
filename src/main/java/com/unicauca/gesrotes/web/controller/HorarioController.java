package com.unicauca.gesrotes.web.controller;
import com.unicauca.gesrotes.common.Constants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;
import com.unicauca.gesrotes.service.HorarioService;

// Global Swagger configuration, do not replicate this code in other controllers
@OpenAPIDefinition(info = @Info(
        title = Constants.SWAGGER_TITLE,
        description = Constants.SWAGGER_DESCRIPTION,
        version = Constants.SWAGGER_VERSION),
        servers = { @Server(url = Constants.SWAGGER_SERVER_URL, description = Constants.SWAGGER_SERVER_DESCRIPTION) })

@AllArgsConstructor
@RestController
@RequestMapping("/horarios")
@Tag(name = "Horario Controller", description = "Servicio Horarios")
public class HorarioController {
    
    @Autowired
    private HorarioService horariosService;

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarHorario(@RequestParam("id_horario") Long idHorario) {
        try {
            horariosService.eliminarHorarioporId(idHorario);
            return new ResponseEntity<>("Horario eliminado correctamente", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("El horario con ID " + idHorario + " no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el horario con ID " + idHorario, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

