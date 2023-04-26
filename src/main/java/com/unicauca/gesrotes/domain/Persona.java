package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    private Long identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String direccion;
    private String genero;
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String clave;
    @Column(name = "tiposangre")
    private String tipoSangre;
    @Column(name = "lugarnacimiento")
    private String lugarNacimiento;
    @OneToOne(mappedBy = "persona")
    private Docente docente;
    @OneToOne(mappedBy = "persona")
    private Coordinador coordinador;
    @OneToOne(mappedBy = "persona")
    private Estudiante estudiante;

}
