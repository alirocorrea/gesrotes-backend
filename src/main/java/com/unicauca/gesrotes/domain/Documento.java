package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long id;
    private String nombre;
    private String extension;
    private String hash;
    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
    private List<DocumentoEscenario> documentosEscenario;

    public void agregarDocumentosEscenarios(DocumentoEscenario documentoEscenario){
        if(this.documentosEscenario == null){
            this.documentosEscenario = new ArrayList<>();
        }
        this.documentosEscenario.add(documentoEscenario);
    }
}
