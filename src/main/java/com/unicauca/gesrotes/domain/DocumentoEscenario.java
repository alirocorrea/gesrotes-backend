package com.unicauca.gesrotes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "DocumentosEscenarios")
public class DocumentoEscenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_DocumentosEscenarios")
    private Long id;
    private Date vigencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_EscenariosDocEsc")
    private Escenario escenario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_Archivo")
    private Archivo archivo;
    private String tipoDocumento;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaSubida")
    private Date fechaSubida;
    private Long tamano;
}
