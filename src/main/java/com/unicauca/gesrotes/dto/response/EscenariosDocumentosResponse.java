package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EscenariosDocumentosResponse {
    private EscenariosResponse escenarios;
    private String info;
}
