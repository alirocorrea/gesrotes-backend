package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "rote")
public class Rote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rot_codigo")
    private Long rotCodigo;
    @Column(name = "rot_nombre")
    private String rotNombre;
    //private Etiqueta
    //private grupo
}
