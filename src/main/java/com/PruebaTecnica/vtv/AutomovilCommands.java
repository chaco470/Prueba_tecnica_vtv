package com.PruebaTecnica.vtv;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.modelo.entidades.Inspector;
import com.PruebaTecnica.vtv.modelo.numeradores.EstadoApartado;
import com.PruebaTecnica.vtv.servicios.contratos.AutomovilDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AutomovilCommands implements CommandLineRunner {

    @Autowired
    private AutomovilDAO automovilDAO;

    @Override
    public void run(String... args) throws Exception {
        /*Automovil automovil = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford", "2001");
        Automovil auto2 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.INTERMEDIO, "unico", "citroen","picaso");
        Automovil auto3 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","ka");
        Automovil auto4 = new Automovil(null, EstadoApartado.INACEPTABLE, EstadoApartado.INTERMEDIO, "unico", "renault","12");
        Automovil auto5 = new Automovil(null, EstadoApartado.INTERMEDIO, EstadoApartado.INTERMEDIO, "unico", "peugeot","206");
        Automovil auto6 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","fiesta");
        Automovil auto7 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","fiesta");
        Automovil auto8 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "renault","kangoo");
        Automovil auto9 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "toyota","yaris");
        Automovil auto10 = new Automovil(null, EstadoApartado.ACEPTABLE, EstadoApartado.ACEPTABLE, "unico", "ford","f-100");
        List<Automovil> saves = new ArrayList();
        saves.add(automovilDAO.save(auto2));
        saves.add(automovilDAO.save(auto3));
        saves.add(automovilDAO.save(auto4));
        saves.add(automovilDAO.save(auto5));
        saves.add(automovilDAO.save(auto6));
        saves.add(automovilDAO.save(auto7));
        saves.add(automovilDAO.save(auto8));
        saves.add(automovilDAO.save(auto9));
        saves.add(automovilDAO.save(auto10));*/
        //automovilDAO.findAll().forEach(System.out::println);
        //System.out.println(automovilDAO.AutosPorCalidadInspeccionUltimaInpeccion("apto"));
    }
}
