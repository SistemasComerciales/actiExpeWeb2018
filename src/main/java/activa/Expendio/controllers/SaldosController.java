/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.controllers;

import activa.Expendio.ExpendioApplication;
import activa.Expendio.modelo.EstadoInterno;
import activa.Expendio.modelo.RecargaTelefono;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
@RequestMapping(value = "/activaExpendio/V1")
public class SaldosController {
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "saldos/{tdInterno}", method = RequestMethod.GET)
    public ResponseEntity<?> manejadorConsultarSaldosInternos(@PathVariable("tdInterno") String tdInterno) {
        EstadoInterno ei = new EstadoInterno(26351,859365, tdInterno, "2651851", true);
        try {
            return new ResponseEntity<>(ei, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ExpendioApplication.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "recargar", method = RequestMethod.POST)
    public ResponseEntity<?> manejadorConsultarGaleria(@RequestBody RecargaTelefono recarga) {
        System.out.println("Valor: "+recarga.getValor());
        System.out.println("TD: "+recarga.getTd());
        System.out.println("Extension: "+recarga.getExtension());
        System.out.println("Fecha: "+recarga.getFecha());
        try {
            return new ResponseEntity<>("Hecho", HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(ExpendioApplication.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    } 
    
}
