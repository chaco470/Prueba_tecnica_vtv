package com.PruebaTecnica.vtv.modelo.entidades;

import com.PruebaTecnica.vtv.modelo.numeradores.EstadoApartado;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "inspectores")
public class Inspector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_inspector", nullable = false,length = 50)
    private String nombre;
    @OneToMany(mappedBy = "inspector", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "inspector"})
    private Set<Inspeccion> inspecciones;

    public Inspector() {
    }

    public Inspector(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Inspeccion> getInspecciones() {
        return inspecciones;
    }

    public void setInspecciones(Set<Inspeccion> inspecciones) {
        this.inspecciones = inspecciones;
    }

    public Inspeccion realizarInspeccion(Automovil auto){
        auto.getPropietario().setSaldo(auto.getPropietario().getSaldo() - 1000);
        Inspeccion inspeccion = new Inspeccion(null, "apto", "exento");
        ArrayList<EstadoApartado> estadosAuto = new ArrayList<>();
        estadosAuto.add(auto.getApartadoTecnico());
        estadosAuto.add(auto.getApartadoVisual());
        if(estadosAuto.contains(EstadoApartado.INTERMEDIO)&& !estadosAuto.contains(EstadoApartado.INACEPTABLE)){
            inspeccion.setEstadoInspección("condicional");
        }else if (estadosAuto.contains(EstadoApartado.INACEPTABLE)){
            inspeccion.setEstadoInspección("rechazado");
            inspeccion.setExento("comun");
        }else {
            auto.setOblea(LocalDateTime.now());
        }
        inspecciones.add(inspeccion);
        Set<Inspeccion> inspeccionesAuto = auto.getInspecciones();
        inspeccion.setInspector(this);
        inspeccion.setAutomovil(auto);
        inspeccionesAuto.add(inspeccion);
        auto.setInspecciones(inspeccionesAuto);
        return inspeccion;
    }

    public Boolean sePuedeRealizarInspeccion(Automovil automovil){
        return (automovil.getOblea().isBefore(LocalDateTime.now().plusYears(1))|| automovil.getOblea() == null)&& automovil.getPropietario().getSaldo() > 1000;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", inspecciones=" + inspecciones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspector inspector = (Inspector) o;
        return Objects.equals(id, inspector.id) && Objects.equals(nombre, inspector.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
