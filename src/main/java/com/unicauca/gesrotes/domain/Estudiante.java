package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiantes")
    private Long id;
    private String codigo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_personasest")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_programasest")
    private Programa programa;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "gruposestudiantes",
        joinColumns = @JoinColumn(name="estudiantes_id_estudiantes"),
        inverseJoinColumns = @JoinColumn(name = "grupos_id_grupos")
    )
    private List<Grupo> grupos;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "asignaturasestudiantes",
            joinColumns = @JoinColumn(name="estudiantes_id_estudiantes"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id_asignaturas")
    )
    private List<Asignatura> asignaturas;
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<SeguimientoAcademico> seguimientoAcademiscos;

    public void agregarGrupo(Grupo grupo){
        if(this.grupos == null){
            this.grupos = new ArrayList<>();
        }
        this.grupos.add(grupo);
    }

    public void agregarAsignatura(Asignatura asignatura){
        if(this.asignaturas == null){
            this.asignaturas = new ArrayList<>();
        }
        this.asignaturas.add(asignatura);
    }

    public void agregarSeguimientoAcademico(SeguimientoAcademico seguimientoAcademisco){
        if(this.seguimientoAcademiscos == null){
            this.seguimientoAcademiscos = new ArrayList<>();
        }
        this.seguimientoAcademiscos.add(seguimientoAcademisco);
    }
}
