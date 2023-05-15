package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.common.Messages;
import com.unicauca.gesrotes.domain.Asignacion;
import com.unicauca.gesrotes.domain.Ciclo;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.AsignacionDTO;
import com.unicauca.gesrotes.dto.DocenteDTO;
import com.unicauca.gesrotes.dto.ModuloDTO;
import com.unicauca.gesrotes.dto.request.CreateRoteRequest;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.AsignacionMapper;
import com.unicauca.gesrotes.mapper.DocenteMapper;
import com.unicauca.gesrotes.mapper.HorarioMapper;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.repository.AsignacionRepository;
import com.unicauca.gesrotes.repository.CicloRepository;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.repository.HorarioRepository;
import com.unicauca.gesrotes.service.RoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoteServiceImpl implements RoteService {

    private AsignacionRepository asignacionRepository;
    private GrupoRepository grupoRepository;
    private CicloRepository cicloRepository;
    private HorarioRepository horarioRepository;

    @Override
    public AsignacionDTO createRote(final CreateRoteRequest request) {
        Grupo grupo = grupoRepository.findById(request.getIdGrupo()).orElseThrow(() ->  new ApplicationException(Messages.ID_GRUPO_NO_ENCONTRADO));
        Ciclo ciclo = cicloRepository.findById(request.getIdCiclo()).orElseThrow(() ->  new ApplicationException(Messages.ID_CICLO_NO_ENCONTRADO));
        HorarioModulo horarioModulo = horarioRepository.findById(request.getIdHorarioModulo()).orElseThrow(() ->  new ApplicationException(Messages.ID_HORARIO_NO_ENCONTRADO));

        Asignacion asignacion = asignacionRepository.save(AsignacionMapper.createAsignacion(grupo, ciclo, horarioModulo));
        return getAsignacionResponse(asignacion);
    }

    private AsignacionDTO getAsignacionResponse(final Asignacion asignacionParam) {
        Asignacion asignacion = asignacionRepository.getAsignacion(asignacionParam.getId());

        HorarioModulo horarioModulo = asignacion.getHorarioModulo();
        Modulo modulo = horarioModulo.getModulo();
        Docente docente = modulo.getDocente();

        AsignacionDTO asignacionDTO = AsignacionMapper.toAsignacionDTO(asignacion);

        List<DocenteDTO> docenteDTOList = asignacionDTO.getDocentes();
        DocenteDTO docenteDTO = DocenteMapper.mapearResponseDocenteModuloResponse(docente);
        docenteDTOList.add(docenteDTO);

        List<ModuloDTO> moduloDTOList = docenteDTO.getModulos();
        ModuloDTO moduloDTO = moduloDTO = ModuloMapper.mapModulo(modulo);
        moduloDTOList.add(moduloDTO);
        moduloDTO.getHorarios().add(HorarioMapper.toHorarioDTO(horarioModulo));

        return asignacionDTO;
    }
}
