package com.unicauca.gesrotes.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoArchivoRequest {
    private String nombre;
    private String tipoArchivo;
    private String fechaVigencia;
    private String tipoDeDocumento;
}
