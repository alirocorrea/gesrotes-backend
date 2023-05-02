package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class ModuloDTO {

    private Long id;
    private String nombre;
}
