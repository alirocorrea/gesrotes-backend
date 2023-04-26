package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "programas")
public class Programa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programas")
    private Long id;
    private String codigosnies;
    private String nombre;
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Docente> docentes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_facultades")
    private Facultad facultad;
    @OneToMany(mappedBy = "programa",cascade = CascadeType.ALL)
    private List<ContactoPrograma> contactoProgramas;
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Asignatura> asignaturas;

    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public void agregarDocente(Docente docente){
        if(this.docentes == null){
            this.docentes = new ArrayList<>();
        }
        this.docentes.add(docente);
    }
    public void agregarContactoProgama(ContactoPrograma contactoPrograma){
        if(this.contactoProgramas == null){
            this.contactoProgramas = new ArrayList<>();
        }
        this.contactoProgramas.add(contactoPrograma);
    }

    public  void agregarAsignatura(Asignatura asignatura){
        if(this.asignaturas == null){
            this.asignaturas = new ArrayList<>();
        }
        this.asignaturas.add(asignatura);
    }

    public void agregarEstudiante(Estudiante estudiante){
        if(this.estudiantes == null){
            this.estudiantes = new ArrayList<>();
        }
        this.estudiantes.add(estudiante);
    }
}
