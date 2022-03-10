package com.PruebaTecnica.vtv.modelo.dto;


import java.util.Set;

public class InspectorDTO {

    private Integer codigo;
    private String nombre;
    private Set<InspeccionDTO> inspeccionDTOS;

    public InspectorDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<InspeccionDTO> getInspeccionDTOS() {
        return inspeccionDTOS;
    }

    public void setInspeccionDTOS(Set<InspeccionDTO> inspeccionDTOS) {
        this.inspeccionDTOS = inspeccionDTOS;
    }
}
