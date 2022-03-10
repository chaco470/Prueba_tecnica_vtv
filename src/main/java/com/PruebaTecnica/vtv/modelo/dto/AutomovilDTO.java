package com.PruebaTecnica.vtv.modelo.dto;

import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;

import java.util.Set;

public class AutomovilDTO {

    private Integer codigo;
    private String dominio;
    private String marca;
    private String modelo;
    private String nombrePropietario;
    private Integer idPropietario;
    private Set<InspeccionDTO> inspeccionDTOS;

    public AutomovilDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public Integer getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Integer idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Set<InspeccionDTO> getInspeccionDTOS() {
        return inspeccionDTOS;
    }

    public void setInspeccionDTOS(Set<InspeccionDTO> inspeccionDTOS) {
        this.inspeccionDTOS = inspeccionDTOS;
    }
}
