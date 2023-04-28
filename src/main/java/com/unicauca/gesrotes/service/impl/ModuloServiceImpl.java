package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.response.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.repository.ModuloRespository;
import com.unicauca.gesrotes.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModuloServiceImpl implements ModuloService {

    @Autowired
    private ModuloRespository moduloRespository;

    @Override
    public ModuloSinHorarioDTO listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente, Long id_asignatura) {
        List<Modulo> resEntityModulo = moduloRespository.listaModulosSinHorarioAsignado(id_docente,id_asignatura);
        List<ModuloDTO> resDto = new ArrayList<>();
        for(Modulo m : resEntityModulo){
            ModuloDTO objModulo = mapearEntity(m);
            resDto.add(objModulo);
        }
        ModuloSinHorarioDTO resModuloSinHorario = new ModuloSinHorarioDTO();
        resModuloSinHorario.setModulos_sin_horarios(resDto);
        return resModuloSinHorario;
    }

    private ModuloDTO mapearEntity(Modulo modulo){
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setId(modulo.getId());
        moduloDTO.setNombre(modulo.getNombre());
        return moduloDTO;
    }
}
