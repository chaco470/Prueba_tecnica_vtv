package com.PruebaTecnica.vtv.modelo.mapper;

import com.PruebaTecnica.vtv.modelo.dto.AutomovilDTO;
import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Automovil;

import java.util.Set;
import java.util.stream.Collectors;

public class AutomovilMapper {

    public static AutomovilDTO mapAuto(Automovil automovil) {
        Set<InspeccionDTO> collect = automovil.getInspecciones().stream().map(InspeccionMapper::mapInspeccion).collect(Collectors.toSet());
        AutomovilDTO dto = new AutomovilDTO();
        dto.setCodigo(automovil.getId());
        dto.setModelo(automovil.getModelo());
        dto.setDominio(automovil.getDominio());
        dto.setMarca(automovil.getMarca());
        dto.setNombrePropietario(automovil.getPropietario().getNombre());
        dto.setIdPropietario(automovil.getPropietario().getId());
        dto.setInspeccionDTOS(collect);
        return dto;
    }
}
