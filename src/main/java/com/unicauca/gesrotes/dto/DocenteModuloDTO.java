package com.unicauca.gesrotes.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import lombok.Data;


@Getter
@Setter
@Data
public class DocenteModuloDTO {
    
    private List<DocenteDTO> docente;
    
}
