package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.CicloRequest;
import com.unicauca.gesrotes.dto.response.CicloResponse;
import com.unicauca.gesrotes.dto.response.CicloResponseList;
import com.unicauca.gesrotes.service.CicloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  
    @Operation(summary = "Editar un ciclo")
    @PutMapping("/{id_ciclo}/editar")
    public CicloResponse editarCiclo(@RequestBody CicloRequest cicloRequest, 
                                                @PathVariable int id_ciclo){
        Long L = (long) id_ciclo;
        return cicloServicio.editarCiclo(cicloRequest, L);

    } 

    @Operation(summary = "Eliminar un ciclo")
    @DeleteMapping("/{id_ciclo}/eliminar")
    public ResponseEntity<String> eliminar(@PathVariable Long id_ciclo){
        try {
          cicloServicio.eliminar(id_ciclo); 
        } catch (Exception e) {
          return ResponseEntity.internalServerError().body("Error durante la eliminacion del ciclo");
        }
        return ResponseEntity.ok("OK");
    } 
}