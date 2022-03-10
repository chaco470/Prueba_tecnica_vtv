package com.PruebaTecnica.vtv.repositorio;

import com.PruebaTecnica.vtv.modelo.entidades.Propietario;
import org.springframework.data.repository.CrudRepository;

public interface PropietarioRepository extends CrudRepository<Propietario, Integer> {
    /*@Query("select p from Propietario p join fetch p.autos a where p.id= ?1" +
            "select a from Automovil a join fetch a.inspeccion ins")
    Iterable<Propietario> buscarPropietarioPorIdConInspeccionesPorAuto(Integer id);*/
}
