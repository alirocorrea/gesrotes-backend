package com.unicauca.gesrotes.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class HorarioModuloDTO {

    private Long id;
    private String descripcion;
}
