package com.PruebaTecnica.vtv.servicios.implementaciones;

import com.PruebaTecnica.vtv.modelo.entidades.Propietario;
import com.PruebaTecnica.vtv.repositorio.PropietarioRepository;
import com.PruebaTecnica.vtv.servicios.contratos.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropietarioDAOImpl extends GenericDAOImpl<Propietario, PropietarioRepository> implements PropietarioDAO {

    @Autowired
    public PropietarioDAOImpl(PropietarioRepository repo) {
        super(repo);
    }

    /*@Override
    @Transactional(readOnly = true)
    public Iterable<Propietario> buscarPropietarioPorIdConInspeccionesPorAuto(Integer id) {
        return repo.buscarPropietarioPorIdConInspeccionesPorAuto(id);
    }*/
}
