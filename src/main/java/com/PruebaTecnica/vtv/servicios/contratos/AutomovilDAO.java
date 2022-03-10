package com.PruebaTecnica.vtv.servicios.contratos;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;

import java.time.LocalDateTime;

public interface AutomovilDAO extends GenericDAO<Automovil>{

    Iterable<Automovil>AutosInspeccionadosUltimaSemana(LocalDateTime fecha);
    Iterable<Automovil>AutosPorCalidadInspeccionUltimaInpeccion(String estado);
}
