package com.unicauca.gesrotes.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unicauca.gesrotes.dto.DocumentoDTO;
import com.unicauca.gesrotes.service.ArchivoService;
import com.unicauca.gesrotes.service.DocumentoEscenarioService;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;
import com.unicauca.gesrotes.service.DocumentoService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Tag(name = "Documento Controller" , description = "Servicios relacionados con los documentos")
@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    private DocumentoService documentoService;
    private DocumentoEscenarioService documentoEscenarioService;
    private ArchivoService archivoService;

    @Operation(summary = "Registrar un documento asociado a un escenario")
    @PostMapping("/guardar")
    public DocumentoUUIDResponse registrarNombreModulo(@ModelAttribute ObjetoArchivoRequest objRequest, 
                                                @RequestParam("id_escenario") String id_escenario,
                                                @RequestParam("file") MultipartFile file) throws IOException, ParseException {
        ObjetoArchivoRequest nuevoObjeto = new ObjectMapper().readValue(objRequest.getNombre(), ObjetoArchivoRequest.class);
        Long L = Long.parseLong(id_escenario);
        return documentoService.guardarDocumento(file, nuevoObjeto, L);
    }

    @Operation(summary = "Obtener un documento en arraglo de bytes (Descargar HE05-HU05)")
    @GetMapping("/descargar")
    public ResponseEntity<byte[]> getDocumento(@RequestParam("id_documento") final Long idArchivo) {
        return ResponseEntity.ok(documentoService.getDocumento(idArchivo));
    }

    @GetMapping("/listado")
    public ResponseEntity<Map<String, List<DocumentoDTO>>> getDocumentosByEscenario(@RequestParam Long id_escenario) {
        List<DocumentoDTO> documentos = documentoEscenarioService.getDocumentosByEscenarioId(id_escenario);
        Map<String, List<DocumentoDTO>> response = new HashMap<>();
        response.put("documentos", documentos);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "HE05-HU02 editar un archivo")
    @PutMapping("/editar")
    public ResponseEntity<String> actualizarArchivo(@RequestParam Long id_documento, @RequestParam("file") MultipartFile file,@ModelAttribute(name = "datosEditar") String datosEditar){
        return new ResponseEntity<>(archivoService.editarArchivo(id_documento,file,datosEditar), HttpStatus.ACCEPTED);
    }


    @Operation(summary = "HE05-HU03 Eliminar un documento")
    @DeleteMapping("/eliminar/")
    public ResponseEntity<String> eliminarArchivo(@RequestParam Long id_documento) throws NotFoundException{
        try {
            documentoService.eliminarArchivo(id_documento);
            return new ResponseEntity<>("Archivo eliminado correctamente", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el Archivo con ID " + id_documento, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        
    }
}
