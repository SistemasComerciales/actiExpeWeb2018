package activa.Expendio.controllers;

import activa.Expendio.persistencia.Interface.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Avuunita
 */
@RestController
@RequestMapping(value = "/activaExpendio/V1/internos")
public class InternosController {

    @Autowired
    public PersistenciaInternoInt internosRepository;
}
