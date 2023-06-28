package com.unicauca.gesrotes.dto.response;

import com.unicauca.gesrotes.dto.GrupoDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListarGruposResponse {

    private List<GrupoDTO> grupos;
}
