package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tur_codigo")
    private Long turCodigo;
/*    @Column(name ="Grupo_gru_codigo")
    @ManyToOne
    private Grupo grupo;*/
}
