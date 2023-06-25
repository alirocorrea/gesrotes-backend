package com.unicauca.gesrotes.dto;

import java.util.List;

import com.unicauca.gesrotes.dto.response.ProgramaResponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AsignaturaDTO {

     private List<ProgramaResponse> programas;
    
}
