package com.PruebaTecnica.vtv.servicios.contratos;

import com.PruebaTecnica.vtv.modelo.entidades.Inspector;

import java.time.LocalDateTime;

public interface InspectorDAO extends GenericDAO<Inspector> {

    Iterable<Inspector>inspectoresEinspeccionesDeLosUltimosTresDias(LocalDateTime fecha);
}
