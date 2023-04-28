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
        List<Modulo> respuestaModulo = moduloRespository.listaModulosSinHorarioAsignado(id_docente,id_asignatura);
        List<ModuloDTO> respuestaDto = new ArrayList<>();
        for(Modulo m : respuestaModulo){
            ModuloDTO objModulo = mapearEntity(m);
            respuestaDto.add(objModulo);
        }
        ModuloSinHorarioDTO res = new ModuloSinHorarioDTO();
        res.setModulos_sin_horarios(respuestaDto);
        return res;
    }

    private ModuloDTO mapearEntity(Modulo modulo){
        ModuloDTO moduloDTO = new ModuloDTO();
        moduloDTO.setId(modulo.getId());
        moduloDTO.setNombre(modulo.getNombre());
        return moduloDTO;
    }
}
