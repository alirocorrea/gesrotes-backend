package com.unicauca.gesrotes.mapper;

import java.util.ArrayList;
import java.util.List;

import com.unicauca.gesrotes.common.Constants;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.DocenteDTO;
import com.unicauca.gesrotes.dto.response.DocenteModuloResponse;
import com.unicauca.gesrotes.dto.response.DocenteResponse;

public final class DocenteMapper {
    
    private DocenteMapper() {
        throw new IllegalStateException(Constants.UTILITY_CLASS);
    }

    public static DocenteResponse mapearResponse(Docente docente) {
        List<Modulo> listaModulos = new ArrayList<>();
        listaModulos=docente.getModulos();
        String varInfo;
        if (listaModulos.size()==0) {
            varInfo="No hay modulos";
        } else {
            int counterModulosNoHorarios=0;
            for(Modulo iModulo : listaModulos){
                if(iModulo.getHorariosModulos().size()==0){
                    counterModulosNoHorarios++;
                }
            }
            if(counterModulosNoHorarios==0){
                varInfo="None";
            }
            else{
                varInfo=counterModulosNoHorarios + " Horarios sin configurar";
            }
        }
        
        return DocenteResponse.builder()
        .id(docente.getId())
        .nombre(docente.getPersona().getNombre()+ " " + docente.getPersona().getApellido())
        .info(varInfo)
        .build();
    }

    public static DocenteDTO mapearResponseDocenteModuloResponse(Docente docente) {
        return DocenteDTO.builder()
                .id(docente.getId())
                .nombre(docente.getPersona().getNombre()+ " " + docente.getPersona().getApellido())
                .build();
    }

}