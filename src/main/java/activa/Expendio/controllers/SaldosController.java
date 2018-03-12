/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.controllers;

import activa.Expendio.ExpendioApplication;
import activa.Expendio.modelo.ConfirmacionRecarga;
import activa.Expendio.modelo.EstadoInterno;
import activa.Expendio.modelo.Interno;
import activa.Expendio.modelo.RecargaTelefono;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        System.out.println("GET");
        System.out.println("Consultanto Interno con td: " + tdInterno);
        Interno interno = Servicios.internosController.internosRepository.consultarPorTd(tdInterno);
        if (interno == null) {
            System.out.println("TD invalido");
            return new ResponseEntity<>("TD Invalido", HttpStatus.NOT_FOUND);
        } else {
            EstadoInterno ei = new EstadoInterno(interno.traerSaldoDiarioDisponibleValidado(), interno.traerSaldoMensualDisponibleValidado(), interno.getTd(), interno.getEstado());
            System.out.println("Saldo Diario Disponible: " + ei.getSaldoDiarioDisponible());
            System.out.println("Saldo Mensual Disponible: " + ei.getSaldoMensualDisponible());
            System.out.println("Estado: " + ei.isEstadoInterno());

            try {
                return new ResponseEntity<>(ei, HttpStatus.ACCEPTED);
            } catch (Exception ex) {
                Logger.getLogger(ExpendioApplication.class.getName()).log(Level.SEVERE, null, ex);
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
            }
        }
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path = "recargar", method = RequestMethod.POST/*, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE }*/)
    public ResponseEntity<?> manejadorConsultarGaleria(@RequestBody RecargaTelefono recarga) {
        System.out.println("POST");
        System.out.println("Recargando a interno con TD: " + recarga.getTd());
        System.out.println("Valor: " + recarga.getValor());
        System.out.println("Extension: " + recarga.getExtension());
        System.out.println("Fecha: " + recarga.getFecha());

        Interno interno = Servicios.internosController.internosRepository.consultarPorTd(recarga.getTd());
        if (interno == null) {
            System.out.println("TD Interno Invalido");
            ConfirmacionRecarga CR = new ConfirmacionRecarga();
            CR.setNumeroRecibo("");
            CR.setExpendioAsignado("");
            CR.setStatus(404);
            CR.setMensaje("TD invalido");
            return new ResponseEntity<>(CR, HttpStatus.NOT_FOUND);
        } else {
            if (interno.traerSaldoDiarioDisponibleValidado() < recarga.getValor()) {
                System.out.println("Saldo Insuficiente, saldo disponible interno: "+interno.traerSaldoDiarioDisponibleValidado());
                ConfirmacionRecarga CR = new ConfirmacionRecarga();
                CR.setNumeroRecibo("");
                CR.setExpendioAsignado("");
                CR.setStatus(406);
                CR.setMensaje("Saldo Insuficiente");
                return new ResponseEntity<>(CR, HttpStatus.NOT_ACCEPTABLE);
            }
            else{
                interno.registrarGasto(recarga.getValor());
                ConfirmacionRecarga CR = new ConfirmacionRecarga();
                CR.setNumeroRecibo("00002581");
                CR.setExpendioAsignado("001");
                CR.setStatus(202);
                CR.setMensaje("Ok");
                return new ResponseEntity<>(CR, HttpStatus.ACCEPTED);
            }
        }

//        ConfirmacionRecarga CR = new ConfirmacionRecarga();
//        CR.setNumeroRecibo("00002581");
//        CR.setExpendioAsignado("001");
//        CR.setStatus(202);
//        CR.setMensaje("Ok");
//        CR.setNumeroRecibo("");
//        CR.setExpendioAsignado("");
//        CR.setStatus(406);
//        CR.setMensaje("Saldo Insuficiente");
//        return new ResponseEntity<>(CR, HttpStatus.NOT_ACCEPTABLE);
//        return new ResponseEntity<>("Saldo Insuficiente", HttpStatus.NOT_ACCEPTABLE);
//        return new ResponseEntity<>("Otro Error", HttpStatus.NOT_FOUND);
    }

}
