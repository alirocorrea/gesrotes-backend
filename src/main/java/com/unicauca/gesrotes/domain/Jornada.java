package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Jornadas")
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jornadas")
    private Long id;
    private String descripcion;
    @Temporal(TemporalType.TIME)
    @Column(name = "horainicio")
    private Date horaInicio;
    @Temporal(TemporalType.TIME)
    @Column(name = "horafin")
    private Date horaFin;
    private Double duracion;
}
