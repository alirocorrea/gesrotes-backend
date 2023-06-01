package com.unicauca.gesrotes.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupos")
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date vigencia;
    private String activo;
    @ManyToMany(mappedBy = "grupos")
    private List<Estudiante> estudiantes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_asignaturasgru")
    private Asignatura asignatura;
    @OneToMany(mappedBy = "grupo",cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    public void agragarEstudiante(Estudiante estudiante){
        if(this.estudiantes == null){
            this.estudiantes = new ArrayList<>();
        }
        this.estudiantes.add(estudiante);
    }

    public void agregarAsignacion(Asignacion asignacion){
        if(this.asignaciones == null){
            this.asignaciones = new ArrayList<>();
        }
        this.asignaciones.add(asignacion);
    }

}
