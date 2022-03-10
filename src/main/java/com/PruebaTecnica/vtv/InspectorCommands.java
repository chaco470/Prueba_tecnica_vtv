package com.PruebaTecnica.vtv;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import com.PruebaTecnica.vtv.servicios.contratos.InspeccionDAO;
import com.PruebaTecnica.vtv.servicios.contratos.InspectorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class InspectorCommands implements CommandLineRunner {

    @Autowired
    InspectorDAO inspectorDAO;

    @Autowired
    AutomovilDAO automovilDAO;

    @Autowired
    InspeccionDAO inspeccionDAO;

    @Override
    public void run(String... args) throws Exception {
        /*Inspector inspector1 = new Inspector("Pablo");
        Inspector save = inspectorDAO.save(inspector1);
        System.out.println(save);

        Optional<Inspector> byId = inspectorDAO.findById(1);
        Inspector inspector1 = byId.get();
        Optional<Automovil> auto = automovilDAO.findById(1);
        Automovil autoAEvaluar = auto.get();
        Inspeccion save = inspeccionDAO.save(inspector1.realizarInspeccion(autoAEvaluar));
        inspectorDAO.save(inspector1);
        automovilDAO.save(autoAEvaluar);
        System.out.println(save);
        Iterable<Inspector> inspectors = inspectorDAO.inspectoresEinspeccionesDeLosUltimosTresDias(LocalDateTime.now().minusDays(100));
        System.out.println(inspectors);*/
        //System.out.println(autoAEvaluar.getInspecciones());

    }
}
