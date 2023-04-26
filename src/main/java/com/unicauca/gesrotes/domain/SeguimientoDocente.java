package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "seguimientosdocentes")
public class SeguimientoDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String observacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_docentes")
    private Docente docente;
}
