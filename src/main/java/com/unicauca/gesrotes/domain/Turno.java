package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_jornadas")
    private Jornada jornada;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_etiquetas")
    private Etiqueta etiqueta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_escenarios")
    private Escenario escenario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_estudiantestu")
    private Estudiante estudiante;
}
