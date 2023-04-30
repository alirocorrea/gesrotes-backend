package com.unicauca.gesrotes.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import com.unicauca.gesrotes.domain.HorarioModulo;
import com.unicauca.gesrotes.repository.HorarioRepository;



@Service
public class HorarioService {

    @Autowired
    private  HorarioRepository horarioRepository;
    
    public void eliminarHorarioporId(long id_horariosmodulos) throws NotFoundException{

        Optional<HorarioModulo> horario  = horarioRepository.findById(id_horariosmodulos);

        if(horario.isPresent()){
            horarioRepository.deleteById(id_horariosmodulos);
        } else {
            throw new NotFoundException("El horario con ID " + id_horariosmodulos + " no existe");
        }
    }

}
