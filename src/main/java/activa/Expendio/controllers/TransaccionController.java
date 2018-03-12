/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.controllers;

import activa.Expendio.persistencia.Interface.PersistenciaTransaccionInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping(value = "/activaExpendio/V1/Transaccion")
public class TransaccionController {
    @Autowired
    public PersistenciaTransaccionInt transaccionRepository; 
}
