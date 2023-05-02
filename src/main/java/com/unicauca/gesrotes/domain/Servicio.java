package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicios")
    private Long id;
    private String descripcion;
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<HorarioModulo> horarioModulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_etiquetasser")
    private Etiqueta etiqueta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_escenariosser")
    private Escenario escenario;

    //metodo para agregar un HorarioModulo a un servicio
    public void agregarHorarioModulo(HorarioModulo horarioModulo){
        if(this.horarioModulo == null){
            this.horarioModulo = new ArrayList<>();
        }
        this.horarioModulo.add(horarioModulo);
    }

}
