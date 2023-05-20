package com.unicauca.gesrotes.web.controller;

import com.unicauca.gesrotes.dto.request.CreateRoteRequest;
import com.unicauca.gesrotes.service.RoteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@Tag(name = "Rotes Controller", description = "Servicios relacionados con los rotes")
@RestController
@RequestMapping("/api/rotes")
public class RoteController {

    private RoteService roteService;

    @PostMapping("/crear")
    public ResponseEntity<Object> createRote(@RequestBody @Valid final CreateRoteRequest request) {
        return ResponseEntity.ok(roteService.createRote(request));
    }
}
