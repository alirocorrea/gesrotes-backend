package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.domain.Asignacion;
import com.unicauca.gesrotes.domain.Docente;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.dto.AsignacionDTO;
import com.unicauca.gesrotes.dto.DocenteDTO;
import com.unicauca.gesrotes.dto.ModuloDTO;
import com.unicauca.gesrotes.dto.response.EliminarAsignacionResponse;
import com.unicauca.gesrotes.dto.response.ListaAsignacionesResponse;
import com.unicauca.gesrotes.mapper.AsignacionMapper;
import com.unicauca.gesrotes.mapper.DocenteMapper;
import com.unicauca.gesrotes.mapper.HorarioMapper;
import com.unicauca.gesrotes.mapper.ModuloMapper;
import com.unicauca.gesrotes.repository.AsignacionRepository;
import com.unicauca.gesrotes.repository.CicloRepository;
import com.unicauca.gesrotes.repository.DocenteRepository;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.repository.HorarioRepository;
import com.unicauca.gesrotes.repository.ModuloRepository;
import com.unicauca.gesrotes.service.AsignacionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AsignacionServiceImpl implements AsignacionService {

    private AsignacionRepository asignacionRepository;
    private CicloRepository cicloRepository;
    private GrupoRepository grupoRepository;
    private DocenteRepository docenteRepository;
    private ModuloRepository moduloRepository;
    private HorarioRepository horarioRepository;

    @Override
    public ListaAsignacionesResponse getListAsignaciones(final Long idAsignatura) {

        List<Asignacion> asignacionList = asignacionRepository.getAsignacionesByIdAsignatura(idAsignatura);

        List<AsignacionDTO> asignacionDTOList = new ArrayList<>();

        for (Asignacion asignacion: asignacionList) {
            HorarioModulo horarioModulo = asignacion.getHorarioModulo();
            Modulo modulo = horarioModulo.getModulo();
            Docente docente = modulo.getDocente();

            AsignacionDTO asignacionDTO = asignacionDTOList.stream().filter(a -> a.getIdGrupo().equals(asignacion.getGrupo().getId())
                    && a.getIdCiclo().equals(asignacion.getCiclo().getId())).findFirst().orElse(null);

            if(asignacionDTO == null) {
                asignacionDTO = AsignacionMapper.toAsignacionDTO(asignacion);
                asignacionDTOList.add(asignacionDTO);
            }

            List<DocenteDTO> docenteDTOList = asignacionDTO.getDocentes();
            DocenteDTO docenteDTO = docenteDTOList.stream().filter(d -> d.getId().equals(docente.getId())).findFirst().orElse(null);

            if(docenteDTO == null) {
                docenteDTO = DocenteMapper.mapearResponseDocenteModuloResponse(docente);
                docenteDTOList.add(docenteDTO);
            }

            List<ModuloDTO> moduloDTOList = docenteDTO.getModulos();
            ModuloDTO moduloDTO = moduloDTOList.stream().filter(m -> m.getId() == modulo.getId()).findFirst().orElse(null);

            if(moduloDTO == null) {
                moduloDTO = ModuloMapper.mapModulo(modulo);
                moduloDTOList.add(moduloDTO);
            }
            moduloDTO.getHorarios().add(HorarioMapper.toHorarioDTO(horarioModulo));
        }

        return ListaAsignacionesResponse.builder().asignaciones(asignacionDTOList).build();
    }

    @Override
    public EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCiclo(Long id_grupo, Long id_ciclo) {
        boolean borrado = asignacionRepository.eliminarAsignacionesPorIdGrupoIdCiclo(id_grupo,id_ciclo)  > 0;
        EliminarAsignacionResponse response =  EliminarAsignacionResponse.builder().borrado(borrado).build();
        return response;
    }

    @Override
    public EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCicloIdHorario(Long id_grupo, Long id_ciclo, Long id_Horario) {
        boolean borrado = asignacionRepository.eliminarAsignacionesPorIdGrupoIdCicloIdHorario(id_grupo,id_ciclo,id_Horario) > 0;
        EliminarAsignacionResponse response = EliminarAsignacionResponse.builder().borrado(borrado).build();
        return response;
    }
}
