package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.EliminarAsignacionResponse;

public interface AsignacionService {

    EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCiclo(Long id_grupo, Long id_ciclo);
    EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCicloIdHorario(Long id_grupo, Long id_ciclo, Long id_Horario);
}
