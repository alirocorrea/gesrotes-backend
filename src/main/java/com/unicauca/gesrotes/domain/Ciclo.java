package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ciclos")
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciclos")
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechafin")
    private Date fechaFin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_asignaturascic")
    private Asignatura asignatura;
    @OneToMany(mappedBy = "ciclo", cascade = CascadeType.ALL)
    private List<Asignacion> asignaciones;

    public void agregarAsignacion(Asignacion asignacion){
        if(this.asignaciones == null){
            this.asignaciones = new ArrayList<>();
        }
        this.asignaciones.add(asignacion);
    }
}
