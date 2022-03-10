package com.PruebaTecnica.vtv.servicios.implementaciones;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.repositorio.AutomovilRepository;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AutomovilDAOImpl extends GenericDAOImpl<Automovil, AutomovilRepository> implements AutomovilDAO {

    @Autowired
    public AutomovilDAOImpl(AutomovilRepository repo) {
        super(repo);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Automovil> AutosInspeccionadosUltimaSemana(LocalDateTime fecha) {
        LocalDateTime nuevaFecha = LocalDateTime.now().minusDays(7);
        return repo.AutosInspeccionadosUltimaSemana(nuevaFecha);
    }

    @Override
    public Iterable<Automovil> AutosPorCalidadInspeccionUltimaInpeccion(String estado) {
        return repo.AutosPorCalidadInspeccionUltimaInpeccion(estado);
    }
}
