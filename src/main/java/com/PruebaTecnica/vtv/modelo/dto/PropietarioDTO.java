package com.PruebaTecnica.vtv.modelo.dto;

import java.util.Set;

public class PropietarioDTO {

    private Integer codigo;
    private String nombre;
    private String tipo;
    private String saldo;
    private Set<AutomovilDTO> automovilDTOS;

    public PropietarioDTO() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public Set<AutomovilDTO> getAutomovilDTOS() {
        return automovilDTOS;
    }

    public void setAutomovilDTOS(Set<AutomovilDTO> automovilDTOS) {
        this.automovilDTOS = automovilDTOS;
    }
}
