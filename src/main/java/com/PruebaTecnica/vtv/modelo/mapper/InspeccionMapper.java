package com.PruebaTecnica.vtv.modelo.mapper;

import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;

public class InspeccionMapper {
    public static InspeccionDTO mapInspeccion(Inspeccion inspeccion){
        InspeccionDTO inspeccionDTO = new InspeccionDTO();
        inspeccionDTO.setCodigo(inspeccion.getId());
        inspeccionDTO.setEstadoInspección(inspeccion.getEstadoInspección());
        inspeccionDTO.setFechaInspeccion(inspeccionDTO.getFechaInspeccion());
        inspeccionDTO.setExento(inspeccion.getExento());
        inspeccionDTO.setIdInspector(inspeccion.getInspector().getId());
        inspeccionDTO.setIdAutomovil(inspeccion.getAutomovil().getId());
        return inspeccionDTO;
    }
}
