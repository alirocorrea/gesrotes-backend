package com.unicauca.gesrotes.service.impl;


import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.dto.ModuloSinHorarioDTO;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.repository.DocenteRepository;
import com.unicauca.gesrotes.repository.ModuloRepository;
import com.unicauca.gesrotes.repository.ModuloRespository;
import com.unicauca.gesrotes.service.ModuloService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModuloServiceImpl implements ModuloService{

    private ModuloRepository modulosRepository;
    private DocenteRepository docentesRepository;
    private ModuloRespository moduloRespository;
    @Override
    public ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) {
        if(!docenteExiste(idDocente)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "El Docente no existe"
            );
        }
        Docente varDocente=docentesRepository.findById(idDocente).orElse(null);
        if (!esValidoNombre(moduloRequest)) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "El nombre de Modulo ya existe"
            );
        }
        Modulo modulo = ModuloMapper.mapearEntidadNombre(moduloRequest);
        modulo.setDocente(varDocente);
        return ModuloMapper.mapearResponse(modulosRepository.save(modulo));
    }
    
    private boolean esValidoNombre(ModuloRequest request) {
        return modulosRepository.findByNombre(request.getNombre_modulo()).size() == 0;
    }

    private boolean docenteExiste(long idDocente){
        return docentesRepository.existsById(idDocente);
    }

    @Override
    public ModuloSinHorarioDTO listarModulosSinHorarioAsignadoPorIdDocenteIdAsignatura(Long id_docente, Long id_asignatura) {
        List<ModuloDTO> resDto = moduloRespository.listaModulosSinHorarioAsignado(id_docente,id_asignatura).stream().map(ModuloMapper::mapModulo).collect(Collectors.toList());
        ModuloSinHorarioDTO resModuloSinHorario = new ModuloSinHorarioDTO();
        resModuloSinHorario.setModulos_sin_horarios(resDto);
        return resModuloSinHorario;
    }

}