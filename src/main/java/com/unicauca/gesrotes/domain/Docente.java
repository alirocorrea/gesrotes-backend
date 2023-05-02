package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Long id;
    @Column(name = "codigo")
    private Long codigo;
    @Column(name = "cargoAcademicoAdministrativo")
    private String cargoAcademicoAdministrativo;
    @Column(name = "escalafon")
    private String escalafon;
    @Column(name = "tipoVinculacion")
    private String tipoVinculacion;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="asignaturadocentes",
            joinColumns =  @JoinColumn(name = "docentes_id_docente"),
            inverseJoinColumns = @JoinColumn(name = "asignaturas_id_asignaturas")
    )
    private List<Asignatura> asignaturas;
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    private List<Modulo> modulos;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id_PersonasDoc")
    private Persona persona;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_ProgramasDoc")
    private Programa programa;

    @OneToMany(mappedBy = "docente",cascade = CascadeType.ALL)
    private List<SeguimientoDocente> seguimientosDocentes;

    public void agregarModulo(Modulo modulo){
        if(this.modulos == null){
            this.modulos = new ArrayList<>();
        }
        this.modulos.add(modulo);
    }

    public void agregarSeguimientosDocentes(SeguimientoDocente seguimientoDocente){
        if(this.seguimientosDocentes == null){
            this.seguimientosDocentes = new ArrayList<>();
        }
        this.seguimientosDocentes.add(seguimientoDocente);
    }
}
