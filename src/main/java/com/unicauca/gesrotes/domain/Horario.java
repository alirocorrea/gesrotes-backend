package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hor_codigo")
    private Long id;
    @Column(name = "hor_nombre")
    private String nombre;
    @Column(name = "hor_horaInicio")
    private Date horaInicio;
    @Column(name = "hor_horaFin")
    private Date horaFin;
    @Column(name = "hor_dia")
    private String dia;
    @Column(name = "hor_fechaInicio")
    private Date fechaInicio;
    @Column(name = "hor_fechaFin")
    private Date fechaFin;
}
