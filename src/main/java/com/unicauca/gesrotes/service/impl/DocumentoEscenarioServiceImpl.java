package com.unicauca.gesrotes.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.unicauca.gesrotes.repository.DocumentoEscenarioRepository;
import com.unicauca.gesrotes.service.DocumentoEscenarioService;

import com.unicauca.gesrotes.domain.DocumentoEscenario;
import com.unicauca.gesrotes.dto.DocumentoDTO;

@Service
public class DocumentoEscenarioServiceImpl implements DocumentoEscenarioService {
    private final DocumentoEscenarioRepository documentoEscenarioRepository;

    public DocumentoEscenarioServiceImpl(DocumentoEscenarioRepository documentoEscenarioRepository) {
        this.documentoEscenarioRepository = documentoEscenarioRepository;
    }

    @Override
    public List<DocumentoDTO> getDocumentosByEscenarioId(Long idEscenario) {
        List<DocumentoEscenario> documentos = documentoEscenarioRepository.findByEscenarioIdEscenarios(idEscenario);
        
        return documentos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private DocumentoDTO convertToDTO(DocumentoEscenario documento) {
        DocumentoDTO documentoDTO = new DocumentoDTO();
        documentoDTO.setId_documento(documento.getId());
        documentoDTO.setId_archivo(documento.getArchivo().getId());
        documentoDTO.setId_escenario(documento.getEscenario().getId());
        documentoDTO.setNombre_archivo(documento.getArchivo().getNombre());
        documentoDTO.setFecha_vigencia(documento.getVigencia());
        documentoDTO.setTipo_documento(documento.getTipoDocumento());
        documentoDTO.setExtension(documento.getArchivo().getExtension());
        
        return documentoDTO;
    }
}