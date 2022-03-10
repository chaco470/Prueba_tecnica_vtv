package com.PruebaTecnica.vtv.Repositorio;

import com.PruebaTecnica.vtv.modelo.entidades.Automovil;
import com.PruebaTecnica.vtv.modelo.entidades.Inspeccion;
import com.PruebaTecnica.vtv.repositorio.InspeccionRepository;
import datos.DatosDummy;
import com.PruebaTecnica.vtv.repositorio.AutomovilRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AutoRepositoryTest {

    @BeforeEach
    void setUp() {
        DatosDummy.auto1.setPropietario(DatosDummy.propietario1);
        DatosDummy.auto2.setPropietario(DatosDummy.propietario1);
        DatosDummy.auto3.setPropietario(DatosDummy.propietario2);
        DatosDummy.auto4.setPropietario(DatosDummy.propietario3);
        DatosDummy.inspector1.realizarInspeccion(DatosDummy.auto1);
        DatosDummy.inspector1.realizarInspeccion(DatosDummy.auto2);
        DatosDummy.inspector2.realizarInspeccion(DatosDummy.auto3);
        DatosDummy.inspector2.realizarInspeccion(DatosDummy.auto4);
        automovilRepository.save(DatosDummy.auto1);
        automovilRepository.save(DatosDummy.auto2);
        automovilRepository.save(DatosDummy.auto3);
        automovilRepository.save(DatosDummy.auto4);

    }

    @Autowired
    AutomovilRepository automovilRepository;

    @Autowired
    InspeccionRepository inspeccionRepository;

    @Test
    void AutosInspeccionadosUltimaSemana(){
        List<Automovil> autos = (List<Automovil>) automovilRepository.AutosInspeccionadosUltimaSemana(LocalDateTime.now());
        Optional<Inspeccion> oInspeccion = inspeccionRepository.findById(1);
        Inspeccion inspeccion = oInspeccion.get();
        inspeccion.setFechaInspección(LocalDateTime.now().minusDays(30));
        inspeccionRepository.save(inspeccion);
        assertThat(autos.size() == 3).isTrue();
    };


}
