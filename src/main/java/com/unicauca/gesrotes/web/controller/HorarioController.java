package com.unicauca.gesrotes.web.controller;
import com.unicauca.gesrotes.dto.HorariosModulosDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;
import com.unicauca.gesrotes.service.HorarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/horarios")
@Tag(name = "Horario Controller", description = "Servicio Horarios")
public class HorarioController {
    
    @Autowired
    private HorarioService horariosService;

    @Operation(summary = "Eliminar horarios de un docente en una asignatura,")
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminarHorario(@RequestParam("id_horariosmodulos") Long id_horariosmodulos) {
        try {
            horariosService.eliminarHorarioporId(id_horariosmodulos);
            return new ResponseEntity<>("Horario eliminado correctamente", HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>("El horario con ID " + id_horariosmodulos + " no existe", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el horario con ID " + id_horariosmodulos, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Configurar un horario")
    @PostMapping("/configurar_horario")
    public ResponseEntity<CreateHorarioResponse> createHorario (@RequestParam("id_modulo") final Long idModulo,
                                                                @RequestBody @Valid final CreateHorarioRequest request) {
        return ResponseEntity.ok(horariosService.createHorario(idModulo, request));
    }

    @GetMapping("/listado")
    @Operation(summary = "Obtiene los horarios asociados a la asignatura y al docente")
    public ResponseEntity<HorariosModulosDTO>  getHorariosModulos(@RequestParam("id_docente")Long id_docente, @RequestParam("id_asignatura")Long id_asignatura){

        HorariosModulosDTO createHorarioResponse = this.horariosService.getHorariosModulos(id_docente, id_asignatura);
        return ResponseEntity.ok(createHorarioResponse);
    }
    
    /* 
    public ResponseEntity<List<HorariosModulosDTO>>  getHorariosModulos(@RequestParam("id_docente")Long id_docente, @RequestParam("id_asignatura")Long id_asignatura){

        List<HorariosModulosDTO> createHorarioResponse = this.horariosService.getHorariosModulos(id_docente, id_asignatura);
        return ResponseEntity.ok(createHorarioResponse);

    }
    */

}

