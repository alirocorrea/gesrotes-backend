package com.unicauca.gesrotes.web.controller;
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

@AllArgsConstructor
@RestController
@RequestMapping("api/horarios")
@Tag(name = "Horario Controller", description = "Servicio Horarios")
public class HorarioController {
    
    @Autowired
    private HorarioService horariosService;

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarHorario(@RequestParam("id_horariosmodulos") Long id_horariosmodulos) {
        try {
            horariosService.eliminarHorarioporId(id_horariosmodulos);
            return new ResponseEntity<>("Horario eliminado correctamente", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("El horario con ID " + id_horariosmodulos + " no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>("Error al eliminar el horario con ID " + id_horariosmodulos, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

