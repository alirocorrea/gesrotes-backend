package com.unicauca.gesrotes.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HorariosModulosDTO {

    private List<ModuloDTO> modulos;
    
        
}
