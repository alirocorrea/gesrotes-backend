package com.unicauca.gesrotes.dto;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DocumentoDTO {

    private Long id_documento;
    private Long id_archivo;
    private Long id_escenario;
    private String nombre_archivo;
    private Date fecha_vigencia;
    private String tipo_documento;
    private String extension;
}
