package com.unicauca.gesrotes.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class UpdateCicloDTO {
    private Long id;
    private Date inicio;
    private Date fin;
}
