package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "horariosmodulos")
public class HorarioModulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_horariosmodulos")
    private Long id;
    @Column(name = "dia")
    private String dia;
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "horafin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_modulos")
    private Modulo modulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_servicioshm")
    private Servicio servicio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_escenarioshm")
    private Escenario escenario;
    @OneToMany(mappedBy = "horarioModulo", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    public void agregarAsignacion(Asignacion asignacion){
        if(this.asignaciones == null){
            this.asignaciones = new ArrayList<>();
        }
        this.asignaciones.add(asignacion);
    }

}
