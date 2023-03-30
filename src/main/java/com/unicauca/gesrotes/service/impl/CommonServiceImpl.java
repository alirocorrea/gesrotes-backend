package com.unicauca.gesrotes.service.impl;

import com.unicauca.gesrotes.common.Messages;
import com.unicauca.gesrotes.domain.Configuracion;
import com.unicauca.gesrotes.dto.response.PingResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.ConfiguracionMapper;
import com.unicauca.gesrotes.repository.ConfiguracionRepository;
import com.unicauca.gesrotes.service.CommonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CommonServiceImpl implements CommonService {

    private ConfiguracionRepository configuracionRepository;

    @Override
    public PingResponse getPing() {
        Configuracion configuracion = this.configuracionRepository.findById(1L)
                .orElseThrow(() -> new ApplicationException(Messages.CONFIGURACION_DB_NO_ENCONTADA));
        return ConfiguracionMapper.toPingResponse(configuracion);
    }
}
