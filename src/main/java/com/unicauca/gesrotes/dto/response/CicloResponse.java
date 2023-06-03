package com.unicauca.gesrotes.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CicloResponse {
    private Long id;
    private String inicio;
    private String fin;
}
