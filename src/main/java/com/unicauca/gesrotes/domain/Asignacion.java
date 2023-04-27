package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_Grupos")
    private Grupo grupo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_HorariosModulos")
    private HorarioModulo horarioModulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_Ciclos")
    private Ciclo ciclo;
}
