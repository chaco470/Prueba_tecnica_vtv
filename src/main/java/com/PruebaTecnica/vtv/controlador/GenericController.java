package com.PruebaTecnica.vtv.controlador;

import com.PruebaTecnica.vtv.servicios.contratos.GenericDAO;


import java.util.List;
import java.util.Optional;


public class GenericController <E, S extends GenericDAO<E>>{
    protected final S service;
    protected String nombreEntidad;

    public GenericController(S service) {
        this.service = service;
    }

    public List<E> obtenerTodos(){
        return (List<E>) service.findAll();
    }

    public Optional<E> buscarPorId(Integer id){
        return service.findById(id);
    }

    public E altaEntidad(E entidad){
        return service.save(entidad);
    }
}

