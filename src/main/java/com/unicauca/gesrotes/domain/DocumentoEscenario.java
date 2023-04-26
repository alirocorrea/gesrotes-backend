package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "documentosescenarios")
public class DocumentoEscenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date vigencia;
    private Boolean activo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_escenariosdocesc")
    private Escenario escenario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_documento")
    private Documento documento;
}
