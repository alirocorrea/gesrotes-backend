package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Facultades")
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_facultades")
    private Long id;
    private String nombre;
    private String ubicacion;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL)
    private List<Programa> programas;

    public void agregarPrograma(Programa programa){
        if(this.programas == null){
            this.programas = new ArrayList<>();
        }
        this.programas.add(programa);
    }

}
