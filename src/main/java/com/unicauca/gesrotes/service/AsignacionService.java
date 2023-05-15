package com.unicauca.gesrotes.service;

import com.unicauca.gesrotes.dto.response.EliminarAsignacionResponse;
import com.unicauca.gesrotes.dto.response.ListaAsignacionesResponse;

public interface AsignacionService {

    ListaAsignacionesResponse getListAsignaciones(Long idAsignatura);
    EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCiclo(Long id_grupo, Long id_ciclo);
    EliminarAsignacionResponse eliminarAsignacionesPorIdGrupoIdCicloIdHorario(Long id_grupo, Long id_ciclo, Long id_Horario);
}
