package com.PruebaTecnica.vtv.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "inspecciones")
public class Inspeccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50)
    private LocalDateTime fechaInspección;
    @Column(nullable = false,length = 50)
    private String estadoInspección;
    @Column(nullable = false,length = 50)
    private String exento;
    @ManyToOne
    @JoinColumn(name = "inspector_id", foreignKey = @ForeignKey(name = "FK_INSPECTOR_ID"))
    @JsonIgnoreProperties({"inspecciones"})
    private Inspector inspector;
    @ManyToOne
    @JoinColumn(name = "automovil_id", foreignKey = @ForeignKey(name = "FK_AUTOMOVIL_ID"))
    @JsonIgnoreProperties({"inspecciones"})
    private Automovil automovil;

    public Inspeccion() {
    }

    public Inspeccion(Integer id, String estadoInspección, String exento) {
        this.id = id;
        setFechaInspección(LocalDateTime.now());
        this.estadoInspección = estadoInspección;
        this.exento = exento;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaInspección() {
        return fechaInspección;
    }

    public void setFechaInspección(LocalDateTime fechaInspección) {
        this.fechaInspección = fechaInspección;
    }

    public String getEstadoInspección() {
        return estadoInspección;
    }

    public void setEstadoInspección(String estadoInspección) {
        this.estadoInspección = estadoInspección;
    }

    public String getExento() {
        return exento;
    }

    public void setExento(String exento) {
        this.exento = exento;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    @Override
    public String toString() {
        return "Inspeccion{" +
                "id=" + id +
                ", fechaInspección=" + fechaInspección +
                ", estadoInspección='" + estadoInspección + '\'' +
                ", exento='" + exento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspeccion that = (Inspeccion) o;
        return Objects.equals(id, that.id) && Objects.equals(fechaInspección, that.fechaInspección);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInspección);
    }
}
