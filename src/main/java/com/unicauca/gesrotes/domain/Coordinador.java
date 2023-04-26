package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "coordinadores")
public class Coordinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinadores")
    private Long id;
    private String rol;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_personascoordinador")
    private Persona persona;
}
