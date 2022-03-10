package com.PruebaTecnica.vtv.repositorio;

import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface InspectorRepository extends CrudRepository<Inspector, Integer> {

    //@Query( "select i from Inspector i join fetch i.inspecciones ins where ins.fechaInspección > ?1")
    @Query("select distinct i from Inspector i left join i.inspecciones ins where ins.fechaInspección > ?1")
    Iterable<Inspector>inspectoresEinspeccionesDeLosUltimosTresDias(LocalDateTime fecha);
}
