package com.unicauca.gesrotes.dto.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CicloRequest {
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date inicio;
    @JsonFormat(shape =JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Bogota")
    private Date fin;

    @JsonCreator
    public CicloRequest(Date inicio,Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
}