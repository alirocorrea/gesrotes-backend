package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.common.Messages;
import com.unicauca.gesrotes.domain.Horario;
import com.unicauca.gesrotes.dto.response.HorarioResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.repository.HorarioRespository;
import com.unicauca.gesrotes.service.HorarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HorarioServiceImpl implements HorarioService {

    private HorarioRespository horarioRespository;

    @Override
    public List<HorarioResponse> listaHorarioNoConfigurado(Long idDocente, Long idAsignatura) {
        List<Horario> respuesta = this.horarioRespository.listarHorarioNoOcupados(idDocente,idAsignatura);
        return null;
    }
}
