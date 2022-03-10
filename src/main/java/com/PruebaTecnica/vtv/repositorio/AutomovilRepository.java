package com.PruebaTecnica.vtv.repositorio;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface AutomovilRepository extends CrudRepository<Automovil, Integer> {


    @Query("select a from Automovil a join fetch a.inspecciones i where i.fechaInspección > ?1")
    Iterable<Automovil>AutosInspeccionadosUltimaSemana(LocalDateTime fecha);
    @Query(nativeQuery = true,
            value = "select * from automoviles a join (select * from inspecciones i where i.estado_inspección = ?1 order by i.fecha_inspección limit 1) AS inspec on inspec.automovil_id = a.id")
    Iterable<Automovil>AutosPorCalidadInspeccionUltimaInpeccion(String estado);
}
