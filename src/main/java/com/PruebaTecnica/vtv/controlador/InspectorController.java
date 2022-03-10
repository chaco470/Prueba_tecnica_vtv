package com.PruebaTecnica.vtv.controlador;

import com.PruebaTecnica.vtv.modelo.dto.InspeccionDTO;
import com.PruebaTecnica.vtv.modelo.dto.InspectorDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.modelo.mapper.InspeccionMapper;
import com.PruebaTecnica.vtv.modelo.mapper.InspectorMapper;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import com.PruebaTecnica.vtv.servicios.contratos.InspeccionDAO;
import com.PruebaTecnica.vtv.servicios.contratos.InspectorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inspectores")
public class InspectorController extends GenericController<Inspector, InspectorDAO>{

    @Autowired
    AutomovilDAO automovilDAO;

    @Autowired
    InspeccionDAO inspeccionDAO;

    public InspectorController(InspectorDAO service) {
        super(service);
        this.nombreEntidad = "Inspector";
    }

    @GetMapping
    public ResponseEntity<?> obtenerInspectores(){
        Map<String, Object> mensaje = new HashMap();
        List<Inspector> inspectores = super.obtenerTodos();
        if (inspectores.isEmpty()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<InspectorDTO> autosDTO = inspectores.stream().map(InspectorMapper::mapInspector).collect(Collectors.toList());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", autosDTO);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarInspectorId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap();
        Optional<Inspector> inspector = super.buscarPorId(id);
        if (!inspector.isPresent()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("succes", String.format("no se encontro ningun auto con id: %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        InspectorDTO inspectorDTO = InspectorMapper.mapInspector(inspector.get());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", inspectorDTO);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaInspector(@RequestBody Inspector entidad) {
        Map<String, Object> message = new HashMap<>();
        message.put("succes", Boolean.TRUE);
        message.put("datos", super.altaEntidad(entidad));
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }

    @PutMapping("/{idInspector}/carrera/{idAutomovil}")
    public ResponseEntity<?>inspeccionarAuto(@PathVariable Integer idInspector,@PathVariable Integer idAutomovil){
        Map<String, Object> message = new HashMap<>();
        Optional<Inspector> oInspector = super.buscarPorId(idInspector);
        Optional<Automovil> oAuto = automovilDAO.findById(idAutomovil);
        if (!oInspector.isPresent()||!oAuto.isPresent())  {
            message.put("succes", Boolean.FALSE);
            message.put("succes", String.format("El auto con id: %d o el inspector con id: %d no existen", idAutomovil, idInspector));
            return ResponseEntity.badRequest().body(message);
        }
        Inspector inspector = oInspector.get();
        Automovil auto = oAuto.get();

        if (inspector.sePuedeRealizarInspeccion(auto)){
            Inspeccion save = inspeccionDAO.save(inspector.realizarInspeccion(auto));
            super.altaEntidad(inspector);
            InspeccionDTO inspeccionDTO = InspeccionMapper.mapInspeccion(save);
            automovilDAO.save(auto);
            message.put("succes", Boolean.TRUE);
            message.put("datos", inspeccionDTO);
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("UltimasInspecciones")
    public ResponseEntity<?> ultimasInspeccionesInspector(){
        List<Inspector> inspectors = (List<Inspector>) service.inspectoresEinspeccionesDeLosUltimosTresDias(LocalDateTime.now());
        Map<String, Object> message = new HashMap<>();
        if (inspectors.isEmpty()){
            message.put("succes", Boolean.FALSE);
            message.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(message);
        }
        List<InspectorDTO> inspecotrsDto = inspectors.stream().map(InspectorMapper::mapInspector).collect(Collectors.toList());
        message.put("succes", Boolean.TRUE);
        message.put("data", inspecotrsDto);
        return ResponseEntity.ok(message);
    }
}
