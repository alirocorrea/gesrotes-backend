package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "asingatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Asi_codigo")
    private Long codigo;
    @Column(name = "Asi_nombre")
    private String nombre;
}
