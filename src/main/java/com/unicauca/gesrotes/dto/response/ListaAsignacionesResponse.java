package com.unicauca.gesrotes.dto.response;

import com.unicauca.gesrotes.dto.AsignacionDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListaAsignacionesResponse {
    private List<AsignacionDTO> asignaciones;
}
