package com.unicauca.gesrotes.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class DocumentoRequest {
    @NotNull
    @JsonProperty("nombre")
    private String nombre;

    @NotNull
    @JsonProperty("tipoArchivo")
    private String tipoArchivo;

    @NotNull
    @JsonProperty("fechavigencia")
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fechavigencia;

    @NotNull
    @JsonProperty("tipoDocumento")
    private String tipoDocumento;
}
