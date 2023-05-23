package com.unicauca.gesrotes.mapper;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Archivo;
import com.unicauca.gesrotes.dto.request.ObjetoArchivoRequest;
import com.unicauca.gesrotes.dto.response.DocumentoUUIDResponse;

public final class ArchivoMapper {
    
    private ArchivoMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static Archivo mapearEntidad(ObjetoArchivoRequest documentoRequest, String vUuid) {
        return Archivo.builder()
            .nombre(documentoRequest.getNombre())
            .extension(documentoRequest.getTipoArchivo())
            .uuid(vUuid)
            .build();
    }

    public static DocumentoUUIDResponse mapearResponse(String uiid) {
        return DocumentoUUIDResponse.builder()
        .uuid(uiid)
        .build();
    }
}
