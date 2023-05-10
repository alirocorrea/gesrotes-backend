package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FechaResponse {
    private String mes;
    private int dia;
    private int anyo;
}
