package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.domain.Asignatura;
import com.unicauca.gesrotes.service.AsignarutaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AsignaturaServiceImpl implements AsignarutaService {

    @Override
    public Asignatura buscarporId(Long id) {
        Asignatura asignatura = this.buscarporId(id);
        return null;
    }
}
