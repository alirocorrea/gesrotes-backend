package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EscenariosDocumentosResponse {
    private Long id;
    private String nombre;
    private int documentos_expirados;
}
