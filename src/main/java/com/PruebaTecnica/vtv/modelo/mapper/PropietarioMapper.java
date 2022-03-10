package com.PruebaTecnica.vtv.modelo.mapper;

import com.PruebaTecnica.vtv.modelo.dto.AutomovilDTO;
import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.dto.PropietarioDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Propietario;

import java.util.Set;
import java.util.stream.Collectors;

public class PropietarioMapper {

    public static PropietarioDTO mapPropietario(Propietario propietario){
        Set<AutomovilDTO> autosDTO = propietario.getAutos().stream().map(AutomovilMapper::mapAuto).collect(Collectors.toSet());
        PropietarioDTO propietarioDTO = new PropietarioDTO();
        propietarioDTO.setCodigo(propietario.getId());
        propietarioDTO.setNombre(propietarioDTO.getNombre());
        propietarioDTO.setTipo(propietario.getTipo());
        propietarioDTO.setSaldo(propietarioDTO.getSaldo());
        propietarioDTO.setAutomovilDTOS(autosDTO);
        return propietarioDTO;
    }
}
