package com.PruebaTecnica.vtv.servicios.implementaciones;

import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.repositorio.InspectorRepository;
import com.PruebaTecnica.vtv.servicios.contratos.InspectorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
public class InspectorDAOImpl extends GenericDAOImpl<Inspector, InspectorRepository> implements InspectorDAO {

    @Autowired
    public InspectorDAOImpl(InspectorRepository repo) {
        super(repo);
    }

    @Override
    public Iterable<Inspector> inspectoresEinspeccionesDeLosUltimosTresDias(LocalDateTime fecha) {

        LocalDateTime fechanew = LocalDateTime.now().minusDays(3);
        return repo.inspectoresEinspeccionesDeLosUltimosTresDias(fechanew);
    }
}
