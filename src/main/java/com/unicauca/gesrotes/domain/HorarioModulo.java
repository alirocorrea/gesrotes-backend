package com.unicauca.gesrotes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HorariosModulos")
public class HorarioModulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_HorariosModulos")
    private Long id;
    @Column(name = "dia")
    private String dia;
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "horaFin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_Modulos")
    private Modulo modulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_ServiciosHM")
    private Servicio servicio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_EscenariosHM")
    private Escenario escenario;
    @OneToMany(mappedBy = "horarioModulo")
    private List<Asignacion> asignaciones;

    public void agregarAsignacion(Asignacion asignacion){
        if(this.asignaciones == null){
            this.asignaciones = new ArrayList<>();
        }
        this.asignaciones.add(asignacion);
    }

}
