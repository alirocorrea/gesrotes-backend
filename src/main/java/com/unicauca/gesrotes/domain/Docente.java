package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doce_codigoinst")
    private Long codigoinst;
    @Column(name = "doce_escalafon")
    private String escalafon;
    @Column(name = "doce_vinculacion")
    private String vinculacion;
    @Column(name = "doce_cargoAdAc")
    private String cargoAdAc;
    @Column(name = "doce_observacion")
    private String observacion;

    //private Persona persona;
}
