package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.dto.ModuloSinHorarioDTO;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.dto.request.ModuloRequest;
import com.unicauca.gesrotes.dto.DocenteDTO;
import com.unicauca.gesrotes.dto.DocenteModuloDTO;
import com.unicauca.gesrotes.dto.HorarioDTO;
import com.unicauca.gesrotes.dto.ModuloDTO;
import com.unicauca.gesrotes.dto.response.ModuloResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.HorarioMapper;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.mapper.DocenteMapper;
import com.unicauca.gesrotes.repository.DocenteRepository;
import com.unicauca.gesrotes.repository.HorarioRepository;
import com.unicauca.gesrotes.repository.ModuloRepository;
import com.unicauca.gesrotes.service.ModuloService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModuloServiceImpl implements ModuloService{

    private ModuloRepository modulosRepository;
    private DocenteRepository docentesRepository;
    private  HorarioRepository horarioRepository;
    
    @Override
    public ModuloResponse registrarNombreModulo(ModuloRequest moduloRequest, long idDocente) {
        if(!docenteExiste(idDocente)){
            
            throw new ApplicationException("El Docente no existe");
        }
        Docente varDocente=docentesRepository.findById(idDocente).orElse(null);
        if (!esValidoNombre(moduloRequest)) {
            throw new ApplicationException("El Nombre de Modulo no es valido");
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
        List<ModuloDTO> resDto = modulosRepository.listaModulosSinHorarioAsignado(id_docente,id_asignatura).stream().map(ModuloMapper::mapModulo).collect(Collectors.toList());
        ModuloSinHorarioDTO resModuloSinHorario = new ModuloSinHorarioDTO();
        resModuloSinHorario.setModulos_sin_horarios(resDto);
        return resModuloSinHorario;
    }
    
    @Override
    public DocenteModuloDTO listarHorarios(Long id_Asignatura) {

        DocenteModuloDTO docente_modulo = new DocenteModuloDTO();

        List<DocenteDTO> docentes = docentesRepository.findByIdAsignatura(id_Asignatura)
        .stream()
        .map(DocenteMapper::mapearResponseDocenteModuloResponse)
        .collect(Collectors.toList());

        for(DocenteDTO dct : docentes)
            {
                List<ModuloDTO> modulos = modulosRepository.findByDocenteId(dct.getId())
                .stream()
                .map(ModuloMapper::mapModulo)
                .collect(Collectors.toList());
                
                for(ModuloDTO mdl : modulos)
                {
                    List<HorarioDTO> horarios = horarioRepository.getHorariosByIdModulo(mdl.getId())
                    .stream()
                    .map(HorarioMapper::toHorarioDTO)
                    .collect(Collectors.toList());

                    mdl.setHorario(horarios);
                }
                
                dct.setModulo(modulos);
            }
            docente_modulo.setDocente(docentes);
        return docente_modulo;
    }


}


