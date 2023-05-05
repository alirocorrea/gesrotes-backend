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
}
