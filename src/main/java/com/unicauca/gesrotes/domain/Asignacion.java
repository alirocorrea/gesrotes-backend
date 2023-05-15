package com.unicauca.gesrotes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Asignaciones")
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
