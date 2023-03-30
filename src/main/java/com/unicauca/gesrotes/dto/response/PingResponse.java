package com.unicauca.gesrotes.dto.response;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
public class PingResponse {

    LocalDateTime timestamp;

    @NotNull
    @NotBlank
    String message;
}
