package com.unicauca.gesrotes.mapper;

import java.util.List;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.dto.response.CicloResponse;
import com.unicauca.gesrotes.dto.response.CicloResponseList;

public final class CicloListMapper {
    
    private CicloListMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static CicloResponseList mapearResponse(List<CicloResponse> ciclos) {
        return CicloResponseList.builder()
        .ciclos(ciclos)
        .build();
    }

}