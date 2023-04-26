package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "escenarios")
public class Escenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escenarios")
    private Long id;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
    private List<HorarioModulo> horariosmodulos;
    @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
    private List<Servicio> servicios;
    @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
    private List<DocumentoEscenario> documentosEscenario;
    @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL)
    private List<Etiqueta> etiquetas;

    public void agregarHorarioModulo(HorarioModulo horariosModulos){
        if(this.horariosmodulos == null){
            this.horariosmodulos = new ArrayList<>();
        }
        this.horariosmodulos.add(horariosModulos);
    }

    public void agregarServicio(Servicio servicio){
        if(this.servicios == null){
            this.servicios = new ArrayList<>();
        }
        this.servicios.add(servicio);
    }

    public void agregarDocumentoEscenario(DocumentoEscenario documentoEscenario){
        if(this.documentosEscenario == null){
            this.documentosEscenario = new ArrayList<>();
        }
        this.documentosEscenario.add(documentoEscenario);
    }

    public void agregarEtiqueta(Etiqueta etiqueta){
        if(this.etiquetas == null){
            this.etiquetas = new ArrayList<>();
        }
        this.etiquetas.add(etiqueta);
    }
}
