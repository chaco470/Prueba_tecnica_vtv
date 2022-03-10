package com.PruebaTecnica.vtv.servicios.implementaciones;

import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.repositorio.InspeccionRepository;
import com.PruebaTecnica.vtv.servicios.contratos.InspeccionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspeccionDAOImpl extends GenericDAOImpl<Inspeccion, InspeccionRepository> implements InspeccionDAO {

    @Autowired
    public InspeccionDAOImpl(InspeccionRepository repo) {
        super(repo);
    }
}
