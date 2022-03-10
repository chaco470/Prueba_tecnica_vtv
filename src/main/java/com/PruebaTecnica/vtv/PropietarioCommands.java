package com.PruebaTecnica.vtv;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Propietario;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import com.PruebaTecnica.vtv.servicios.contratos.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PropietarioCommands implements CommandLineRunner {

    @Autowired
    private PropietarioDAO propietarioDAO;

    @Autowired
    private AutomovilDAO automovilDAO;

    @Override
    public void run(String... args) throws Exception {
        /*
        Propietario propietario2 = new Propietario(null, "Antonio", "comun");
        Propietario propietario3 = new Propietario(null, "Roberto", "comun");
        Propietario propietario4 = new Propietario(null, "Saul", "comun");
        propietarioDAO.save(propietario2);
        propietarioDAO.save(propietario3);
        propietarioDAO.save(propietario4);*/
        //System.out.println(propietarioDAO.buscarPropietarioPorIdConInspeccionesPorAuto(1));
    }
}
