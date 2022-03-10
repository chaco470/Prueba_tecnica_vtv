package com.PruebaTecnica.vtv.modelo.dto;

public class InspeccionDTO {

    private Integer codigo;
    private String fechaInspeccion;
    private String estadoInspección;
    private String exento;
    private Integer idInspector;
    private Integer idAutomovil;

    public InspeccionDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getFechaInspeccion() {
        return fechaInspeccion;
    }

    public void setFechaInspeccion(String fechaInspeccion) {
        this.fechaInspeccion = fechaInspeccion;
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

    public Integer getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Integer idInspector) {
        this.idInspector = idInspector;
    }

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }
}
