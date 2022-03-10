package com.PruebaTecnica.vtv.controlador;

import com.PruebaTecnica.vtv.modelo.dto.InspectorDTO;
import com.PruebaTecnica.vtv.modelo.dto.PropietarioDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.modelo.entidades.Propietario;
import com.PruebaTecnica.vtv.modelo.mapper.InspectorMapper;
import com.PruebaTecnica.vtv.modelo.mapper.PropietarioMapper;
import com.PruebaTecnica.vtv.servicios.contratos.PropietarioDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController extends GenericController<Propietario, PropietarioDAO>{

    public PropietarioController(PropietarioDAO service) {
        super(service);
        this.nombreEntidad ="Propietario";
    }

    @GetMapping
    public ResponseEntity<?> obtenerInspectores(){
        Map<String, Object> mensaje = new HashMap();
        List<Propietario> propietarios = super.obtenerTodos();
        if (propietarios.isEmpty()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<PropietarioDTO> propietarosDTO = propietarios.stream().map(PropietarioMapper::mapPropietario).collect(Collectors.toList());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", propietarosDTO);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarAutoId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap();
        Optional<Propietario> propietario = service.findById(id);
        if (!propietario.isPresent()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("succes", String.format("no se encontro ningun auto con id: %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        PropietarioDTO propietarioDTO = PropietarioMapper.mapPropietario(propietario.get());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", propietarioDTO);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAutomovil(@RequestBody Propietario entidad) {
        Map<String, Object> message = new HashMap<>();
        message.put("succes", Boolean.TRUE);
        message.put("datos", super.altaEntidad(entidad));
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }
}
