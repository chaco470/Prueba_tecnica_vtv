package com.PruebaTecnica.vtv.modelo.entidades;

import com.PruebaTecnica.vtv.modelo.numeradores.EstadoApartado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "automoviles")
public class Automovil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "apartado_visual")
    @Enumerated(EnumType.STRING)
    private EstadoApartado apartadoVisual;
    @Column(name = "apartado_tecnico")
    @Enumerated(EnumType.STRING)
    private EstadoApartado apartadoTecnico;
    @Column(name = "oblea")
    private LocalDateTime oblea;
    @Column(name = "dominio")
    private String dominio;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "propietario_id", foreignKey = @ForeignKey(name = "FK_PROPIETARIO_ID"))
    @JsonIgnoreProperties({"autos"})
    private Propietario propietario;
    @OneToMany(mappedBy = "automovil", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"automovil"})
    private Set<Inspeccion> inspecciones;

    public Automovil() {
    }

    public Automovil(Integer id, EstadoApartado apartadoVisual, EstadoApartado apartadoTecnico, String dominio, String marca, String modelo) {
        this.id = id;
        this.apartadoVisual = apartadoVisual;
        this.apartadoTecnico = apartadoTecnico;
        this.dominio = dominio;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoApartado getApartadoVisual() {
        return apartadoVisual;
    }

    public void setApartadoVisual(EstadoApartado apartadoVisual) {
        this.apartadoVisual = apartadoVisual;
    }

    public EstadoApartado getApartadoTecnico() {
        return apartadoTecnico;
    }

    public void setApartadoTecnico(EstadoApartado apartadoTecnico) {
        this.apartadoTecnico = apartadoTecnico;
    }

    public LocalDateTime getOblea() {
        return oblea;
    }

    public void setOblea(LocalDateTime oblea) {
        this.oblea = oblea;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Set<Inspeccion> getInspecciones() {
        return inspecciones;
    }

    public void setInspecciones(Set<Inspeccion> inspecciones) {
        this.inspecciones = inspecciones;
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "id=" + id +
                ", apartadoVisual=" + apartadoVisual +
                ", apartadoTecnico=" + apartadoTecnico +
                ", oblea=" + oblea +
                ", dominio='" + dominio + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Automovil automovil = (Automovil) o;
        return Objects.equals(id, automovil.id) && Objects.equals(dominio, automovil.dominio) && Objects.equals(marca, automovil.marca) && Objects.equals(modelo, automovil.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dominio, marca, modelo);
    }
}
