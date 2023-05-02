package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contactosprogramas")
public class ContactoPrograma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String telefono;
    private String correo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_programas")
    private Programa programa;
}
