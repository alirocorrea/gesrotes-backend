package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.response.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.repository.ModuloRespository;
import com.unicauca.gesrotes.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloServiceImpl implements ModuloService {

    @Autowired
    private ModuloRespository moduloRespository;

    @Override
    public ModuloSinHorarioDTO listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente, Long id_asignatura) {
        List<ModuloDTO> resDto = moduloRespository.listaModulosSinHorarioAsignado(id_docente,id_asignatura).stream().map(ModuloMapper::mapModulo).collect(Collectors.toList());
        ModuloSinHorarioDTO resModuloSinHorario = new ModuloSinHorarioDTO();
        resModuloSinHorario.setModulos_sin_horarios(resDto);
        return resModuloSinHorario;
    }
}
