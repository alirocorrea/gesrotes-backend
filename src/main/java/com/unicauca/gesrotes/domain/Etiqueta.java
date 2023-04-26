package com.unicauca.gesrotes.domain;

import javax.persistence.*;

@Entity
@Table(name = "etiquetas")
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etiquetas")
    private Long id;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_escenarioseti")
    private Escenario escenario;
}
