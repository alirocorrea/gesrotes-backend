package com.unicauca.gesrotes.mapper;

import java.util.Date;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.DocumentoEscenario;
import com.unicauca.gesrotes.dto.request.DocumentoRequest;

public final class DocumentoEscenarioMapper {
    
    private DocumentoEscenarioMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static DocumentoEscenario mapearEntidad(DocumentoRequest documentoRequest, Long fileSize) {
        return DocumentoEscenario.builder()
            .vigencia(documentoRequest.getFechavigencia())
            .tipoDocumento(documentoRequest.getTipoDocumento())
            .fechaSubida(new Date())
            .tamano(fileSize)
            .build();
    }
}
