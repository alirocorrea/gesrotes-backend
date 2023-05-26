package com.unicauca.gesrotes.mapper;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.DocumentoEscenario;
import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;

public final class DocumentoEscenarioMapper {
    
    private DocumentoEscenarioMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static DocumentoEscenario mapearEntidad(ObjetoArchivoRequest documentoRequest, Long fileSize) throws ParseException{
        String pattern = "yyyy-MM-dd";
        Date varDate =new SimpleDateFormat(pattern).parse(documentoRequest.getFechaVigencia());
        return DocumentoEscenario.builder()
            .vigencia(varDate)
            .tipoDocumento(documentoRequest.getTipoDeDocumento())
            .fechaSubida(new Date())
            .tamano(fileSize)
            .build();
    }
}
