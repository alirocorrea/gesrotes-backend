package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Modulos")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Modulos")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_DocentesMod")
    private Docente docente;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL)
    private List<HorarioModulo> horariosModulos;

    public void agregarHorarioModulo(HorarioModulo horariosModulos){
        if(this.horariosModulos == null){
            this.horariosModulos = new ArrayList<>();
        }
        this.horariosModulos.add(horariosModulos);
    }
}
