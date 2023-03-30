package com.unicauca.gesrotes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if (activo == null) {
            this.activo = Boolean.TRUE;
        }
        if (fechaCreacion == null) {
            this.fechaCreacion = LocalDateTime.now();
        }
    }
}
