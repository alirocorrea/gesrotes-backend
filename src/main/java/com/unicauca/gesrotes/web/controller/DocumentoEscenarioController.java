package com.unicauca.gesrotes.web.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.unicauca.gesrotes.dto.DocumentoDTO;
import com.unicauca.gesrotes.service.DocumentoEscenarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Documento Escenario Controller" , description = "endpoint capaz de retornar los documentos asociados a un escenario")
@RestController
@RequestMapping("/documentos")
public class DocumentoEscenarioController {
    private final DocumentoEscenarioService documentoEscenarioService;

    public DocumentoEscenarioController(DocumentoEscenarioService documentoEscenarioService) {
        this.documentoEscenarioService = documentoEscenarioService;
    }

    @GetMapping("/listado")
    public ResponseEntity<Map<String, List<DocumentoDTO>>> getDocumentosByEscenario(@RequestParam Long id_escenario) {
        List<DocumentoDTO> documentos = documentoEscenarioService.getDocumentosByEscenarioId(id_escenario);
        
        Map<String, List<DocumentoDTO>> response = new HashMap<>();
        response.put("documentos", documentos);
        
        return ResponseEntity.ok(response);
    }
}

