package com.unicauca.gesrotes.service.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.unicauca.gesrotes.common.Messages;
import com.unicauca.gesrotes.domain.Escenario;
import com.unicauca.gesrotes.domain.Modulo;
import com.unicauca.gesrotes.domain.Servicio;
import com.unicauca.gesrotes.dto.HorarioDTO;
import com.unicauca.gesrotes.dto.HorariosModulosDTO;
import com.unicauca.gesrotes.dto.request.CreateHorarioRequest;
import com.unicauca.gesrotes.dto.response.CreateHorarioResponse;
import com.unicauca.gesrotes.exception.ApplicationException;
import com.unicauca.gesrotes.mapper.HorarioMapper;
import com.unicauca.gesrotes.repository.EscenarioRepository;
import com.unicauca.gesrotes.repository.ModuloRepository;
import com.unicauca.gesrotes.repository.ServicioRepository;
import com.unicauca.gesrotes.service.HorarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.repository.HorarioRepository;


@Service
@AllArgsConstructor
public class HorarioServiceImpl implements HorarioService {

    private  HorarioRepository horarioRepository;
    private ModuloRepository moduloRepository;
    private ServicioRepository servicioRepository;
    private EscenarioRepository escenarioRepository;

    @Override
    public void eliminarHorarioporId(long id_horariosmodulos) throws NotFoundException{

        Optional<HorarioModulo> horario  = horarioRepository.findById(id_horariosmodulos);

        if(horario.isPresent()){
            horarioRepository.deleteById(id_horariosmodulos);
        } else {
            throw new NotFoundException("El horario con ID " + id_horariosmodulos + " no existe");
        }
    }


    @Override
    public CreateHorarioResponse createHorario(final Long idModulo, final CreateHorarioRequest request) {
        Modulo modulo = moduloRepository.findById(idModulo)
                .orElseThrow(() -> new ApplicationException(Messages.ID_MODULO_NO_ENCONTRADO));
        Servicio servicio = servicioRepository.findById(request.getIdServicio())
                .orElseThrow(() -> new  ApplicationException(Messages.ID_SERVICIO_NO_ENCONTRADO));
        Escenario escenario = escenarioRepository.findById(request.getIdEscenario())
                .orElseThrow(() -> new  ApplicationException(Messages.ID_ESCENARIO_NO_ENCONTRADO));

        HorarioModulo horarioModulo = HorarioMapper.createHorario(request);
        horarioModulo.setModulo(modulo);
        horarioModulo.setServicio(servicio);
        horarioModulo.setEscenario(escenario);
        horarioRepository.save(horarioModulo);

        List<HorarioDTO> horarios = horarioRepository.getHorariosByIdModulo(idModulo)
                .stream()
                .map(HorarioMapper::toHorarioDTO)
                .collect(Collectors.toList());
        return HorarioMapper.toCreateHorarioResponse(modulo, horarios);
    }

    @Override
    public HorariosModulosDTO getHorariosModulos(Long id_docente, Long id_asignatura) {
        List<HorarioModulo> horarios = horarioRepository.findAllByDocenteAsignatura(id_docente, id_asignatura);
        HorariosModulosDTO horariosModulosDTO = HorarioMapper.horarioModuloToDTO(horarios);
        return horariosModulosDTO;
    }

}
