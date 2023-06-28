package com.unicauca.gesrotes.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.unicauca.gesrotes.common.Check;
import com.unicauca.gesrotes.domain.Estudiante;
import com.unicauca.gesrotes.dto.EstudianteDTO;
import com.unicauca.gesrotes.dto.GrupoDTO;
import com.unicauca.gesrotes.dto.response.ListarGruposResponse;
import com.unicauca.gesrotes.mapper.EstudianteMapper;
import org.springframework.stereotype.Service;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.domain.Grupo;
import com.unicauca.gesrotes.dto.response.GrupoResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.GrupoMapper;
import org.springframework.transaction.annotation.Transactional;
import com.unicauca.gesrotes.repository.AsignaturaRepository;
import com.unicauca.gesrotes.repository.GrupoRepository;
import com.unicauca.gesrotes.repository.GrupoEstudianteRepository;
import com.unicauca.gesrotes.service.GrupoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GrupoServiceImpl implements GrupoService {

    private GrupoRepository grupoRepository;
    private AsignaturaRepository asignaturaRepository;
    private GrupoEstudianteRepository gruposEstudiantesRepository;

    @Override
    public ListarGruposResponse getGruposAsignatura(final Long idAsignatura) {
         List<GrupoDTO> grupoDTOList = new ArrayList<>();
         List<Grupo> grupoList = grupoRepository.getByIdAsignatura(idAsignatura);
         for (Grupo grupo : grupoList) {
             GrupoDTO grupoDTO = GrupoMapper.toGrupoDTO(grupo);
             grupoDTO.setNumeroGrupo(grupoList.indexOf(grupo) + 1);
             grupoDTO.setEstudiantes(getEstudiantesGrupo(grupo));
             grupoDTOList.add(grupoDTO);
         }
         return ListarGruposResponse.builder().grupos(grupoDTOList).build();
    }

    private List<EstudianteDTO> getEstudiantesGrupo(Grupo grupo) {
        if(!Check.emptyList(grupo.getEstudiantes())) {
            return grupo.getEstudiantes().stream()
                    .map(EstudianteMapper::toEstudianteDTO)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    public GrupoResponse registrarGrupo(Long l) throws ParseException {
        if(!asignaturaExiste(l)){
            
            throw new ApplicationException("La Asignatura no existe");
        }

        Asignatura asignatura=asignaturaRepository.findById(l).get();
        Grupo grupo = GrupoMapper.mapearGrupo();
        grupo.setAsignatura(asignatura);

        List<Grupo> listaAsociados=grupoRepository.findByAsignatura(asignatura);

        return GrupoMapper.mapearResponse(grupoRepository.save(grupo), listaAsociados.size()+1);
    }

    private boolean asignaturaExiste(long idAsignatura){
        return asignaturaRepository.existsById(idAsignatura);
    }
    
    @Transactional
    @Override
    public void eliminarGrupo(Long id_grupo) {
        grupoRepository.deleteByid(id_grupo);
        gruposEstudiantesRepository.deleteBygrupoId(id_grupo); 
    }

    @Override
    @Transactional
    public void retirarEstudiante(Long id_estudiante, Long id_grupo) {
        gruposEstudiantesRepository.deleteByEstudianteAndGrupo(id_estudiante, id_grupo);
    }
    
}
