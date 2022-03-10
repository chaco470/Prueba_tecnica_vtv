package com.PruebaTecnica.vtv.controlador;

import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.modelo.mapper.InspeccionMapper;
import com.PruebaTecnica.vtv.servicios.contratos.InspeccionDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inspecciones")
public class InspeccionController extends GenericController<Inspeccion, InspeccionDAO>{

    public InspeccionController(InspeccionDAO service) {
        super(service);
        this.nombreEntidad= "Inspeccion";
    }

    @GetMapping
    public ResponseEntity<?> obtenerInspecciones(){
        Map<String, Object> mensaje = new HashMap();
        List<Inspeccion> inspecciones = super.obtenerTodos();
        if (inspecciones.isEmpty()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<InspeccionDTO> autosDTO = inspecciones.stream().map(InspeccionMapper::mapInspeccion).collect(Collectors.toList());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", autosDTO);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarInspeccionId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap();
        Optional<Inspeccion> inspeccion = super.buscarPorId(id);
        if (!inspeccion.isPresent()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("succes", String.format("no se encontro ningun auto con id: %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        InspeccionDTO inspeccionDTO = InspeccionMapper.mapInspeccion(inspeccion.get());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", inspeccionDTO);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAutomovil(@RequestBody Inspeccion entidad) {
        Map<String, Object> message = new HashMap<>();
        message.put("succes", Boolean.TRUE);
        message.put("datos", super.altaEntidad(entidad));
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }
}
