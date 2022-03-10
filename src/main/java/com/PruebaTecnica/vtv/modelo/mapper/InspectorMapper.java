package com.PruebaTecnica.vtv.modelo.mapper;

import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.dto.InspectorDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;

import java.util.Set;
import java.util.stream.Collectors;

public class InspectorMapper {
    public static InspectorDTO mapInspector(Inspector inspector){
        Set<InspeccionDTO> inspeccionesDTO = inspector.getInspecciones().stream().map(InspeccionMapper::mapInspeccion).collect(Collectors.toSet());
        InspectorDTO inspectorDTO = new InspectorDTO();
        inspectorDTO.setCodigo(inspector.getId());
        inspectorDTO.setNombre(inspector.getNombre());
        inspectorDTO.setInspeccionDTOS(inspeccionesDTO);
        return inspectorDTO;
    }
}
