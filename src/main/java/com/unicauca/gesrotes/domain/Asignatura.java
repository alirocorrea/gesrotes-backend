package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Asignaturas")
    private Long id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "asignaturas")
    private List<Docente> docentes;
    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<Ciclo> ciclos;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_programasasig")
    private Programa programa;
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<Grupo> grupos;
    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL)
    private List<SeguimientoAcademisco> seguimientoAcademiscos;

    public void agregarDocente (Docente docente){
        if(this.docentes == null){
            this.docentes = new ArrayList<>();
        }
        this.docentes.add(docente);
    }

    public void agregarEstudiante(Estudiante estudiante){
        if(this.estudiantes == null){
            this.estudiantes = new ArrayList<>();
        }
        this.estudiantes.add(estudiante);
    }

    public void agregarCiclo(Ciclo ciclo){
        if(this.ciclos == null){
            this.ciclos = new ArrayList<>();
        }
        this.ciclos.add(ciclo);
    }

    public void agregarGrupo(Grupo grupo){
        if(this.grupos == null){
            this.grupos = new ArrayList<>();
        }
        this.grupos.add(grupo);
    }

    public void agregarSeguimientoAcademico(SeguimientoAcademisco seguimientoAcademisco){
        if(this.seguimientoAcademiscos == null){
            this.seguimientoAcademiscos = new ArrayList<>();
        }
        this.seguimientoAcademiscos.add(seguimientoAcademisco);
    }
}
