package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.dto.response.EliminarAsignacionResponse;
import com.unicauca.gesrotes.repository.AsignacionRepository;
import com.unicauca.gesrotes.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

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
