package com.PruebaTecnica.vtv.controlador;

import com.PruebaTecnica.vtv.modelo.dto.AutomovilDTO;
import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.mapper.AutomovilMapper;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController extends GenericController<Automovil, AutomovilDAO>{


    public AutomovilController(AutomovilDAO service) {
        super(service);
        this.nombreEntidad= "Automovil";
    }

    @GetMapping
    public ResponseEntity<?>obtenerAutos(){
        Map<String, Object> mensaje = new HashMap();
        List<Automovil> autos = super.obtenerTodos();
        if (autos.isEmpty()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(mensaje);
        }
        List<AutomovilDTO> autosDTO = autos.stream().map(AutomovilMapper::mapAuto).collect(Collectors.toList());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", autosDTO);
        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarAutoId(@PathVariable Integer id){
        Map<String, Object> mensaje = new HashMap();
        Optional<Automovil> automovil = super.buscarPorId(id);
        if (!automovil.isPresent()){
            mensaje.put("succes", Boolean.FALSE);
            mensaje.put("succes", String.format("no se encontro ningun auto con id: %d", id));
            return ResponseEntity.badRequest().body(mensaje);
        }
        AutomovilDTO autoDTO = AutomovilMapper.mapAuto(automovil.get());
        mensaje.put("succes", Boolean.TRUE);
        mensaje.put("data", autoDTO);
        return ResponseEntity.ok(mensaje);
    }

    @PostMapping
    public ResponseEntity<?> altaAutomovil(@RequestBody Automovil entidad) {
        Map<String, Object> message = new HashMap<>();
        message.put("succes", Boolean.TRUE);
        message.put("datos", super.altaEntidad(entidad));
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("{id}")
    public void borrarPorId(@PathVariable Integer id){
        service.deleteById(id);
    }

    @GetMapping("/inspeccionadosUltimaSemana")
    public ResponseEntity<?> autosQuePoseenInspeccionesEnLosUltimos7Dias(){
        Map<String, Object> message = new HashMap<>();
        List<Automovil> automoviles = (List<Automovil>) service.AutosInspeccionadosUltimaSemana(LocalDateTime.now());
        if (automoviles.isEmpty()){
            message.put("succes", Boolean.FALSE);
            message.put("data", String.format("No se encontraron %ss cargadas",nombreEntidad));
            return ResponseEntity.badRequest().body(message);
        }
        List<AutomovilDTO> autosDTO =automoviles.stream().map(AutomovilMapper::mapAuto).collect(Collectors.toList());
        message.put("succes", Boolean.TRUE);
        message.put("data", autosDTO);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{calidadAuto}")
    public ResponseEntity<?>autosPorCalidadUltimaInspeccion(String estado){
        Map<String, Object> message = new HashMap<>();
        List<Automovil> automoviles = (List<Automovil>) service.AutosPorCalidadInspeccionUltimaInpeccion(estado);
        if (automoviles.isEmpty()){
            message.put("succes", Boolean.FALSE);
            message.put("data", String.format("No se encontraron autos con inspeccion: %ss",estado));
            return ResponseEntity.badRequest().body(message);
        }
        List<AutomovilDTO> automovilesDTO = automoviles.stream().map(AutomovilMapper::mapAuto).collect(Collectors.toList());
        message.put("succes", Boolean.TRUE);
        message.put("data", automovilesDTO);
        return ResponseEntity.ok(message);
    }
}
