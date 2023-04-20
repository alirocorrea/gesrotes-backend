package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.domain.Horario;
import com.unicauca.gesrotes.service.HorarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HorarioServiceImpl implements HorarioService {

    @Override
    public List<Horario> listaHorarioNoConfigurado(Long idDocente, Long idAsignatura) {
        return null;
    }
}
