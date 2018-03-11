package activa.Expendio.controllers;

import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import javax.servlet.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerInternos() throws ServletException {
        return new ResponseEntity<>(internosRepository.getInternos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerInternosActivos() throws ServletException {
        return new ResponseEntity<>(internosRepository.getActivos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/inactive", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerInternosInactivos() throws ServletException {
        return new ResponseEntity<>(internosRepository.getInactivos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/actual", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerInternosActivosNoEliminados() throws ServletException {
        return new ResponseEntity<>(internosRepository.getNoEliminadosYActivos(), HttpStatus.OK);
    }

//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public ResponseEntity<?> registrar(@RequestBody Interno interno) {
//        Interno resp = internosRepository.adicionar(interno);
//        return new ResponseEntity<>(resp, HttpStatus.OK);
//    }
}
