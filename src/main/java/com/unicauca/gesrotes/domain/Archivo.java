package com.unicauca.gesrotes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Archivo")
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Archivo")
    private Long id;
    private String nombre;
    private String extension;
    private String uuid;
    @OneToMany(mappedBy = "archivo", cascade = CascadeType.ALL)
    private List<DocumentoEscenario> documentosEscenario;

    public void agregarDocumentosEscenarios(DocumentoEscenario documentoEscenario){
        if(this.documentosEscenario == null){
            this.documentosEscenario = new ArrayList<>();
        }
        this.documentosEscenario.add(documentoEscenario);
    }
}
