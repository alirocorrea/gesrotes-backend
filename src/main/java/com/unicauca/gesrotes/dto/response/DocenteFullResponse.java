package com.unicauca.gesrotes.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocenteFullResponse {
    private List<DocenteResponse> docentes;
    private String info;
}
